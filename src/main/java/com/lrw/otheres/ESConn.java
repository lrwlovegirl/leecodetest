package com.lrw.otheres;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

public class ESConn {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))


        );
        //1创建一个索引（一个数据库,一张表，因为现在type的定义被去掉了）
        CreateIndexResponse indexName = client.indices().create(new CreateIndexRequest("indexName"), RequestOptions.DEFAULT);
        //索引相应
        boolean acknowledged = indexName.isAcknowledged();
        //2、查询索引详情
        GetIndexRequest getIndexRequest = new GetIndexRequest("indexName","还能继续添加");
        GetIndexResponse getIndexResponse = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        //删除索引就是deleteIndexRequest
        //-------------------------------------------------------------------------------------------

        //插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("indexName").id("supplier_id");
        indexRequest.source("some Object json", XContentType.JSON);
        IndexResponse addDataResp = client.index(indexRequest, RequestOptions.DEFAULT);
        //批量插入数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("indexName").id("supplier_id").source("one object json",XContentType.JSON))
                   .add(new IndexRequest().index("indexName").id("supplier_id").source("two object json",XContentType.JSON))
                   .add(new IndexRequest().index("indexName").id("supplier_id").source("three object json",XContentType.JSON));

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);


        //修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("indexName").id("supplier_id");
        updateRequest.doc(XContentType.JSON,"supplier_name","新的供应商名称");
        UpdateResponse updateResponse = client.update(new UpdateRequest(), RequestOptions.DEFAULT);

        //查询数据

        //1.指定id查询
        GetRequest getRequest = new GetRequest();
        getRequest.index("indexName").id("supplier_id");
        GetResponse documentFields = client.get(getRequest, RequestOptions.DEFAULT);
        String sourceAsString = documentFields.getSourceAsString();
        //1.1 查询全量数据，相当于select * from user

        SearchRequest searchRequest = new SearchRequest().indices("indexName").source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));

        SearchResponse searchAllResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchAllResponse.getHits();
        for (SearchHit hit : hits) {
            //每一条数据
            hit.getSourceAsString();
        }

        //1.2 条件查询 select * from user where name = '' and age =  '' and id > 1
        SearchRequest whereRequest = new SearchRequest().indices("indexName").source(new SearchSourceBuilder().
                query(QueryBuilders.termQuery("supplier_name", "供应商名称")));
        SearchResponse whereResponse = client.search(whereRequest,RequestOptions.DEFAULT);
        //分页查询
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.from(1).size(10);
        SearchRequest pageSearchRequest = new SearchRequest().indices("indexName").source(builder);
        SearchResponse pageResp = client.search(pageSearchRequest, RequestOptions.DEFAULT);
        //查询排序
        SearchResponse sortResponse = client.search(new SearchRequest().indices("indexName")
                .source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).sort("filedName", SortOrder.DESC)), RequestOptions.DEFAULT);
        //过滤字段,只查哪些字段
        client.search(new SearchRequest().indices("indexName")
                .source(new SearchSourceBuilder()
                        .fetchSource(true)
                        .fetchSource("","")
                        .query(QueryBuilders.matchAllQuery())),RequestOptions.DEFAULT);
        //组合查询 should其实是all的意思
        SearchRequest request = new SearchRequest().indices("indexName")
                .source(new SearchSourceBuilder()
                        .from(1)
                        .size(10)
                        .fetchSource("name", "")
                        .query(QueryBuilders
                                .boolQuery()
                                .must(QueryBuilders.matchQuery("age", 30)).should(QueryBuilders.matchQuery("", ""))));
        SearchResponse combinationResp = client.search(request, RequestOptions.DEFAULT);
        //范围查询
        SearchRequest rangeSearch = new SearchRequest().indices("").source(new SearchSourceBuilder().query(QueryBuilders.rangeQuery("fieldName").gte(30)));
        SearchResponse rangeResp = client.search(rangeSearch, RequestOptions.DEFAULT);
        //取某个属性的最大值，最小值，平均值
        SearchRequest maxRequest = new SearchRequest().indices("indexName").source(new SearchSourceBuilder().aggregation(AggregationBuilders.max("叫做什么名字").field("fieldName")));
        SearchResponse search = client.search(maxRequest, RequestOptions.DEFAULT);
        

        //2.删除数据
        DeleteRequest deleteRequest = new DeleteRequest().index("indexName").id("supplier_id");
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        //3.批量删除
        BulkRequest deleteBulkRequest = new BulkRequest();
        deleteBulkRequest.add(new DeleteRequest())
                         .add(new DeleteRequest())
                         .add(new DeleteRequest());

        BulkResponse deleteBulkResponse = client.bulk(deleteBulkRequest, RequestOptions.DEFAULT);
        client.close();
    }
}

package com.lrw.other.redistest;

import org.omg.IOP.Encoding;

import java.util.HashSet;

//redis底层数据结构
public class RedisBottomDataStruct {
}


//String 类型的底层数据结构
//SDS ： simple dynamic string
class SDS {
    int len;//存储的字符串长度
    char[] buf;//char型数组保存字符串的每个元素
    int free;//buf 中未使用的字节数量（这里应该是说字符数组中剩余的位置，当free小于某个值时会进行扩容）


    /**
     redis为什么不适用C语言自带的字符串
     1. 获取字符串长度是O(1)级别
     2. C语言在拼接字符串时可能会造成缓存区溢出，SDS可以自动扩容
     3. 可以保存二进制数据
     */
}

//List 类型底层数据结构
class List{
    ListNode head ; //头节点
    ListNode tail ; //尾节点
    int len ;//链表所包含的数据量
    //节点复制函数
    ListNode copyNode(ListNode node){
         return node;
    }
    //释放节点（删除节点）函数
    void freeNode(ListNode node){}
    //节点值对比函数
    void compareNode(ListNode node1,ListNode node2){}
    //内部类，redis C语言中，节点类并不是写在内部的
    class ListNode {
        ListNode prev;//前节点
        ListNode next; //后一个节点
        Object val; //节点值
    }
    /**
     redis List特性
     1.双向链表，获取前一个节点和后一个节点，时间复杂度都为O(1)
     2.带节点计数器，获取链表长度为O(1)
     3.无环，前后节点都为null
     综上： redis List 类型底层数据结构是一个普通的双向链表
     */
}

//Hash 类型数据结构，不再赘述，哈希表，完全类似于HashMap ,只是扩容非常频繁
class Hash{
/**
 负载因子： 节点数/哈希表大小
 扩容条件： 没有执行bgsave命令且负载因子>=1  ,执行bgsave命令且负载因子>=5
 值得说的是，在扩容之后，并不是一瞬间完成rehash操作的，因为当key的数据量很大的时候
 其他操作不能进行，所以只能是渐进式hash。删除和更新会在2张hash表上完成，查询是先查
 第一张表，查不到再差第二张表。增加，是增加再新表上

 */
}

//set 底层数据结构
class  set{
     // 2种数据类型是互斥的 使用intset，则存的这个key集合中存的都是整数，而且元素数量小于512个
     // 否则使用 hash表
     Intset intset;
     HashSet set;

    //todo : ########################################################3
    //内部类，同ListNode，实际上并不是内部类
    class Intset{
        Encoding encoding;//编码方式
        int len ;  //set集合包含的元素数量
        Integer [] values ; //保存元素数组
    }
}
//###########################着重讲zest###############################################
//zset 底层数据结构 --> skipList zipList
class zset{
    //这是3.2之前的redis
    // skipList 和 zipList 数据结构有点复杂，这里不写了
    // 3.2之后使用quickList 实现
    // todo : 使用zipList条件，key中元素数量小于128个，key的总长度小于64字节
    ZipList zipList;

    SkipList skipList;



}
class ZipList{ //压缩列表
    ZipListNode head; //头节点
    ZipListNode tail; //尾节点
    ZipListNode [] vlaues;
    int len ; // 长度
    int level ; //最大层数
}

class ZipListNode{
    Object value ;//值
    double score;//分数
    ZipListLevel[] zipListLevels;//所在的层数
    //真的内部类
    class ZipListLevel{
        ZipListNode prev; //前节点
        int span ;//跨度
    }
}


class SkipList{

}



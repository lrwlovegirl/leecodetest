package com.lrw.ohter.rocketmq;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

public class SyncProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("syncProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        //producer.createTopic("what is key","sync_topic",16);
        for (int x = 0; x < 100; x++) {
            Message message = new Message("sync_topic", "sync_tags", ("this is a sync_body+" + x).getBytes());
            SendResult sendResult = producer.send(message);
            SendStatus sendStatus = sendResult.getSendStatus();
            MessageQueue messageQueue = sendResult.getMessageQueue();
            String name = sendStatus.name();
            String brokerName = messageQueue.getBrokerName();
            int queueId = messageQueue.getQueueId();
            System.out.println("sendStatusName：" + name + ",brokerName:" + brokerName + ",queueId:" + queueId);
            System.out.println(JSON.toJSONString(sendResult));
            System.out.println("##########################");
            System.out.println();
        }
        producer.shutdown();
    }
}

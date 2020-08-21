package com.lrw.ohter.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

public class OrderProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("syncProducer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setRetryTimesWhenSendFailed(2);
        producer.start();
        for (int x= 0;x<300;x++){
            int orderId = x;
            Message message = new Message("sync_topic", "sync_tags", ("this is a order_sync--" + orderId).getBytes());
            SendResult sendResult = producer.send(message, (mqs, msg, arg) -> {
                System.out.println("queue selector mq nums:" + mqs.size());
                System.out.println("msg info： " + msg.toString());
                for (MessageQueue mq : mqs) {
                    System.out.println(mq.toString());
                }
                Integer id = (Integer) arg;
                int index = id % mqs.size();
                return mqs.get(index);
            }, orderId);
            System.out.println("###############################################");
            System.out.println("sendResult: "+sendResult);
        }
    }
}

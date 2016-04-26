package com.wy.kafka.onlyonepartition;

import java.util.Properties;
import java.util.Random;

import com.wy.constants.Constants;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 模拟终端产生过车数据并发送到kafka 服务器.
 * 
 * @author wuyong
 *
 */
public class ProducerOnlyOnePartition extends Thread {
    private kafka.javaapi.producer.Producer<String, String> producer;
    private final String topic = Constants.TOPIC_SIMPLE;
    private Properties props = new Properties();
    private boolean isContinue = true;
    private final String client = "client";
    private final String brokerList = Constants.BROKER_LIST;// 昌乐公安

    public void stopProducer() {
        isContinue = false;
        producer.close();
        System.out.println("Stop Producer!");
    }

    @Override
    public void run() {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "-1");// 不丢数据
        props.put("metadata.broker.list", brokerList);
        props.put("client.id", client);
        props.put("partitioner.class", "com.wy.kafka.onlyonepartition.OnlyOnePartition");
        producer = new kafka.javaapi.producer.Producer<String, String>(new ProducerConfig(props));
        int count = 1;
        while (isContinue) {
            Random random = new Random();
            random.nextInt(10);
            StringBuffer sb = new StringBuffer();
            sb.append("test");
            String svd = sb.toString();
            producer.send(new KeyedMessage<String, String>(topic, svd));
            if (count % 1 == 0) {
                System.out.println("producerCarData---" + count + "---" + svd);
            }
            if (count > 5) {
                stopProducer();
            }
            count++;
        }
    }

    public static void main(String[] args) {
        ProducerOnlyOnePartition producerCarData = new ProducerOnlyOnePartition();
        producerCarData.start();
    }
}

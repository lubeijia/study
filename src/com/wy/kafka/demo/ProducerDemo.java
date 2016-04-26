package com.wy.kafka.demo;

import java.util.Properties;
import java.util.Random;

import com.wy.constants.Constants;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 模拟终端产生过车数据并发送到kafka 服务器.
 * 
 * @author wuyong
 *
 */
public class ProducerDemo extends Thread {
    private Producer<String, String> producer;
    private final String topic = Constants.TOPIC_SIMPLE;
    private Properties props = new Properties();
    private boolean isContinue = true;
    private final String client = "client";
    private final String brokerList = Constants.BROKER_LIST;

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
        producer = new Producer<String, String>(new ProducerConfig(props));
        int count = 1;
        while (isContinue) {
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            sb.append(count+"test"+random.nextInt(100));
            String svd = sb.toString();
            producer.send(new KeyedMessage<String, String>(topic, svd));

            if (count % 1 == 0) {
                System.out.println("producerCarData---" + count + "---" + svd);
            }
            if (count > 500) {
                stopProducer();
            }
            count++;
        }
    }

    public static void main(String[] args) {
        ProducerDemo producerCarData = new ProducerDemo();
        producerCarData.start();
    }
}

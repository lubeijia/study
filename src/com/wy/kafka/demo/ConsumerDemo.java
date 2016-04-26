/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wy.kafka.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.wy.constants.Constants;

//import com.wy.bean.DeployControlResultBean;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerDemo extends Thread {
    private ConsumerConnector consumer;
    private final String topic = Constants.TOPIC_SIMPLE;
    private boolean isContinue = true;
    private final String zookeeperConnect = Constants.ZOOKEEPER_CONNECT;
    private final String group = "TestGroup_Wuyong";
    private final String client = "TestClient_Wuyong";

    public static void main(String[] args) {
        new ConsumerDemo().start();
    }

    public void stopConsumer() {
        isContinue = false;
        consumer.shutdown();
        System.out.println("stopConsumer!");
    }

    public void run() {
        Properties props = new Properties();
        props.put("zookeeper.connect", zookeeperConnect);//
        props.put("group.id", group);
        props.put("zookeeper.session.timeout.ms", "4000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");// 默认从头开始读
        props.put("client.id", client+1);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));// 一次从主题中获取一个数据
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        long count = 1;
        while (it.hasNext() && isContinue) {
            String vhc = new String(it.next().message());
            System.out.println("Consumer==" + count + "==" + new String(vhc));
            count++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            if (count > 500) {
                stopConsumer();
            }
        }
    }
}

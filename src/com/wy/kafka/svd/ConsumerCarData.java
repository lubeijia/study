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
package com.wy.kafka.svd;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.wy.constants.Constants;
import com.wy.kafka.bean.SVD;

//import com.wy.bean.DeployControlResultBean;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerCarData extends Thread {
    private ConsumerConnector consumer;
    private boolean isContinue = true;
    private static final String group = "wuyong_group_test_3";
    private static final String offset = "smallest";

    // 济南配置：
    private static final String topic =  Constants.TOPIC_SVD;
    private static final String zookeeperConnect = Constants.ZOOKEEPER_CONNECT;

    public static void main(String[] args) {
        new ConsumerCarData().start();
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
        props.put("zookeeper.session.timeout.ms", "40000");
        props.put("zookeeper.sync.time.ms", "20000");
        props.put("auto.commit.interval.ms", "10000");
        props.put("auto.offset.reset", offset);// 默认从头开始读
        props.put("client.id", group);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));// 一次从主题中获取一个数据
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        int count = 0;
        while (it.hasNext() && isContinue) {
            count++;
            String vhc = new String(it.next().message());
            System.out.println(count + "==" + vhc);
            if (count > 3) {
                stopConsumer();
            }
        }
    }
}

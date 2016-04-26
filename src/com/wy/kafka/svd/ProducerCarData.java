package com.wy.kafka.svd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import com.wy.constants.Constants;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 模拟终端产生过车数据并发送到kafka 服务器.
 * 
 * @author wuyong
 *
 */
public class ProducerCarData extends Thread {
    private kafka.javaapi.producer.Producer<String, String> producer;
    // private String topic = Constants.TOPIC_SVD_JINAN;
    private Properties props = new Properties();
    private boolean isContinue = true;
    private static final String client = "wuyong_client_test_1";

    // // 济南配置：
    // private static final String topic = "wuyong_svd_test_1";
    // private static final String brokerList =
    // "10.10.50.191:6667,10.10.50.192:6667,10.10.50.193:6667";
    // 昌乐配置：
    private static final String topic = Constants.TOPIC_SVD;
    private static final String brokerList = Constants.BROKER_LIST;

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
        producer = new kafka.javaapi.producer.Producer<String, String>(new ProducerConfig(props));
        int count = 0;
        while (isContinue) {
            count++;
            // Random random = new Random();
            //
            // // 占强提供的测试数据分析
            // // 车身颜色，品牌，类型，年款，系列，车牌号，卡口编号，车速，过车时间，车辆类别，车牌颜色，图片路径，特征值，车牌类别,UUID
            // StringBuffer sb_1 = new StringBuffer();
            // sb_1.append(Constants.COLOR.get(random.nextInt(Constants.COLOR.size())));//
            // 车身颜色
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // int randomNumber = random.nextInt(Constants.INFO.size());
            // String[] info = Constants.INFO.get(randomNumber).split("-");
            // sb_1.append(info[0]);// 品牌
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(info[1]);// 类型
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(info[2]);// 年款
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(info[3]);// 系列
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(Constants.PLATE_PREFIX_SHANDONG.get(random.nextInt(Constants.PLATE_PREFIX_SHANDONG.size()))
            // + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) +
            // random.nextInt(9)
            // + random.nextInt(9));// 车牌号码
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(random.nextInt(500));// 卡口编号
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(random.nextInt(90) + 30);// 车速
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // SimpleDateFormat sdf = new
            // SimpleDateFormat(Constants.UTC_TIME_PATTERN);
            // sb_1.append(sdf.format(new Date()));// 过车时间
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(Constants.TYPE.get(random.nextInt(Constants.TYPE.size())));//
            // 类别
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(Constants.COLOR.get(random.nextInt(Constants.COLOR.size())));//
            // 车身颜色
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append("http://10.10.50.194:7710/download/?pathParam=logo/shirt"
            // + (1 + random.nextInt(9)) + ".jpg");// 图片地址
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(random.nextDouble());// 特征值
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(Constants.PLATE_TYPE.get(random.nextInt(Constants.PLATE_TYPE.size())));//
            // 车牌类别
            // sb_1.append(Constants.KAFKA_SEPARATER);
            // sb_1.append(UUID.randomUUID());// uuid
            // String svd = sb_1.toString();
            // String svd = createData2();
            String svd = "911975225 7-7 2016-01-15 07:00:00 http://192.168.10.242:8088/image/3/3/c8d3882f2c194a43ac44d98e87eb00d1/5/4/5557/2411537822/112252    0   0   0   0   unknown";
            try {
                producer.send(new KeyedMessage<String, String>(topic, svd));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 每隔五分钟打印一次数据
            if (count % 1 == 0 || count < 5) {
                System.out.println("producerCarData==:" + count + "==" + svd);
            }
            if (count > 5) {
                stopProducer();
            }
            // 每隔一微秒发送一条数据
            if (count % 1 == 0) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerCarData producerCarData = new ProducerCarData();
        producerCarData.start();
    }

    // 占强提供的测试数据分析
    // 车身颜色，品牌，类型，年款，系列，车牌号，卡口编号，车速，过车时间，车辆类别，车牌颜色，图片路径，特征值，车牌类别,UUID
    private String createData1() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(Constants.COLOR.get(random.nextInt(Constants.COLOR.size())));// 车身颜色
        sb.append(Constants.KAFKA_SEPARATER);
        int randomNumber = random.nextInt(Constants.INFO.size());
        String[] info = Constants.INFO.get(randomNumber).split("-");
        sb.append(info[0]);// 品牌
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(info[1]);// 类型
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(info[2]);// 年款
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(info[3]);// 系列
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(Constants.PLATE_PREFIX_SHANDONG.get(random.nextInt(Constants.PLATE_PREFIX_SHANDONG.size()))
                + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9));// 车牌号码
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(random.nextInt(500));// 卡口编号
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(random.nextInt(90) + 30);// 车速
        sb.append(Constants.KAFKA_SEPARATER);
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.UTC_TIME_PATTERN);
        sb.append(sdf.format(new Date()));// 过车时间
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(Constants.TYPE.get(random.nextInt(Constants.TYPE.size())));// 类别
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(Constants.COLOR.get(random.nextInt(Constants.COLOR.size())));// 车身颜色
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append("http://10.10.50.194:7710/download/?pathParam=logo/shirt" + (1 + random.nextInt(9)) + ".jpg");// 图片地址
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(random.nextDouble());// 特征值
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(Constants.PLATE_TYPE.get(random.nextInt(Constants.PLATE_TYPE.size())));// 车牌类别
        sb.append(Constants.KAFKA_SEPARATER);
        sb.append(UUID.randomUUID());// uuid
        return sb.toString();
    }

    /*
     * 昌乐使用公安三所数据结构 0 事件id 1 过车时间 2 卡口编号 3 车牌号码 4 品牌-类型-年款-系列 5 类别 6 车身颜色 7 安全带
     * 8 遮阳板 9 图片地址
     */
    private String createData2() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(UUID.randomUUID());// 事件id
        sb.append(Constants.TAB);
        SimpleDateFormat sdf = new SimpleDateFormat(Constants.UTC_TIME_PATTERN);
        sb.append(sdf.format(new Date()));// 过车时间
        sb.append(Constants.TAB);
        sb.append(random.nextInt(500));// 卡口编号
        sb.append(Constants.TAB);
        sb.append(Constants.PLATE_PREFIX_SHANDONG.get(random.nextInt(Constants.PLATE_PREFIX_SHANDONG.size()))
                + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9));// 车牌号码
        sb.append(Constants.TAB);
        int randomNumber = random.nextInt(Constants.INFO.size());
        sb.append(Constants.INFO.get(randomNumber));// 品牌-类型-年款-系列
        sb.append(Constants.TAB);
        sb.append(Constants.TYPE.get(random.nextInt(Constants.TYPE.size())));// 类别
        sb.append(Constants.TAB);
        sb.append(Constants.COLOR.get(random.nextInt(Constants.COLOR.size())));// 车身颜色
        sb.append(Constants.TAB);
        sb.append("安全带");// 安全带
        sb.append(Constants.TAB);
        return sb.toString();
    }

}

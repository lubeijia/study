package com.wy.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuyong
 * @date 2015年12月29日 上午11:09:09
 */
public class Constants {
    public static final String ZOOKEEPER_WATCHER_LEADER_LATCHER_PATH = "/lathcher/leader";
    public static final String ZOOKEEPER_WATCHER_LEADER_SELECTOR_PATH = "/selector/leader";
    
    public static final String TOPIC_SIMPLE = "wuyong_test"+"20160415";//telchina_vsd_topic
//    public static final String TOPIC_SVD_JINAN = "wuyong_svd_test_1";
//    public static final String ZOOKEEPER_CONNECT_JINAN = "10.10.50.191:2181,10.10.50.192:2181,10.10.50.193:2181";// 济南
    
//    // 昌乐公安配置信息
//    public static final String BROKER_LIST = "192.168.10.206:6667,192.168.10.207:6667,192.168.10.208:6667";
//    public static final String ZOOKEEPER_CONNECT = "192.168.10.206:2181,192.168.10.207:2181,192.168.10.208:2181";
//    public static final String TOPIC_SVD = "telchina_vsd_topic_tmp";

    // 济南公司配置信息
    public static final String BROKER_LIST = "10.10.50.191:6667,10.10.50.192:6667,10.10.50.193:6667";
    public static final String ZOOKEEPER_CONNECT = "10.10.50.191:2181,10.10.50.192:2181,10.10.50.193:2181";
    public static final String TOPIC_SVD = "telchina_vsd_topic_jinan";
    
    
    //车辆品牌-型号-年款-系列的集合
    public static List<String> INFO = Arrays.asList(new String[] {
        "一汽解放-*-*-4",
        "福田汽车-奥铃-2010-*",
        "一汽解放-J4-2004-*",
        "东风商用车-天龙-*-*",
        "五菱-PN货车-*-*",
        "福田汽车-*-*-1",
        "福田汽车-欧曼-ETX-2010-5系",
        "金杯-阁瑞斯-2007-2",
        "宝马-7系-2008-*",
        "长城-金迪尔-2005-*",
        "一汽青岛解放-新大威-2009-*",
        "中华-骏捷FRV-2008-*",
        "东风-*-*-6",
        "陕汽重卡-德龙F2000-*-*",
        "昌河-福瑞达-2009-*",
        "福田汽车-欧曼ETX-2010-*",
        "雪佛兰-科帕奇-2008-*",
        "荣威-750-2006-*",
        "金杯-海狮-1999-1",
        "金杯车辆-核动力-2005-*-lizhanq",
        "东风-锐骐皮卡-2007-*",
        "金杯-阁瑞斯-2007-1",
        "陕汽重卡-德龙F3000-2011-*",
        "东南-得利卡-2008-1",
        "东风-小康K07-*-*",
        "东风风行-景逸-*-*",
        "东风风行-景逸-2011-*",
        "东风风行-菱智-2007-*",
        "东风风行-菱智-2012-*",
        "东风风行-菱智-2013-*",
        "丰田-凯美瑞-2007-*",
        "丰田-凯美瑞-2009-*",
        "丰田-凯美瑞-2011-*",
        "丰田-卡罗拉-2007-*",
        "丰田-卡罗拉-2010-*",
        "丰田-威驰-*-*",
        "丰田-皇冠-2006-*",
        "丰田-皇冠-2010-*",
        "丰田-花冠-2013-*",
        "丰田-花冠EX-2004-*",
        "丰田-花冠EX-2011-*",
        "丰田-锐志-*-1",
        "丰田-锐志-*-2",
        "丰田-锐志-*-3",
        "丰田-锐志-*-4",
        "五菱-PN货车-2-*",
        "五菱-五菱之光-2005-*",
        "五菱-五菱之光-2010-*",
        "五菱-五菱之光-2010-2",
        "五菱-兴旺-2009-*",
        "五菱-宏光-2010-*",
        "五菱-荣光-2011-*",
        "五菱-荣光-*-2",
        "依维柯-宝迪-*-*",
        "依维柯-得意-*-1",
        "依维柯-得意-*-2",
        "依维柯-都灵-*-*",
        "别克-GL8-2003-*",
        "别克-GL8-2007-*",
        "别克-GL8-2011-12",
        "别克-GL8-2013-*",
        "北汽威旺-威旺306-*-*",
        "哈飞-黑豹-1027系列-2010",
        "大众-途观-2010/2012-*",
        "奇瑞-A3-*-*",
        "奇瑞-A5-*-*",
        "奇瑞-QQ3-2009-*",
        "奇瑞-旗云5-*-*",
        "奇瑞-风云2-2010-*",
        "奔驰-S级-2011-*",
        "宝马-X5-2011-*",
        "宇通客车-宇通客车-*-*",
        "斯柯达-昊锐-*-*",
        "斯柯达-明锐经典-2008-*",
        "斯柯达-明锐经典-2010-*",
        "斯柯达-晶锐-2008-*",
        "日产-骊威-2007-*",
        "日产-骊威-2008-*",
        "本田-CRV-2007-*",
        "本田-CRV-2010-1",
        "本田-CRV-2013-*",
        "本田-奥德赛-2008-*",
        "本田-奥德赛-2009-*",
        "本田-思域-*-*",
        "本田-思域-*-2",
        "本田-锋范-2008-*",
        "本田-锋范-2012-*",
        "本田-雅阁-*-*",
        "本田-雅阁-*-2",
        "本田-雅阁-*-3",
        "本田-飞度-2-*",
        "标致-307-*-*",
        "标致-307-2004/2007-*",
        "标致-308-*-*",
        "标致-408-*-*",
        "比亚迪-F3-*-*",
        "江淮-同悦-2008/2011-*",
        "江淮-和悦-2010/2011/2012-*",
        "江淮-和悦RS-2010/2011/2012-*",
        "现代-伊兰特-2004-*",
        "现代-伊兰特-2007-*",
        "现代-伊兰特-2011-*",
        "现代-名驭-*-*",
        "现代-悦动-2008-*",
        "现代-悦动-2011-*",
        "现代-朗动-*-*",
        "现代-瑞纳-*-*",
        "现代-索纳塔（进口）-2006-*",
        "现代-索纳塔八-*-*",
        "现代-雅绅特-2009-*",
        "福特-新世代全顺-*-*",
        "福特-福克斯-2009-*",
        "福特-福克斯-2012-*",
        "福特-福克斯（进口）-2011款-*or福特-福克斯-2012款-*",
        "福特-经典全顺-*-*",
        "福特-经典全顺-2005-*",
        "福特-蒙迪欧-2004/2005-*",
        "福特-蒙迪欧-2006-*",
        "福特-蒙迪欧制胜-*-*",
        "福特-蒙迪欧制胜-2011-*",
        "福田-风景-2006-*",
        "起亚-智跑-*-*",
        "起亚-福瑞迪-*-*",
        "起亚-赛拉图-*-*",
        "起亚-K2-*-*",
        "起亚-K3-*-*",
        "起亚-K5-*-*",
        "金杯-金杯海狮-*-*",
        "金杯-金杯海狮-*-1",
        "哈弗-哈弗H6-*-*",
        "长安商用-欧诺-2012-*",
        "长安商用-金牛星-*-*",
        "长安商用-长安之星-*-*-lizhanq",
        "长安商用-长安之星-2003-*",
        "长安商用-长安之星2-2009-*",
        "长安商用-长安之星2-2012-*",
        "长安商用-长安之星S460-2009-1",
        "长安-长安星光35-*-*",
        "长安商用-长安星光4500-2007-*",
        "雪佛兰-乐风-2007-*",
        "雪佛兰-乐风-2010-*",
        "雪佛兰-景程-*-*",
        "雪佛兰-爱唯欧-*-*",
        "雪佛兰-科鲁兹-*-*",
        "雪佛兰-赛欧-2004-*",
        "雪佛兰-赛欧-2010-*",
        "雪佛兰-迈锐宝-*-*",
        "雪铁龙-世嘉-2008/2011-*",
        "雪铁龙-爱丽舍-2008-*",
        "雷克萨斯-ES-2010-*",
        "雷克萨斯-RX-2012-*",
        "马自达-睿翼-2010-2",
        "马自达-马自达3-2010/2012-*",
        "马自达-马自达3-星骋-*",
        "马自达-马自达6-2004-*",
        "马自达-马自达6-2007-*",
        "马自达-马自达6-2008/2011/2012-*",
        "丰田-花冠-2007-*",
        "现代-ix35-*-*",
        "吉利-帝豪EC7-2009/2013/2012/2013-*",
        "日产-奇骏-2008-*",
        "中顺-世纪-2006-*",
        "雪铁龙-世嘉-2012/2013-*",
        "长安-星卡-2007-*",
        "五菱-荣光小卡-*-1",
        "凯迪拉克-SLS赛威-2010/2012-*",
        "哈弗-哈弗H5-2010-1",
        "福田汽车-时代-*-7",
        "大众-高尔夫-2010/2011/2012-*",
        "别克-君威-*-*",
        "大众-PASSAT新领驭-*-2",
        "海马-海福星-2008/2009/2010-*",
        "大众-途安-*-2",
        "别克-凯越-2013-*",
        "五菱-鸿途-*-*",
        "大众-Polo-2011-*",
        "奔驰-E级-2011-*",
        "大众-PASSAT新领驭-*-1",
        "大众-迈腾-*-1",
        "奇瑞-旗云-2006-*",
        "奔驰-E级-2010-*",
        "奥迪-A6L-*-*",
        "日产-天籁-2008/2011/2012-*",
        "别克-凯越-2004/2007-*-*",
        "大众-Polo-2007/2008-*",
        "大众-迈腾-*-2",
        "荣威-550-*-*",
        "丰田-汉兰达-2012-*",
        "MG-MG6-*-*",
        "丰田-雅力士-2008-*",
        "日产-轩逸-2009-*",
        "别克-凯越-2008/2011-*",
        "别克-君越-2008-*",
        "纳智捷-大七SUV-2011-*",
        "大众-帕萨特-*-*",
        "大众-速腾-*-*",
        "东风股份-多利卡-2011-*",
        "别克-君越-*-*",
        "日产-轩逸-2008-*",
        "江铃汽车-顺达-*-*",
        "丰田-凯美瑞-2012--*",
        "凯迪拉克-SRX（进口）-2009/2012-*",
        "日产-骐达-2008-*or日产-颐达-2008-*",
        "别克-赛欧-*-*",
        "荣威-350-2010-*",
        "奔驰-GLK级-2013-*",
        "日产-日产D22-2008-*",
        "福特-福特Ka-*-*",
        "别克-GL8-2005-*",
        "别克-英朗GT-*-*",
        "东风-多利卡-2007-*",
        "大众-途安-*-1",
        "荣威-350-2012-*",
        "日产-天籁-2013-*",
        "大众-Polo-2004-*",
        "奥迪-A6L-*-2",
        "丰田-RAV4-2011-*",
        "大众-桑塔纳-*-*",
        "奥迪-A4L-2013-*",
        "东风商用车-天锦-*-2",
        "日产-逍客-*-*",
        "别克-凯越-2005-*",
        "本田-奥德赛-2005-*",
        "别克-英朗XT-*-*",
        "大众-宝来-2012-*",
        "大众-帕萨特-2000-*",
        "福田汽车-载货汽车-2009-*",
        "大众-Polo劲取-*-2",
        "宝马-X1-*-*",
        "别克-君威-2004-*",
        "东风-小霸王-2006-*",
        "标致-207-*-*",
        "东风股份-多利卡-2011-1",
        "保时捷-卡宴-2010-*",
        "本田-歌诗图-*-*",
        "奥迪-Q5-*-1",
        "东南-V3菱悦-2008-*",
        "丰田-威驰-*-3",
        "宝马-3系-2013-*",
        "日产-阳光-2011-*",
        "MG-MG3-*-*",
        "奥迪-Q7-2009-*",
        "奥迪-A4L-*-*",
        "江淮汽车-骏铃-2008-*or江淮汽车-威铃-2007-*or江淮汽车-帅铃-2012-*",
        "长安-E3-2005-*",
        "江铃汽车-凯运-2007-*",
        "大众-志俊-*-*",
        "江淮汽车-康铃-2010-*or江淮汽车-骏铃-2012-*",
        "东风风行-菱智-2008-*",
        "大众-朗逸-*-1",
        "江淮汽车-好运-2011-*or江淮汽车-威铃-2004-*or江淮汽车-骏铃-2003-*",
        "沃尔沃-XC60-2010-*",
        "长安-逸动-2012-*",
        "大众-志俊-2006-*",
        "一汽解放-J6-2012-*",
        "一汽解放-J4R-*-3",
        "日产-骐达-2011-*",
        "比亚迪-F0-*-*",
        "一汽青岛解放-赛龙-2010-*or一汽青岛解放-骏威（J5K）-2013-*",
        "宝马-5系-2010-*",
        "大众-CC-*-*",
        "江铃-宝典-2007-*",
        "日产-天籁-2006-*",
        "沃尔沃-XC90（进口）-2009-*",
        "一汽解放-赛龙III中卡-*-2",
        "奥迪-Q7-2007-*",
        "江淮汽车-*-*-1",
        "南京依维柯-跃进-2009-*",
        "大众-宝来-2006-*",
        "马自达-马自达3-2007/2009-*",
        "福田汽车-时代领航1-2009-*",
        "一汽青岛解放-赛龙-2012-*or一汽青岛解放-骏威(J5K)-2011-*",
        "起亚-赛拉图-*-2",
        "比亚迪-L3-*-*",
        "五菱-荣光-2007-*",
        "吉利全球鹰-自由舰-2006-*",
        "雪铁龙-C5-*-*",
        "三菱-蓝瑟-*-*",
        "长城-炫丽-2009-*",
        "丰田-威驰-2004-*",
        "宝马-3系-*-*",
        "雷克萨斯-ES-2006-*",
        "雷克萨斯-RX-2006-*",
        "解放-悍威(J5M)-2007-*",
        "奥迪-Q3-2012-*",
        "福特-翼搏-2013-*",
        "奇瑞-瑞虎-2007-*",
        "东风商用车-天锦-*-1",
        "南京依维柯-跃进小虎轻卡-2010-*",
        "江淮汽车-骏铃-*-*",
        "大众-宝来-2013-*",
        "铃木-雨燕-2005-*",
        "中华-骏捷-2007-*",
        "一汽-佳宝V52-2010-*",
        "东风-*-*-2",
        "南京依维柯-跃进-2011-*",
        "长安商用-长安之星S460-2009-2",
        "奔驰-C级-2011-*",
        "现代-领翔-*-*",
        "现代-途胜-2006-*",
        "奥迪-Q5-2013-*",
        "长安商用-长安星光4500-2012-*",
        "福田汽车-时代-*-1",
        "一汽-M80-2009-*",
        "斯巴鲁-森林人-*-*",
        "福田-蒙派克E-2010-*",
        "日产-天籁-2005-*",
        "起亚-千里马-2004-2",
        "比亚迪-S6-*-*",
        "大众-志俊-2008-*-*",
        "比亚迪-F3-*-*",
        "标致-508-*-*",
        "比亚迪-G3-*-*",
        "一汽解放-奥威(J5P)-2009-*",
        "日产-NV200-2010-*",
        "本田-飞度-2003-*",
        "福田汽车-时代驭菱-2010-*",
        "奥迪-A6-2002-*",
        "长城-赛影-2004-*",
        "大众-宝来-2002-*",
        "江淮汽车-格尔发H系列-2012-*",
        "东风-*-*-9",
        "金杯-海狮-1999-2",
        "奥迪-A8-*-*",
        "别克-昂科拉-2013-*",
        "奥迪-A4-*-*",
        "江淮汽车-格尔发-2009-*",
        "南京依维柯-跃进-2010-*",
        "福田汽车-时代驭菱-2009-*",
        "海马-福美来-2011-*",
        "宇通客车-宇通客车-*-4",
        "金杯车辆-领骐-2008-*",
        "东风-*-*-7",
        "江淮汽车-翼开启厢式运输车-*-*",
        "吉利-金刚-2006/2007-*",
        "福田汽车-时代-*-9",
        "丰田-皇冠-2012-*",
        "宝马-1系-2010-*",
        "南京依维柯-跃进小卡-2005-*",
        "南京依维柯-跃进小福星-*-*",
        "宝马-7系-*-*",
        "本田-思迪-2007-*",
        "起亚-秀尔-2010-*",
        "一汽解放-J6-2011-*",
        "一汽解放-J4-2004-*",
        "奇瑞-QQ6-2007/2010-*",
        "哈弗-哈弗H3-2009-*",
        "海马-普力马-2011-*",
        "大众-途锐-*-2",
        "东风风神-H30-2011-*",
        "依维柯-得意-*-4",
        "江铃汽车-*-*-2",
        "雪铁龙-爱丽舍-2003-*",
        "一汽解放-*-*-1",
        "一汽解放-*-*-7",
        "三轮车-*-*-1",
        "东风-*-*-11",
        "长安-悦翔-2009/2010-*",
        "长城-腾翼-2012-*",
        "铃木-SX4-2009-*",
        "哈飞-民意-2004-*",
        "本田-思迪-2006-*",
        "奇瑞-瑞虎-2011/2012/2013-*",
        "大众-朗逸-*-2",
        "宝马-X3-*-*",
        "宇通客车-宇通客车-*-6",
        "长安-长安CX20-2011-*",
        "雪佛兰-乐驰-*-*",
        "日产-骐达-2005-*",
        "东风-*-*-8",
        "华菱汽车-星凯马-2006-*",
        "东风-小霸王-2004-*",
        "铃木-奥拓-2009/2012-*",
        "长城-V80-2011-*",
        "现代-i30-*-*",
        "宝马-3系-2004-*",
        "福田汽车-时代-2006-*",
        "东风-小康V07-*-*",
        "大众-桑塔纳志俊-2-*-lizhanq",
        "起亚-赛拉图-*-3",
        "宝马-5系GT-2010-*",
        "丰田-凯美瑞-2002/2004-*",
        "哈飞-民意-2009-*",
        "比亚迪-F6-*-*",
        "福田汽车-时代驭菱-2010-*",
        "江淮-瑞风-*-*",
        "标致-206-*-*",
        "吉利全球鹰-远景-2009/2010-*",
        "吉利-金鹰-2008/2010-*",
        "五十铃-五十铃-2007-*",
        "别克-林荫大道-*-*",
        "本田-雅阁-2002-*",
        "长城-哈弗M2-*-*",
        "北汽制造-旗铃-2008-*",
        "江淮-瑞风-2011-*",
        "起亚-RIO锐欧-*-*",
        "大众-捷达-*-3",
        "开瑞-优劲2010-*or开瑞-优优-2010-*",
        "沃尔沃-S80L-2009-*",
        "东风-小康K17-*-*",
        "福田汽车-欧曼ETX-2004-9系",
        "奇瑞-旗云1-2010-*",
        "宝马-X6-*-*",
        "福田汽车-时代-*-5",
        "雪佛兰-景程-2005-*",
        "丰田-雅力士-2011-*",
        "江淮汽车-好运-2011-*",
        "本田-思铂睿-*-*",
        "哈弗-哈弗H6-2013-*",
        "哈弗-哈弗H3-2006-*",
        "江淮汽车-格尔发H系列-2010-*",
        "东南-V3菱悦-2010-*",
        "五十铃-五十铃-2010-*",
        "jeep-指南者-2011-*",
        "陕汽重卡-奥龙-2007-*",
        "奇瑞-瑞虎-2006-*",
        "比亚迪-G6-*-*",
        "江淮-瑞鹰-2008/2009/2010/2011-*",
        "一汽-S80-2011-*",
        "一汽青岛解放-新大威-2010-*",
        "丰田-汉兰达-*-*",
        "黄海汽车-黄海客车-*-6",
        "路虎-极光-2011-*",
        "三菱-欧蓝德（进口）-2009-*",
        "比亚迪-速锐-2012-*",
        "三菱-翼神-*-*",
        "福田-萨普-2011-*",
        "凯马汽车-好运来-*-*",
        "雷克萨斯-RX-2011-*",
        "沃尔沃-S60-2011-*or沃尔沃-V60-2011-*",
        "宝骏-宝骏630-*-*",
        "丰田-威驰-*-2",
        "金杯-第六代海狮-2011-*",
        "大众-Polo劲取-*-1",
        "江淮客车-江淮客车-*-*",
        "中华-H530-2011-*",
        "宇通客车-宇通客车-*-1",
        "五十铃-五十铃-*-2",
        "雪佛兰-科帕奇-2011-*",
        "本田-飞度-*-1",
        "福田汽车-厢式运输-2010-*",
        "斯巴鲁-XV-2012-*",
        "一汽解放-悍威(J5M)-2011-*",
        "奔驰-M级-2012-*",
        "大众-Polo-2012-*",
        "日产-帕拉丁-*-*",
        "奔驰-C级-2008/2009/2010-*",
        "宝马-3系-2006-*",
        "奔驰-R级-2011-*",
        "猎豹-黑金刚-2004-*or猎豹-奇兵-2009-*",
        "吉利-SC7-*-*",
        "江淮汽车-格尔发-2011-*",
        "奥迪-A3-2010-分两三厢",
        "雷诺-科雷傲-2011-*",
        "大众-开迪-*-*",
        "金龙客车-大金龙-*-2",
        "大众-桑塔纳-2013-*",
        "奔驰-GLK级-*-*",
        "金杯汽车-领驰-*-*",
        "丰田-逸致-*-*",
        "现代-御翔-2005-*",
        "红岩汽车-杰狮-2010-*",
        "雪铁龙-凯旋-2007-*",
        "吉利全球鹰-自由舰-2011-*",
        "江淮-星锐-2011-*",
        "哈弗-哈弗H3-*-*",
        "丰田-皇冠-2011-*",
        "日产-日产D22-2007-*",
        "唐骏汽车-欧玲-2010-*",
        "雪铁龙-C2-*-*",
        "日产-蓝鸟-2004-*",
        "现代-全新胜达-*-*",
        "吉利全球鹰-熊猫-2010-*",
        "宇通客车-宇通客车-*-5",
        "金龙客车-大金龙-*-3",
        "MINI-MINI_COOPER-2011-*",
        "江铃-宝典-2002-*",
        "大众-高尔-*-*",
        "雪铁龙-富康-*-*",
        "东风柳汽-乘龙-2008-2",
        "中华-骏捷FSV-2009-*",
        "奔驰-S级-2006-*",
        "三菱-戈蓝-2009-*",
        "东风-小康C35-*-*or东风-小康C37-2012-*",
        "福田汽车-时代-*-4",
        "丰田-普拉多-*-1",
        "哈飞-中意V5-2002-*",
        "广汽传祺-传祺GS5-2012/2013-*",
        "长安-奔奔MINI-2010/2011-*",
        "本田-奥德赛-2002-*",
        "现代-ix35-2013-*",
        "福特-嘉年华-*-*",
        "长安商用-长安之星-2012-*",
        "长城-C30-*-1",
        "雷诺-科雷傲-2010-*",
        "金龙客车-大金龙-*-5",
        "哈飞-黑豹-1030系列-2010",
        "日产-玛驰-2010-*",
        "海马-福美来-2006-*",
        "起亚-千里马-2004-1",
        "长城-风骏5-2010-*",
        "江淮-瑞风M5-20-*-*12-*",
        "长城-炫丽-*-*-lizhanq",
        "华泰-圣达菲-2006-*",
        "马自达-马自达2-2011-*",
        "宝马-7系-2004-*",
        "本田-CRV-2010-2",
        "奇瑞-旗云3-2010-*",
        "中华-尊驰-2007/2008-*",
        "丰田-普瑞维亚-2008-*",
        "福田汽车-时代-*-厢式",
        "雷克萨斯-CT200h-2011-*",
        "三菱-帕杰罗-*-*",
        "路虎-神行者-2010-*",
        "宝马-X1-2013-*",
        "哈弗-哈弗H5-2010-2",
        "江淮-宾悦-2008/2009-*",
        "中国重汽-豪沃-2009-*",
        "别克-昂科雷-2009-*",
        "斯巴鲁-傲虎-*-*",
        "东风风行-菱智-2012-*",
        "丰田客车-考斯特-*-2",
        "五十铃-五十铃皮卡-2007-*",
        "五菱-PN货车-*-3",
        "奥迪-Q5-*-2",
        "丰田-RAV4-2012-*",
        "荣威-W5-2011-*",
        "福田汽车-时代-*-2",
        "奔腾-B50-2009-*",
        "别克-君威-2000-*",
        "奇瑞-东方之子-2005/2007-*",
        "奇瑞-旗云2-2010-*",
        "长安-长安CS35-2012-*",
        "丰田客车-柯斯达-*-1",
        "铃木-北斗星-2007-*",
        "丰田-兰德酷路泽-2002-*",
        "长城-风骏3-*-*",
        "奇瑞-旗云1-2011-*",
        "众泰-5008-2010-*",
        "别克-君威-1999-*",
        "东风风度-帅客-2010-*",
        "宝马-5系-2005-*",
        "英菲尼迪-EX-2008-*",
        "大众-高尔夫-2003-*",
        "雪佛兰-开拓者-2003-*",
        "五菱-五菱扬光-2004-*",
        "长城-C50-2012/2013-*",
        "大众-捷达-*-4",
        "日产-骊威-2013-*",
        "福特-麦柯斯-*-*",
        "大众-捷达-*-2",
        "大众-polo-2007-*",
        "本田-雅阁-*-5",
        "奔驰-B级-2009-*",
        "海马-海骑士-2010/2011-*",
        "宝马-X5-2009-*",
        "长城-C30-*-*",
        "长城-赛酷-2008-*",
        "起亚-狮跑-*-1",
        "路虎-发现-2010-*",
        "中华-骏捷-2011-*",
        "宝马-X5-2004-*",
        "铃木-羚羊-2003-*",
        "大众-尚酷-2009-*",
        "江淮客车-江淮星吧-*-*",
        "奇瑞-A1-2007-*",
        "奇瑞-风云2-2013-*",
        "斯柯达-晶锐-*-*",
        "中国重汽-豪沃-2011-*",
        "日产-蓝鸟-2002-*",
        "本田-飞度-3-*",
        "力帆-320-*-*",
        "丰田-普拉多-*-2",
        "开瑞-优雅-2008-*",
        "江淮汽车-帅铃-*-*",
        "华泰-特拉卡-2004-*",
        "众泰-2008-2008-*",
        "马自达-马自达8-2011-*",
        "北奔重卡-*-2007-*",
        "路虎-揽胜运动-2010-*",
        "本田-锋范-2011-*",
        "马自达-马自达2-2012-*",
        "长城-精灵-2008-*",
        "本田-飞度-*-4",
        "江铃汽车-运霸-2005-*",
        "东风风神-H30-2012-*",
        "本田-思铭-2011-*",
        "奔驰-M级-2008-*",
        "比亚迪-M6-2010-*",
        "大众-甲壳虫-2010-*",
        "海马-福美来-2012-*",
        "宇通客车-宇通客车-*-*",
        "中华-中华-2003-*",
        "标致-3008-2013-*",
        "宇通客车-宇通客车-*-8",
        "南京依维柯-跃进小福星-2007-*",
        "本田-艾力绅-2012-*",
        "哈弗-哈弗M2-2012-*",
        "长安-悦翔-2012-*",
        "黄海-旗胜CUV-2010-*",
        "福田汽车-时代-*-6",
        "马自达-马自达CX-*-7",
        "一汽-佳宝V70-2011-*",
        "荣威-750-2011-*",
        "凯迪拉克-SLS赛威-2007-*",
        "英菲尼迪-FX-2009-*",
        "铃木-雨燕-2011-*",
        "五征-五征-2011-*or五征-飞碟-2011-*",
        "江淮-瑞风S5-2013-*",
        "讴歌-MDX-2009-*",
        "客车-宇通-*-2",
        "日产-骊威劲锐-2013-*",
        "英菲尼迪-QX-2012-*",
        "奥迪-A8-2005-*",
        "菲亚特-菲翔-2012-*",
        "奔驰-M级-*-5",
        "唐骏汽车-欧铃-*-1",
        "福特-锐界-2011-*",
        "三菱-欧蓝德-2004-*",
        "保时捷-卡宴-2007-*",
        "哈飞-小霸王-2010-*",
        "海马汽车-福仕达鸿达-2012-*",
        "长安商用-欧力威-2013-*",
        "铃木-奥拓-2013-*",
        "东风-*-*-10",
        "中华-骏捷FRV-2010-*",
        "金杯汽车-金运-*-*",
        "一汽-威志-2008/2011-*",
        "凯迪拉克-凯迪拉克CTS-2005-*",
        "中华-V5-2012-*",
        "大众-途锐-*-1",
        "福田汽车-时代驭菱-2011-*",
        "奔腾-B70-2010-*",
        "长城-酷熊-2009-*",
        "奔驰-M级-*-4",
        "广汽吉奥-星旺-2011-*",
        "斯巴鲁-森林人-2013-1",
        "金杯汽车-领骐-2011-*",
        "铃木-天语SX4-2011-*",
        "别克-君威-2009-*",
        "吉利全球鹰-GX7-2012-*",
        "中国重汽-斯太尔-*-*or红岩汽车-霸王-*-1",
        "北汽威旺-205-*-*",
        "丰田-普瑞维亚-2004-1",
        "上汽大通-伊思坦纳-*-*",
        "三一重工-三一-*-1",
        "北汽制造-旗铃-2012-*",
        "吉利帝豪-帝豪EC7_RV-2010-*",
        "黄海客车-黄海客车-*-4",
        "东风-未知-*-2",
        "长安-勋龙-2010-*",
        "奔驰-S级-2000-1",
        "丰田-普瑞维亚-2007-*",
        "哈飞-民意-2007-*",
        "奔腾-B50-2012-*",
        "本田-理念S1-2011-2",
        "中顺-世纪-2005-*",
        "福特-新世代全顺-2013-*",
        "铃木-奥拓-2007-*",
        "大众-捷达-2013-*",
        "江淮-瑞鹰-2011/2013-*",
        "福田-风景-2012-*",
        "现代-胜达（进口）-2010-*",
        "起亚-佳乐-2007-*",
        "现代-途胜-2013-*",
        "福特-蒙迪欧-2013-*",
        "长安-悦翔V3-2012-*",
        "宝马-X3-2008-*",
        "海马-海马M3-2013-*",
        "一汽解放-悍威-2010-*",
        "奔驰-E级-2006-*",
        "大众-辉腾-2011-*",
        "宝马-5系-2000-*",
        "猎豹-黑金刚-2005-*or三菱-帕杰罗-2000-*",
        "奔驰-唯雅诺-2006-*",
        "黄海-翱龙CUV-*-*",
        "捷豹-XJ-2010-*",
        "大众-宝来-2011-*",
        "奔腾-B70-*-1",
        "长安-奔奔MINI-2012-*",
        "三菱-欧蓝德（进口）-2006-*",
        "捷豹-捷豹XF-2012-*",
        "现代-御翔-2007-*",
        "福田-萨普T-2009-*",
        "日产-骏逸-2006-*",
        "雷克萨斯-GX-2011-*",
        "友谊客车-友谊客车-2007-*",
        "金龙客车-大金龙-*-1",
        "jeep-自由客-2012-*",
        "金龙客车-大金龙-*-4",
        "中国重汽-斯太尔王-2007-*",
        "路虎-神行者-2007-*",
        "金旅客车-金旅-*-2",
        "北汽制造-旗龙-*-*",
        "道奇-酷威-2009-*",
        "哈飞-路宝-2008-*",
        "奇瑞-瑞麒X1-2010-*",
        "五征-飞碟-*-1",
        "奔驰-E级-2005-*",
        "起亚-狮跑-*-2",
        "奔腾-奔腾X80-2013-*",
        "本田-CRV-2005-*",
        "英菲尼迪-G系-2013-*",
        "东风-*-*-3",
        "华菱-华菱之星-2009-*",
        "长安-神童校车-2013-*",
        "哈飞-民意-2012-*",
        "奔驰-R级-2007-*",
        "捷豹-XF-2008-*",
        "丰田-兰德酷路泽-2008-*",
        "铃木-北斗星-2002-1",
        "一汽解放-*-*-5",
        "一汽解放-J4-2004-*",
        "雷克萨斯-LX-2007-*",
        "华普-海域-2005-*",
        "金龙客车-大金龙-*-6",
        "哈飞-赛马-2004-1",
        "中华-H230-2012-*",
        "奇瑞-QQ-2013-*",
        "三菱-帕杰罗（进口）-2009/2010-*",
        "少林客车-少林客车-2006-*",
        "现代-胜达（进口）-2006-*",
        "本田-奥德赛-2011-*",
        "黄海客车-黄海客车-*-1",
        "长安商用-长安CM8-2004-*",
        "青年客车-尼奥普兰-2006-*",
        "福田汽车-时代-*-8",
        "中华-H330-2013-*",
        "丰田-Sienna-2011-*",
        "金杯-金杯海狮-1991-*",
        "克莱斯勒-300C-2004-*",
        "瑞麒-M1-2009-*",
        "英菲尼迪-FX-2007-*",
        "黄海-挑战者SUV-2010-*",
        "金杯-海星-2011-1",
        "铃木-羚羊-2009-*",
        "奇瑞-东方之子-2003-*",
        "江淮-和悦RS-2013-*",
        "jeep-大切诺基（进口）-*-*",
        "中华-骏捷Cross-2009-*",
        "丰田-RAV4-2013-*",
        "路虎-揽胜-2009-*",
        "开瑞-优优二代-2012-*",
        "宇通客车-宇通客车-*-11",
        "福田汽车-时代-*-3",
        "江铃-宝典-2009-*",
        "长安-镭蒙-2005-*"
    });
    
//    //车辆类别信息---旧数据
//    public static List<String> TYPE = Arrays.asList(new String[]{
//        "其他车型",
//        "大型货车",
//        "中型货车",
//        "小型货车",
//        "大型客车",
//        "中型客车",
//        "小型客车",
//        "SUV",
//        "MPV",
//        "旅行车",
//        "微型面包车"
//    });
    //车辆类别信息--新数据-昌乐-三所-使用
    public static List<String> TYPE = Arrays.asList(new String[]{
        "其他",
        "大型货车",
        "中型货车",
        "小型货车",
        "大型客车",
        "中型客车",
        "小型客车",
        "未知",
        "面包车"
    });
    
//    //车身颜色信息--旧数据
//    public static List<String> COLOR = Arrays.asList(new String[]{
//        "其它颜色",
//        "黑色",
//        "棕色",
//        "青色",
//        "灰色",
//        "绿色",
//        "红色",
//        "黄色",
//        "白色"
//    });
    //车身颜色信息--新数据-昌乐-三所-使用
    public static List<String> COLOR = Arrays.asList(new String[]{
        "未知",
        "白色",
        "黑色",
        "红色",
        "黄色",
        "灰色",
        "蓝色",
        "绿色",
        "青色"
    });
    
    //全国车牌前缀
    public static List<String> PLATE_PREFIX = Arrays.asList(new String[]{
        "冀A","冀B","冀C","冀D","冀E","冀F","冀G","冀H","冀J","冀K","冀L","冀N","冀P","冀Q","冀R","冀S","冀T",
        "豫A","豫B","豫C","豫D","豫E","豫F","豫G","豫H","豫J","豫K","豫L","豫M","豫N","豫P","豫Q","豫R","豫S",
        "云A","云B","云C","云D","云E","云F","云G","云H","云J","云K","云L","云M","云N","云P","云Q","云R","云S",
        "辽A","辽B","辽C","辽D","辽E","辽F","辽G","辽H","辽J","辽K","辽L","辽M","辽N","辽P",
        "黑A","黑B","黑C","黑D","黑E","黑F","黑G","黑H","黑J","黑K","黑L","黑M","黑N","黑P",
        "湘A","湘B","湘C","湘D","湘E","湘F","湘G","湘H","湘J","湘K","湘L","湘M","湘N","湘P",
        "皖A","皖B","皖C","皖D","皖E","皖F","皖G","皖H","皖J","皖K","皖L","皖M","皖N","皖P","皖Q","皖R",
        "鲁A","鲁B","鲁C","鲁D","鲁E","鲁F","鲁G","鲁H","鲁J","鲁K","鲁L","鲁M","鲁N","鲁P","鲁Q","鲁R","鲁S",
        "新A","新B","新C","新D","新E","新F","新G","新H","新J","新K","新L","新M","新N","新P","新Q","新R",
        "苏A","苏B","苏C","苏D","苏E","苏F","苏G","苏H","苏J","苏K","苏L",
        "浙A","浙B","浙C","浙D","浙E","浙F","浙G","浙H","浙J","浙K","浙L",
        "赣A","赣B","赣C","赣D","赣E","赣F","赣G","赣H","赣J","赣K","赣L",
        "鄂A","鄂B","鄂C","鄂D","鄂E","鄂F","鄂G","鄂H","鄂J","鄂K","鄂L","鄂M","鄂N","鄂P","鄂Q",
        "桂A","桂B","桂C","桂D","桂E","桂F","桂G","桂H","桂J","桂K","桂L","桂M","桂N","桂P",
        "甘A","甘B","甘C","甘D","甘E","甘F","甘G","甘H","甘J","甘K","甘L","甘M","甘N","甘P",
        "晋A","晋B","晋C","晋D","晋E","晋F","晋G","晋H","晋J","晋K","晋L","晋M",
        "蒙A","蒙B","蒙C","蒙D","蒙E","蒙F","蒙G","蒙H","蒙J","蒙K","蒙L",
        "陕A","陕B","陕C","陕D","陕E","陕F","陕G","陕H","陕J","陕K",
        "吉A","吉B","吉C","吉D","吉E","吉F","吉G","吉H",
        "闽A","闽B","闽C","闽D","闽E","闽F","闽G","闽H","闽J",
        "贵A","贵B","贵C","贵D","贵E","贵F","贵G","贵H","贵J",
        "粤A","粤B","粤C","粤D","粤E","粤F","粤G","粤H","粤J","粤K","粤L","粤M","粤N","粤P","粤Q","粤R","粤S","粤T","粤U","粤V",
        "川A","川C","川D","川E","川F","川G","川H","川J","川K","川L","川M","川N","川P","川Q","川R","川S","川T","川U","川V","川W",
        "藏A","藏B","藏C","藏D","藏E","藏F","藏G",
        "琼A","琼B","琼C",
        "宁A","宁B","宁C","宁D",
        "渝A","渝B","渝C","渝F","渝G","渝H",
        "京A","京B","京C","京D",
        "沪A","沪B","沪C","沪D",
        "津A","津C","津D","津E",
    });
    
    //山东车牌号前缀
    public static List<String> PLATE_PREFIX_SHANDONG = Arrays.asList(new String[]{
        "鲁A","鲁B","鲁C","鲁D","鲁E","鲁F","鲁G","鲁H","鲁J","鲁K","鲁L","鲁M","鲁N","鲁P","鲁Q","鲁R","鲁S"
    });
    
    //车牌颜色
    public static List<String> PLATE_COLOR = Arrays.asList(new String[]{
        "朱红底-白字",
        "绿底-白字",
        "白底-红GA-黑字",
        "白底-红WJ-黑字",
        "白底-红字甲乙丙-黑字",
        "黑底-空心使字-白字",
        "墨底-空心领字-白字",
        "黑底-白字",
        "蓝底-学字-白字",
    });
    
    public static List<String> PLATE_TYPE = Arrays.asList(new String[]{
        "大型民用",
        "小型民用",
        "公安专用",
        "武警专用",
        "军用",
        "大使馆外籍",
        "领事馆外籍",
        "其他外籍",
        "学习车",
    });

    //分隔符
    public static final String SEPARATOR = "-";
    public static final String TAB = "\t";
    public static final String COMMA = ",";
    public static final String EQUAL = "=";
    public static final String SEMICOLON = ";";
    public static final String OPEN_CURLY = "{";
    public static final String CLOSE_CURLY = "}";
    public static final String COLON = ":";
    public static final String VERTICAL_LINE = "|";
    public static final String MR_PARAM_PREFIX = "params:";
    public static final String AVERAGE = "average";
    
    //图片地址-测试用
    public static final String PSEUDO_URL = "http://www.baidu.com";
    public static final int CAR_NUMBER = 900;
    
    public static final String CCRC_CONSUMER = "ccrc_test_fomal";
    public static final String YPDC_CONSUMER = "ypdc_20151126_1";
    public static final String COMMON_CONSUMER = "common_test_fomal_1";
    
    public static final String SOLR_CONSUMER = "solr_index_fomal";
    public static final String KAFKA_SOLR_TOPIC = "index_vsd";
    //table
    public static final String T_CACHE_CCRC = "T_CACHE_CCRC";
    public static final String T_CCRC = "T_CCRC";
    public static final String T_CACHE_YPDC = "T_CACHE_YPDC";
    public static final String T_YPDC = "T_YPDC";
    public static final String T_VSD_KSC = "T_VSD_KSC";
    public static final String T_VSD_CSK = "T_VSD_CSK";
    public static final String T_GCZS = "T_GCZS";
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://telchina04.com:3306/vbds_data";
    
    
    public static final int BATCH_SIZE = 100;
    
    public static final String SPACE = " ";
    public static final String MIDDLE_LINE = "-";
    
    public static final String UTC_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String EASYUI_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String HDFS_FILE_NAME = "vsd.data";
    
    public static final String CRLF = "\n";
    
    public static final String FILE_PERMISSION = "-rwxrwxrwx";
    
    public static final int CACHE_SIZE = 1024 * 2;
    
    //大数据处理用到的分隔符
    public static final String BIG_DATA_SEPERATOR = "\000";
    
    //定义时间间隔，在小于该间隔的时间范围内通过同一卡口的车就有可能是伴随车,单位为秒
    public static final int BSCFX_TIME_INTERVAL = 1000;
    //定义时间间隔，一辆车T1,T2时间顺序通过K1,K2卡口，如果T2-T1>该间隔，那么认定T1处为该车的落脚点之一,单位为分钟
    public static final int LJDFX_TIME_INTERVAL = 30;
    //行程间隔
    public static final int TRAVEL_TIME_INTERVER = 30;
    
    //vsd中未被识别的字段
    public static final String FIELD_UNRECONIZED = "未识别";
    
    //相似车牌串并MapReduce的job的名字
    public static final String XSCPCB_MR_JOB_NAME = "xscpcb-";
    public static final String KSLCFX_MR_JOB_NAME = "kslcfx-";
    public static final String XSCPCB_PARAM_START_TIME = "xscpcb_startTime";
    public static final String XSCPCB_PARAM_END_TIME = "xscpcb_endTime";
    public static final String XSCPCB_MR_PARAM_NAME = "xscpcb_param";
    public static final String KSLCFX_MR_PARAM_NAME = "kslcfx_param";
    public static final String KSLCFX_FINAL_OUTPUT_PREFIX = "-stage2";
    public static final String KSLCFX_PARAM_START_TIME = "kslcfx_startTime";
    public static final String KSLCFX_PARAM_END_TIME = "kslcfx_endTime";
    public static final String SUBURB_BAYONET = "suburb_bayonet";
    
    //频繁过车MapReduce的job的名字
    public static final String PFGC_MR_JOB_NAME = "pfgc";
//    public static final String PFGC_MR_JOB_NAME = "kslcfx";
    public static final String PFGC_PARAM_START_TIME = "pfgc_startTime";
    public static final String PFGC_PARAM_END_TIME = "pfgc_endTime";
    public static final String PFGC_MR_PARAM_NAME = "pfgc_param";
    public static final String PFGC_MR_PARAM_CAMERALS = "pfgc_camerals";
    
    //MapReduce作业最大的失败重试次数
    public static final String MR_JOB_MAX_ATTEMPT = "1";
    
    public static final String PFGC_JAR_LOCATION = "/home/lizhanq/pfgc.jar";
    public static final String PFGC_MAIN_CLASS = "cn.telchina.vbds.bigdatastudy.mr.PfgcMr";
    
    public static final String MR_INPUT_PATH_PREFIX = "/vbds/";
    public static final String MR_OUTPUT_PATH_PREFIX = "/tmp/vbds/";
    public static final String XSCPCB_JAR_LOCATION = "/home/lizhanq/xscpcb.jar";
    public static final String KSLCFX_JAR_LOCATION = "/home/lizhanq/kslcfx.jar";
    public static final String HDFS_LOCATION = "hdfs://telchina01.com:8020";
    public static final String XSCPCB_MAIN_CLASS = "cn.telchina.vbds.bigdatastudy.mr.XscpcbMr";
    public static final String KSLCFX_MAIN_CLASS = "cn.telchina.vbds.bigdatastudy.mr.KslcfxMr";
    public static final String HDFS_IGNORE_FILE = "_SUCCESS";
    
    
    public static final String YARN_CREATE_NEW_APP_URI = "http://10.10.50.192:8088/ws/v1/cluster/apps/new-application";
    public static final String YARN_SUBMIT_APP_URI = "http://10.10.50.192:8088/ws/v1/cluster/apps";
    public static final String YARN_GET_ALL_JOBS_URI = "http://10.10.50.192:8088/ws/v1/cluster/apps?states=accepted,running,finished";
    
    //log相关
    public static final String CCRC = "初次入城";
    public static final String YPDC = "一牌多车";
    public static final String CLGJ = "车辆轨迹分析";
    public static final String BSCFX = "伴随车分析";
    public static final String LJDFX = "落脚点分析";
    public static final String QYPZ = "区域碰撞分析";
    public static final String XSCPCB = "相似车牌串并";
    public static final String KSLCFX = "快速离城分析";
    public static final String PFGC = "频繁过车";
    public static final String LOG_START_TIME = "开始时间";
    public static final String LOG_END_TIME = "结束时间";
    public static final String LOG_CAMERA_IDS = "卡口";
    public static final String LOG_CARPLATE_NO = "车牌号";

    // kafka相关

    public static final String KAFKA_SEPARATER = "\000";
    public static final String KAFKA_AUTO_OFFSET_REST_LARGEST = "largest";
    public static final String KAFKA_ZOOKEEPER_CONNECTION_TIMEOUT_MS = "15000";
    public static final String KAFKA_ZOOKEEPER_SESSION_TIMEOUT_MS = "30000";
    public static final String KAFKA_GROUP_ID_GCZS = "gczsGroup";
    public static final String KAFKA_CLIENT_ID_GCZS = "gczsClient";
    public static final String KAFKA_GROUP_ID_CCRC = "ccrcGroup";
    public static final String KAFKA_CLIENT_ID_CCRC = "ccrcClient";
    public static final String KAFKA_AUTO_OFFSET_RESET_SMALLEST = "smallest";
    public static final String KAFKA_GROUP_ID_MONITOR = "monitorGroup";
    public static final String KAFKA_CLIENT_ID_MONITOR = "monitorClient";

    // ZOOKEEPER相关
    public static final String ZOOKEEPER_MONITOR_MANAGER_PATH = "/monitor11/leader";

    //hbasecf、qualifier相关
    public static final String HBASE_CF_PASSTIME = "passtime";
    public static final String HBASE_CONTENT = "content";
    public static final String HBASE_CF_DETAIL = "detail";
    public static final String HBASE_CARPASSTIME = "carPassTime";
    public static final String HBASE_CARBRAND = "carBrand";
    public static final String HBASE_CARMODEL = "carModel";
    public static final String HBASE_CARPROYEAR = "carProYear";
    public static final String HBASE_CARSERIES = "carSeries";
    public static final String HBASE_CARCOLOR = "carColor";
    public static final String HBASE_CARFEATURE = "carFeature";
    public static final String HBASE_CARPLATECOLOR = "carPlateColor";
    public static final String HBASE_CARPLATETYPE = "carPlateType";
    public static final String HBASE_CARSPEED = "carSpeed";
    public static final String HBASE_CARTYPE = "carType";
    public static final String HBASE_VSDPICURL = "vsdPicUrl";
    
    //solr 索引相关
    public static final String SOLR_SCHEMA_FIELD_ID = "id";
    public static final String SOLR_SCHEMA_FIELD_DATESOURCE = "dataSource";
    public static final String SOLR_SCHEMA_FIELD_HASPLATENO = "hasPlateNo";
    public static final String SOLR_SCHEMA_FIELD_CARPLATENO = "carPlateNo";
    public static final String SOLR_SCHEMA_FIELD_CARMODEL = "carModel";
    public static final String SOLR_SCHEMA_FIELD_CARTYPE = "carType";
    public static final String SOLR_SCHEMA_FIELD_CARCOLOR = "carColor";
    public static final String SOLR_SCHEMA_FIELD_CAMERAID = "cameraId";
    public static final String SOLR_SCHEMA_FIELD_CARSPEED = "carSpeed";
    public static final String SOLR_SCHEMA_FIELD_PASSTIME = "passTime";
    public static final String SOLR_SCHEMA_FIELD_IMGURL = "imgUrl";
    
    // 过车指数相关
    public static final Map<String, String> PLATE_COLOR_MAP = new HashMap<String, String>();
    public static final Map<String, String> PLATE_TYPE_MAP = new HashMap<String, String>();
    public static final Map<String, String> CAR_TYPE_MAP = new HashMap<String, String>();
    public static final Map<String, String> TERRITORY_MAP = new HashMap<String, String>();
    public static final Map<String, String> TERRITORY_LOCAL_MAP = new HashMap<String, String>();
    public static final Set<String> TERRITORY_LOCAL_SET = new HashSet<String>();

    static {
        PLATE_COLOR_MAP.put("蓝色", "blue");
        PLATE_COLOR_MAP.put("白色", "white");
        PLATE_COLOR_MAP.put("黄色", "yellow");
        PLATE_COLOR_MAP.put("绿色", "green");
        PLATE_COLOR_MAP.put("黑色", "black");
        PLATE_COLOR_MAP.put("朱红底-白字", "scarlet_white");
        PLATE_COLOR_MAP.put("绿底-白字", "green_white");
        PLATE_COLOR_MAP.put("白底-红GA-黑字", "white_red_GA_black");
        PLATE_COLOR_MAP.put("白底-红WJ-黑字", "white_red_WJ_black");
        PLATE_COLOR_MAP.put("白底-红字甲乙丙-黑字", "white_red_jiayibingding_black");
        PLATE_COLOR_MAP.put("黑底-空心使字-白字", "black_shi_white");
        PLATE_COLOR_MAP.put("墨底-空心领字-白字", "black_ling_white");
        PLATE_COLOR_MAP.put("黑底-白字", "black_white");
        PLATE_COLOR_MAP.put("蓝底-学字-白字", "blue_xue_white");

        PLATE_TYPE_MAP.put("大型民用", "big_civil");
        PLATE_TYPE_MAP.put("小型民用", "small_civil");
        PLATE_TYPE_MAP.put("公安专用", "public_security");
        PLATE_TYPE_MAP.put("武警专用", "armed_police");
        PLATE_TYPE_MAP.put("军用", "army");
        PLATE_TYPE_MAP.put("大使馆外籍", "embassy");
        PLATE_TYPE_MAP.put("领事馆外籍", "consulate");
        PLATE_TYPE_MAP.put("其他外籍", "other_foreign");

        CAR_TYPE_MAP.put("大型货车", "large_truck");
        CAR_TYPE_MAP.put("中型货车", "middle_truck");
        CAR_TYPE_MAP.put("小型货车", "small_truck");
        CAR_TYPE_MAP.put("大型客车", "large_bus");
        CAR_TYPE_MAP.put("中型客车", "middle_bus");
        CAR_TYPE_MAP.put("小型客车", "small_bus");
        CAR_TYPE_MAP.put("SUV", "suv");
        CAR_TYPE_MAP.put("MPV", "mpv");
        CAR_TYPE_MAP.put("旅行车", "tourer");
        CAR_TYPE_MAP.put("微型面包车", "mini_bus");
        CAR_TYPE_MAP.put("其他车型", "other_type");
        
//        TERRITORY_LOCAL_MAP.put("鲁G", "local");
//        TERRITORY_LOCAL_MAP.put("鲁V", "local");
        
        TERRITORY_MAP.put("本地车", "local");
        TERRITORY_MAP.put("外地车", "non_local");
        
        // 潍坊车牌为本地车
        TERRITORY_LOCAL_SET.add("鲁G");
        TERRITORY_LOCAL_SET.add("鲁V");
    }
    
  //结构化视频总量统计
    public static final int SVD_COUNT_THRESHOLD = 100;//数据统计更新阀值
}

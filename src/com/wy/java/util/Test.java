package com.wy.java.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author wuyong
 * @date 2016年1月20日 下午2:22:26
 */
public class Test {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Random random = new Random();
        long t1 = System.currentTimeMillis();
        int sum = 3*1024*1024/10;
        for (int i = 0; i < sum; i++) {
            List<String> list = new ArrayList<String>();
            list.add(String.valueOf(random.nextInt(100)));
            list.add(String.valueOf(random.nextInt(100)));
            list.add(String.valueOf(random.nextInt(100)));
            list.add(String.valueOf(random.nextInt(100)));
            map.put(String.valueOf(i), list);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("文件个数:"+sum);
        System.out.println("创建时间："+(t2-t1));
        t1 = System.currentTimeMillis();
        String temp = String.valueOf(random.nextInt(100));
        int count =0;
        for(String key:map.keySet()){
            for(String value:map.get(key)){
                if(temp.equals(value)){
                    count++;
                   
                }
            }
        }
        System.out.println(count+"=="+temp);
        t2= System.currentTimeMillis();
        System.out.println("查找时间："+(t2-t1));
    }

}

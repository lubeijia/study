package com.wy.java.util.timer;

import java.util.Timer;

/**
 * @author wuyong
 * @date 2016年1月11日 下午12:26:28
 */
public class TestTimer {

    public static void main(String[] args) {
//        Timer timer1 = new Timer(false);// 非守护线程,会一直运行
//        timer1.schedule(new MyTimer("jake", false), 1000, 2000);
        Timer timer2 = new Timer(true);// 守护进程，主程序结束后，自动结束
        timer2.schedule(new MyTimer("wuyong", true), 0, 1000);

        // 主程序5秒后结束
        int count = 0;
        while (count < 5) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count++;
        }

    }

}

package com.wy.java.util.timer;

import java.util.TimerTask;

/**
 * @author wuyong
 * @date 2016年1月11日 下午12:27:17
 */
public class MyTimer extends TimerTask {
    private static long count = 0;
    private boolean isDaemon;
    private String name;

    public MyTimer(String name, boolean isDaemon) {
        super();
        this.isDaemon = isDaemon;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(
                "我是一个计时器，我的名字是" + name + ".并且我是一个" + (isDaemon ? "守护进程" : "非守护进程") + "进行，这是我第" + (++count) + "次执行.");
    }

}

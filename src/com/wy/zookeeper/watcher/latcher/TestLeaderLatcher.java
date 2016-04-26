package com.wy.zookeeper.watcher.latcher;

/**
 * @author wuyong
 * @date 2015年12月29日 下午3:18:16
 */
public class TestLeaderLatcher {
    public static void main(String[] args) {
        for(int i = 1;i<5;i++){
            LeaderLatcherDemo latcherDemo = new LeaderLatcherDemo("L"+i,i*10);
            latcherDemo.start();
        }
    }
}

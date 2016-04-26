package com.wy.zookeeper.watcher.latcher;

import org.apache.curator.framework.recipes.leader.LeaderLatchListener;

/**
 * 如果领导者不死亡，他会一直运行.
 * 
 * @author wuyong
 * @date 2015年12月29日 下午3:00:14
 */
public class MyLeaderLatcherListener implements LeaderLatchListener {
    private String name;

    public MyLeaderLatcherListener(String name) {
        super();
        this.name = name;
    }

    @Override
    public void isLeader() {
        System.out.println(name + "==========I am leader!");
    }

    @Override
    public void notLeader() {
        System.out.println(name + "==========I am not leader anymore!");
    }

}

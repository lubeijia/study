package com.wy.zookeeper.watcher.select;

import java.util.Random;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;

/**
 * @author wuyong
 * @date 2015年12月29日 下午3:57:55
 */
public class MyLeaderSelectorListener implements LeaderSelectorListener {
    private String name;
    private int count= 0;
    private int countChange = 0;
    public MyLeaderSelectorListener(String name) {
        super();
        this.name = name;
    }

    @Override
    public void stateChanged(CuratorFramework arg0, ConnectionState arg1) {
        countChange++;
        System.out.println(name + " say: I am changed!----"+countChange+" time");
        
    }

    /**
     * 成为leader时，会调用该方法
     */
    @Override
    public void takeLeadership(CuratorFramework arg0) throws Exception {
        count++;
        System.out.println(name + "======I am Leader!-----"+count+" time");
        Thread.sleep(1000*((new Random().nextInt(3))));
        System.out.println(name+"让出领导权！");
    }
}

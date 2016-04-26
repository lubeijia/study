package com.wy.zookeeper.watcher.latcher;

import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatch.CloseMode;
import org.apache.curator.retry.RetryNTimes;

import com.wy.constants.Constants;

/**
 * @author wuyong
 * @date 2015年12月29日 下午3:01:55
 */
public class LeaderLatcherDemo extends Thread {
    private int countMax = 30;
    private String name;
    private boolean isContinue = true;

    public LeaderLatcherDemo(String name, int countMax) {
        this.countMax = countMax;
        this.name = name;
    }

    @Override
    public void run() {
        CuratorFramework curator = null;
        LeaderLatch leaderLatch = null;
        curator = CuratorFrameworkFactory.newClient(Constants.ZOOKEEPER_CONNECT, 5000, 3000, new RetryNTimes(5, 1000));
        leaderLatch = new LeaderLatch(curator, Constants.ZOOKEEPER_WATCHER_LEADER_LATCHER_PATH + "demo", name,
                CloseMode.NOTIFY_LEADER);
        MyLeaderLatcherListener myLeaderLatcherListener = new MyLeaderLatcherListener(name);
        leaderLatch.addListener(myLeaderLatcherListener);
        curator.start();
        try {
            leaderLatch.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("leaderLatcher" + name + "启动失败！");
        }
        int count = 1;
        System.out.println(name + " begin  run.");
        while (isContinue) {
            try {
                // path改变，首次启动时，异常：无法获取到leader
                // System.out.println(name + " say:leader is ======" +
                // leaderLatch.getLeader().getId());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count > countMax) {
                stopTask();
            }
        }
        System.out.println(name + " is  stop.");
        try {
            leaderLatch.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        curator.close();
    }

    public void stopTask() {
        isContinue = false;
    }
}

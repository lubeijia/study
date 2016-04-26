package com.wy.zookeeper.watcher.select;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;

import com.wy.constants.Constants;

/**
 * @author wuyong
 * @date 2015年12月29日 下午4:05:06
 */
public class LeaderSelectorDemo extends Thread {
    private String name;
    private boolean isContinue = true;

    public LeaderSelectorDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        MyLeaderSelectorListener myLeaderSelectorListener = new MyLeaderSelectorListener(name);
        CuratorFramework client = CuratorFrameworkFactory.newClient(Constants.ZOOKEEPER_CONNECT,
                new RetryNTimes(10, 5000));
        LeaderSelector leaderSelector = new LeaderSelector(client, Constants.ZOOKEEPER_WATCHER_LEADER_SELECTOR_PATH,
                myLeaderSelectorListener);
        leaderSelector.autoRequeue();// ---------------自动轮询
        client.start();
        leaderSelector.start();
        System.out.println(name + " begin  run.");
        while (isContinue) {
            try {
                // System.out.println(name + " say: leader is
                // ---"+leaderSelector.getLeader().getId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " is  stop.");
        CloseableUtils.closeQuietly(leaderSelector);
        CloseableUtils.closeQuietly(client);
    }

    public void stopTask() {
        isContinue = false;
        System.out.println(name + " 执行stop");
    }

    public String getName1() {
        return name;
    }
}

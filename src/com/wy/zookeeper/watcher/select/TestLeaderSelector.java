package com.wy.zookeeper.watcher.select;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuyong
 * @date 2015年12月29日 下午4:29:22
 */
public class TestLeaderSelector {
    public static void main(String[] args) {
        List<LeaderSelectorDemo> selectors = new LinkedList<LeaderSelectorDemo>();
        for (int i = 1; i < 10; i++) {
            LeaderSelectorDemo leaderSelectorDemo = new LeaderSelectorDemo("Selector" + i);
            leaderSelectorDemo.start();
            selectors.add(leaderSelectorDemo);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        for (int i = 0; i < 5; i++) {
            
            System.out.println("remove=="+i+"===" + selectors.get(i).getName1());
            selectors.get(i).stopTask();
//            selectors.remove(i);
        }

        try {
            Thread.sleep(31000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (LeaderSelectorDemo leaderSelectorDemo : selectors) {
            leaderSelectorDemo.stopTask();
        }
    }
}

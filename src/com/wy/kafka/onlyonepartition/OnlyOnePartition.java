package com.wy.kafka.onlyonepartition;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class OnlyOnePartition implements Partitioner<Object> {
    public OnlyOnePartition(VerifiableProperties props) {
    }

    @Override
    public int partition(Object arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

}

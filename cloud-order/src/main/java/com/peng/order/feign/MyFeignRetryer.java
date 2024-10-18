package com.peng.order.feign;

import feign.RetryableException;
import feign.Retryer;

public class MyFeignRetryer implements Retryer {
    private int start = 1;
    private int end = 3;

    @Override
    public void continueOrPropagate(RetryableException e) {
        if ( start >= end) {

        }
    }

    @Override
    public Retryer clone() {
        return new MyFeignRetryer() ;
    }
}

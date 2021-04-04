package com.zipcodewilmington.dashamaps;

public interface HashMapX {

    // fundamentals
    void set(String key, Integer value);
    void delete(String key);
    Integer get(String key);
    boolean isEmpty();
    long size();

    // testing access
    //protected boolean bucketSize(String key); // used for tests
}

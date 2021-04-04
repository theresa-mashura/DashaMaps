package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapOneTest {

    public DashaMapOne d;

    @Before
    public void setup(){
        this.d = new DashaMapOne();
    }

    @Test
    public void testSize() {
        // Given
        d.set("cat", 20);
        d.set("cool", 9);
        d.set("zebra", 18);
        d.delete("cat");

        // When
        long actual = d.size();

        // Then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testConstructor() {
        // When
        int actualSize = d.getHeadList().length;

        // Then
        Assert.assertEquals(26, actualSize);

    }

    @Test
    public void testGetIndex() {
        // When
        int actualA = d.getIndex("a");
        int actualZ = d.getIndex("z");

        // Then
        Assert.assertEquals(0, actualA);
        Assert.assertEquals(25, actualZ);
    }

    @Test
    public void testSet() {
        // Given
        Integer expectedBall = 22;
        Integer expectedA = 5;

        // When
        d.set("ball", 22);
        d.set("a", 5);

        // Then
        Assert.assertEquals(expectedBall, d.get("ball"));
        Assert.assertEquals(expectedA, d.get("a"));
    }

    @Test
    public void appendTo() {
        // Given
        String keyHash = "e";
        Node node = new Node("extra", 12);

        // When
        d.appendTo(keyHash, node);

        // Then
        Assert.assertEquals((Integer) 12, d.get("extra"));
    }

    @Test(expected = NullPointerException.class)
    public void delete() {
        // Given
        d.set("hello", 77);

        // When
        d.delete("hello");

        // Then
        d.get("hello");
    }

    @Test
    public void findIn() {
        // Given
        String key = "happy";
        String keyHash = d.hashFunctionOne(key);
        d.set(key, 22);

        // When
        Node actualNode = d.findIn(keyHash, key);

        // Then
        Assert.assertEquals(key, actualNode.getK());
        Assert.assertEquals((Integer) 22, actualNode.getV());
    }



}

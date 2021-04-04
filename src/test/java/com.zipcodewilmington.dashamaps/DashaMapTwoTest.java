package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapTwoTest {

    public DashaMapTwo d;

    @Before
    public void setup(){
        this.d = new DashaMapTwo();
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
        Integer expected = 22;

        // When
        d.set("ball", 22);

        // Then
        Assert.assertEquals(expected, d.get("ball"));
    }

    @Test
    public void appendTo() {
        // Given
        String keyHash = "x";
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
        String keyHash = d.hashFunctionTwo(key);
        d.set(key, 22);

        // When
        Node actualNode = d.findIn(keyHash, key);

        // Then
        Assert.assertEquals(key, actualNode.getK());
        Assert.assertEquals((Integer) 22, actualNode.getV());
    }
}

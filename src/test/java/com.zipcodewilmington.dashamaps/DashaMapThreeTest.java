package com.zipcodewilmington.dashamaps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DashaMapThreeTest {

    public DashaMapThree d;

    @Before
    public void setup(){
        this.d = new DashaMapThree();
    }

    @Test
    public void hashFunctionThree() {
        // Given
        String str = "apple";

        // When
        String actual = d.hashFunctionThree(str);

        // Then
        System.out.println(actual);
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
        Assert.assertEquals(702, actualSize);

    }

    @Test
    public void testGetIndex() {
        // When
        int actualA = d.getIndex("ab");
        int actualZ = d.getIndex("zz");

        // Then
        Assert.assertEquals(27, actualA);
        Assert.assertEquals(701, actualZ);
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
    public void testAppendTo() {
        // Given
        String keyHash = "ex";
        Node node = new Node("extra", 12);

        // When
        d.appendTo(keyHash, node);

        // Then
        Assert.assertEquals((Integer) 12, d.get("extra"));
    }

    @Test(expected = NullPointerException.class)
    public void testDelete() {
        // Given
        d.set("hello", 77);

        // When
        d.delete("hello");

        // Then
        d.get("hello");
    }

    @Test
    public void testFindIn() {
        // Given
        String key = "happy";
        String keyHash = d.hashFunctionThree(key);
        d.set(key, 22);

        // When
        Node actualNode = d.findIn(keyHash, key);

        // Then
        Assert.assertEquals(key, actualNode.getK());
        Assert.assertEquals((Integer) 22, actualNode.getV());
    }


    @Test
    public void testFindIn2() {
        // Given
        String key = "i";
        String keyHash = d.hashFunctionThree(key);

        d.set(key, 22);

        // When
        Node actualNode = d.findIn(keyHash, key);

        // Then
        Assert.assertEquals(key, actualNode.getK());
        Assert.assertEquals((Integer) 22, actualNode.getV());
    }
}

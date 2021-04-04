package com.zipcodewilmington.dashamaps;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestHarness {

    public void loadFile(HashMapX d){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("word-list.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String key = scanner.next();
                Integer value = scanner.nextInt();

                d.set(key, value);
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

/*
    @Test
    public void test1() {
        DashaMapOne d = new DashaMapOne();
        this.loadFile(d);
        System.out.println("value of i is: " + d.get("i")); //1
        System.out.println("value of me is: " + d.get("me")); //2
        System.out.println("value of same is: " + d.get("same")); //77
        System.out.println("value of now is: " + d.get("now")); //5
    }

    @Test
    public void test2() {
        DashaMapTwo d = new DashaMapTwo();
        this.loadFile(d);
        System.out.println("value of i is: " + d.get("i")); //1
        System.out.println("value of me is: " + d.get("me")); //2
        System.out.println("value of same is: " + d.get("same")); //77
        System.out.println("value of now is: " + d.get("now")); //5
    }

    @Test
    public void test3() {
        DashaMapThree d = new DashaMapThree();
        this.loadFile(d);
        System.out.println("value of i is: " + d.get("i")); //1
        System.out.println("value of me is: " + d.get("me")); //2
        System.out.println("value of same is: " + d.get("same")); //77
        System.out.println("value of now is: " + d.get("now")); //5
    }

 */
}

package com.zipcodewilmington.dashamaps;

public class Node {

    private String k;
    private Integer v;
    private Node next;

    public Node(String k){
        this.k = k;
        this.v = null;
        this.next = null;
    }

    public Node(String k, Integer v) {
        this.k = k;
        this.v = v;
        this.next = null;
    }

    public String getK() {
        return this.k;
    }

    public Integer getV() {
        return this.v;
    }

    public Node getNext() {
        return this.next;
    }

    public void setK(String k) {
        this.k = k;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

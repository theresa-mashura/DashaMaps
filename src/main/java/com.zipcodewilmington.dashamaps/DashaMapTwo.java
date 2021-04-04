package com.zipcodewilmington.dashamaps;

public class DashaMapTwo implements HashMapX {

    Node[] headList;
    long size;

    public DashaMapTwo() {
        this.headList = new Node[26];

        int j = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            this.headList[j] = new Node(String.valueOf(i));
            j++;
        }

        this.size = 0;
    }

    public Node[] getHeadList(){
        return this.headList;
    }

    public String hashFunctionTwo(String input) {
        if (input.length() > 0) {
            return (String.valueOf(input.charAt(1))).toLowerCase();
        }
        return null;
    }

    public Integer getIndex(String keyHash){
        char c = keyHash.charAt(0);
        int index = c - 97;
        return index;
    }

    public void set(String key, Integer value) {
        String keyHash = hashFunctionTwo(key);
        Node node = new Node(key, value);
        this.appendTo(keyHash, node);
    }

    public void appendTo(String keyHash, Node node) {
        int index = getIndex(keyHash);
        Node curr = headList[index];
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(node);

        size++;
    }

    public void delete(String key) {
        String keyHash = hashFunctionTwo(key);
        int index = getIndex(keyHash);

        Node curr = headList[index];
        // while the next item does not equals the key we're looking for
        while (!curr.getNext().getK().equals(key)) {
            curr = curr.getNext();
        }

        // set pointers & delete node
        Node temp = curr.getNext();
        curr.setNext(curr.getNext().getNext());
        temp = null;

        size--;
    }

    public Integer get(String key) {
        String keyHash = hashFunctionTwo(key);
        Node foundNode = findIn(keyHash, key);
        return foundNode.getV();
    }

    public Node findIn(String keyHash, String value) {
        int index = getIndex(keyHash);
        Node curr = headList[index].getNext();
        while (!curr.getK().equals(value)) {
            curr = curr.getNext();
        }
        return curr;
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    public long size() {
        return this.size;
    }

}

package com.zipcodewilmington.dashamaps;

public class DashaMapThree implements HashMapX {

    Node[] headList;
    long size;

    public DashaMapThree() {
        this.headList = new Node[702];

        int j = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            this.headList[j] = new Node(String.valueOf(i));
            j++;
        }

        for (char k = 'a'; k <= 'z'; k++) {
            for (char m = 'a'; m <= 'z'; m++) {
                this.headList[j] = new Node(String.valueOf(k+m));
                j++;
            }
        }

        this.size = 0;
    }

    public Node[] getHeadList(){
        return this.headList;
    }

    public String hashFunctionThree(String input) {
        if (input.length() > 1) {
            return ( String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(1)) ).toLowerCase();
        } else if (input.length() == 1) {
            return ( String.valueOf(input.charAt(0)) );
        }
        return null;
    }

    public Integer getIndex(String keyHash){
        int index;
        if (keyHash.length() == 1) {
            char c = keyHash.charAt(0);
            index = c - 97;
        } else {
            char c1 = keyHash.charAt(0);
            char c2 = keyHash.charAt(1);
            index = ((c1 - 97) + 1) * 26 + (c2 - 97);

            // first letter a = (97 -97) = 0, b = (98 - 97) = 1, c = (99 - 97) = 2
            // a = first group.....97 - 97 = 0... + 1 * 26 = 26 (first group starts at index 26)
            // b = second group....98 - 97 = 1... + 1 * 26 = 52 (second group starts at index 53)
            // c = third group.....99 0 97 = 2... + 1 * 26 = 78 (third group starts at index 78)

            // second letter should tell us where we are within each group
            // first letter = a, second letter = a then (97 - 97) = 0....0 + 26 = index 26
            // first letter = a, second letter = b then (98 - 97) = 1....1 + 26 = index 27
            // first letter = b, second letter = a then (97 - 97) = 0....0 + 53 = index 53
            // first letter = b, second letter = b then (98 - 97) = 1....1 + 53 = index 54

            // first letter = z, second letter = z then (122 - 97) = 25....25 + 676 = index 701
        }
        return index;
    }

    public void set(String key, Integer value) {
        String keyHash = hashFunctionThree(key);
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
        String keyHash = hashFunctionThree(key);
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
        String keyHash = hashFunctionThree(key);
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

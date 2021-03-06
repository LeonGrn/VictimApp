package com.example.victimapp;

public class Pair implements Comparable {

    private String address;
    private String body;

    public Pair(String left, String right) {

        this.address = left;
        this.body = right;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "address='" + address + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object pair) {
        Pair tempPair = (Pair)pair;
        return this.address.compareTo(tempPair.address);
    }
}
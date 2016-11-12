package com.may.java.algorithm.cardgame;

class Card {
    private char sort; // 카드 종류
    private char number; // 카드 숫자

    public Card(char sort, char number) {
        this.sort = sort;
        this.number = number;
    }

    public char getSort() {
        return sort;
    }

    public void setSort(char sort) {
        this.sort = sort;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(char number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return sort + "" + (int) number;
    }
}
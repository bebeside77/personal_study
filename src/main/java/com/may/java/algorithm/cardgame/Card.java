package com.may.java.algorithm.cardgame;

class Card {
        private char sort;
        private int number;

        public Card(char sort, int number) {
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

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return sort + "" + number;
        }
    }
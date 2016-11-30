package com.may.java.algorithm;

import java.util.Random;

/**
 * 문제) Spade, Diamond, Heart, Clover 무늬와 1부터 13까지의 숫자가 있는 총 52장의 카드가 있다.
 * S1, S2... S13,
 * D1, D2... D13,
 * H1, H2... H13,
 * C1, C2... C13
 * 으로 표시된다.
 * Player는 7장의 카드를 가지며, 숫자의 합이 제일 작은 사람이 이긴다.
 * <p>
 * 4명의 Player에게 중복없이 랜덤하게 카드를 나누고, 이긴 Player를 출력하는 프로그램을 완성하시오.
 * 숫자의 합이 제일 작은 Player가 2명 이상이면 1명이 승리할 때까지 반복한다.
 * <p>
 * 출력예)
 * Player1: H2, H8, D5, D9, S12, S9, C13 : sum = 58
 * Player2: C8, C6, S4, D4, D12, C2, C12 : sum = 48
 * Player3: C10, S1, D2, D7, D10, C11, C9 : sum = 50
 * Player4: D8, D1, H6, H13, C7, H10, S8 : sum = 53
 * <p>
 * Winner : Player2
 * <p>
 * 요구 사항이 모호하다면, 그 부분을 재정의하여 서술하고 구현하시오.
 * * 시간 복잡도와 메모리 이슈, 최적의 성능에 중점을 두고, 읽기 좋은 코드로 작성.
 * <p>
 *
 * [요구 사항 재정의]
 * - 동점자 발생 시 4명 전부 게임 재시작함
 * - 다음 순서로 중요성을 두고 작성(성능 > 메모리 > 가독성)
 *
 * @author bebeside77
 */
public class CardGame {
    private static final int PLAYER_NUM = 4;
    private static final int CARD_NUM_PER_PLAYER = 7;
    private static final char[] CARD_SORTS = {'S', 'D', 'H', 'C'};
    private static final int CARD_NUM_PER_SORT = 13;
    private static final Random RANDOM = new Random();

    private Card[][] playersCards = new Card[PLAYER_NUM][CARD_NUM_PER_PLAYER];
    private Card[] allCards = new Card[CARD_SORTS.length * CARD_NUM_PER_SORT];

    private int[] playersScore = new int[PLAYER_NUM];
    private int winner = -1;

    public CardGame() {
        makeAllCards();
    }

    public void playTheGame() {
        giveCardsToPlayers();

        boolean needReplay = computeResult();

        // 동점자 있을 경우 다시 게임 아니면 결과 출력
        if (needReplay) {
            winner = -1;
            playTheGame();
        } else {
            printResult();
        }
    }

    /**
     * 카드 52장 생성
     */
    private void makeAllCards() {
        int cardIndex = 0;

        for (char CARD_SORT : CARD_SORTS) {
            for (char i = 1; i <= CARD_NUM_PER_SORT; i++) {
                allCards[cardIndex++] = new Card(CARD_SORT, i);
            }
        }
    }

    /**
     * 플레이어들에게 카드 랜덤하게 할당
     */
    private void giveCardsToPlayers() {
        int giveCounter = 0;

        for (int i = 0; i < PLAYER_NUM; i++) {
            for (int j = 0; j < CARD_NUM_PER_PLAYER; j++) {
                int cardSelectBound = allCards.length - 1 - giveCounter;
                int rand = RANDOM.nextInt(cardSelectBound + 1);

                playersCards[i][j] = allCards[rand];

                swapCard(cardSelectBound, rand);

                giveCounter++;
            }
        }
    }

    /**
     * 플레이어별 점수 계산, 승자 선출
     *
     * @return 재경기 필요 여부
     */
    private boolean computeResult() {
        boolean needReplay = false;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int sum = 0;

            for (int j = 0; j < CARD_NUM_PER_PLAYER; j++) {
                sum += playersCards[i][j].getNumber();
            }

            playersScore[i] = sum;

            if (i == 0) {
                winner = 0;
                continue;
            }

            if (sum < playersScore[winner]) {
                winner = i;
                needReplay = false;
            } else if (sum == playersScore[winner]) {
                needReplay = true;
            }
        }
        return needReplay;
    }

    private void swapCard(int index1, int index2) {
        Card temp = allCards[index1];
        allCards[index1] = allCards[index2];
        allCards[index2] = temp;
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playersCards.length; i++) {
            Card[] cards = playersCards[i];

            sb.append("Player").append(i + 1).append(": ");

            for (int j = 0; j < cards.length; j++) {
                sb.append(cards[j]);

                if (j + 1 < cards.length) {
                    sb.append(", ");
                }
            }

            sb.append(" : sum = ").append(playersScore[i]).append("\n");
        }

        sb.append("\nWinner : Player").append(winner + 1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new CardGame().playTheGame();
    }
}

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
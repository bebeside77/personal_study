/*
 * @(#)CardGame.java  2016.11.11
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.algorithm.cardgame;

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
 *
 * => 시간 복잡도가 낮고 메모리를 적게 쓰며 성능이 좋은 프로그램을 목적으로 함
 *
 * @author yuwook
 */
public class CardGame {
    private static final int PLAYER_NUM = 4;
    private static final int CARD_NUM_PER_PLAYER = 7;
    private static final char[] CARD_SORTS = {'S', 'D', 'H', 'C'};
    private static final int CARD_NUM_PER_SORT = 13;
    private static final Random RANDOM = new Random();

    public void playTheGame() {
        Card[][] playersCards = new Card[PLAYER_NUM][CARD_NUM_PER_PLAYER];

        // 카드 52장 생성
        Card[] allCards = new Card[CARD_SORTS.length * CARD_NUM_PER_SORT];
        int k = 0;

        for (char CARD_SORT : CARD_SORTS) {
            for (int j = 1; j <= CARD_NUM_PER_SORT; j++) {
                allCards[k++] = new Card(CARD_SORT, j);
            }
        }

        // 플레이어들에게 7장씩 카드 랜덤하게 할당
        int l = 0;

        for (int j = 0; j < PLAYER_NUM; j++) {
            for (int i = 0; i < CARD_NUM_PER_PLAYER; i++) {
                int rand = RANDOM.nextInt(allCards.length - l);

                playersCards[j][i] = allCards[rand];

                Card temp = allCards[allCards.length - 1 - l];
                allCards[allCards.length - 1 - l] = allCards[rand];
                allCards[rand] = temp;

                l++;
            }
        }

        // 점수 계산, 승자 선출
        int[] playerScore = new int[PLAYER_NUM];
        int winner = 0;
        int winnerScore = 0;
        boolean needReplay = false;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int sum = 0;

            for (int j = 0; j < CARD_NUM_PER_PLAYER; j++) {
                sum += playersCards[i][j].getNumber();
            }

            playerScore[i] = sum;

            if (i == 0) {
                winnerScore = sum;
            } else if (sum < winnerScore) {
                winner = i;
                winnerScore = sum;
                needReplay = false;
            } else if (sum == winnerScore) {
                needReplay = true;
            }
        }

        // 동점자 있을 경우 다시 게임 아니면 결과 출력
        if (needReplay) {
            playTheGame();
        } else {
            printResult(playersCards, playerScore, winner);
        }
    }

    private void printResult(Card[][] playersCards, int[] playerScore, int winner) {
        int playerIndex = 0;

        for (int i = 0; i < playersCards.length; i++) {
            Card[] cards = playersCards[i];
            StringBuilder sb = new StringBuilder();

            sb.append("Player").append(++playerIndex).append(": ");

            for (int j = 0; j < cards.length; j++) {
                sb.append(cards[j]);

                if (j + 1 < cards.length) {
                    sb.append(", ");
                }
            }

            sb.append(" : sum = ").append(playerScore[i]);

            System.out.println(sb.toString());
        }

        System.out.println("\nWinner : Player" + (winner + 1));
    }

    public static void main(String[] args) {
        new CardGame().playTheGame();
    }
}


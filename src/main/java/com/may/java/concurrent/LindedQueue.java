/*
 * @(#)LindedQueue.java  2016.02.17
 *
 * Copyright 2016 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class LindedQueue <E> {
    private static class Node <E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);

        while (true) {
            Node<E> curTail = tail.get(); // 현재 꼬리
            Node<E> tailNext = curTail.next.get(); // 현재 꼬리의 다음 노드

            if (curTail == tail.get()) { // 꼬리가 그 사이 변했을 수 있어서 한번 더 체크

                if (tailNext != null) { // 꼬리의 다음 노드가 뭔가를 가르키고 있다면 중간 상태임
                    // 큐는 중간 상태이고, 꼬리 이동
                    tail.compareAndSet(curTail, tailNext);
                } else { // 꼬리의 다음 노드가 null 이라면 평온한 상태임
                    // 평온한 상태에서 항목 추가 시도
                    if (curTail.next.compareAndSet(null, newNode)) {
                        // 추가 작업 성공, 꼬리 이동 시도
                        tail.compareAndSet(curTail, newNode);

                        return true; // put이 끝나는 유일한 경우
                    }
                }
            }
        }
    }

}

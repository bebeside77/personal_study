/*
 * @(#)ConcurrentStack.java  2016.02.17
 *
 * Copyright 2016 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class ConcurrentStack<E> {
    AtomicReference<Node<E>> top = new AtomicReference<>();

    /**
     * 다른 스레드가 다른 걸 push 해놓는다고 무한 루프 되는 것은 아니다.
     * 왜냐하면 oldHead를 계속 갱신시키고 있기 때문에.
     *
     * @param item
     */
    public void push(E item) {
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead;

        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;

        do {
            oldHead = top.get();

            if (oldHead == null) {
                return null;
            }

            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));

        return oldHead.item;
    }

    private static class Node<E> {
        public final E item;
        public Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        ConcurrentStack<String> concurrentStack = new ConcurrentStack<>();
        concurrentStack.push("one");
        concurrentStack.push("two");

        log.info(concurrentStack.pop());
        log.info(concurrentStack.pop());
        log.info(concurrentStack.pop());
    }
}

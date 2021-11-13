/**
 * @(#) MyQueue.class 1.0.0 2021. 11. 13.
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Queue implemented by two stacks.
 *
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
public class MyQueue {
	private final Stack a = new Stack();
	private final Stack b = new Stack();

	public String get() {
		if (b.size() > 0) {
			return b.pop();
		}

		if (a.size() == 0) {
			return null;
		}

		while (a.size() > 0) {
			b.push(a.pop());
		}

		return b.pop();
	}

	public void add(String element) {
		a.push(element);
	}
}

class Stack {
	private final List<String> elements = new ArrayList<>();

	public void push(String element) {
		elements.add(element);
	}

	public String pop() {
		if (elements.size() == 0) {
			return null;
		}

		return elements.remove(elements.size() - 1);
	}

	public int size() {
		return elements.size();
	}
}
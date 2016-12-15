package com.may.java.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author bebeside77
 */
public class InheritSynchronized {

	/**
	 * synchronized doesn't inherited to child.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Parent parent = new Child();

		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		threadPoolExecutor.execute(parent::doThat);
		threadPoolExecutor.execute(parent::doThat);
		threadPoolExecutor.shutdown();
	}

}

class Parent {
	public synchronized void doThat() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("parent do that!");
	}
}

class Child extends Parent {
	public void doThat() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("child do that!");
	}
}
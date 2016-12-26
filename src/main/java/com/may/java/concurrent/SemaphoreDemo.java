package com.may.java.concurrent;

import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author bebeside77
 */
@Slf4j
public class SemaphoreDemo {
	private Semaphore semaphore = new Semaphore(1);

	public void bark() {
		try {
			semaphore.acquire();

			log.info("bow wow!");
		} catch (InterruptedException e) {
			log.error("", e);
		} finally {
			semaphore.release(); // if acquire must release.
		}
	}

	public static void main(String[] args) {
		SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
		semaphoreDemo.bark();
	}
}

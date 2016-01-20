/*
 * @(#)PrimeProducer.java  2016.01.19
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author yuwook
 */
@Slf4j
public class PrimeProducer extends Thread {
	private final BlockingQueue<BigInteger> queue;

	public PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			BigInteger p = BigInteger.ONE;

			while (true) { // 필수 체크는 아님, put에서 인터럽트 예외가 발생되기 때문에
				queue.put(p = p.nextProbablePrime());
			}
		} catch (InterruptedException consumed) {
			// thread ends.
			log.info("PrimeProducer is interrupted!");
		}
	}

	public void cancel() {
		interrupt();
	}

	public static void main(String[] args) throws InterruptedException {
		PrimeProducer primeProducer = new PrimeProducer(new ArrayBlockingQueue<>(10));

		primeProducer.start();
		log.info("PrimeProducer is started!");

		Thread.sleep(2000);

		primeProducer.cancel();
	}
}

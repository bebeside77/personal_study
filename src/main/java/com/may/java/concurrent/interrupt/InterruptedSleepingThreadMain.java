/*
 * @(#)InterruptTest3.java  2016.01.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

/**
 * @author yuwook
 */
public class InterruptedSleepingThreadMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		InterruptedSleepingThread thread = new InterruptedSleepingThread();
		thread.start();
		//Giving 10 seconds to finish the job.
		Thread.sleep(10000);
		//Let me interrupt
		thread.interrupt();

		System.out.println("now222 => " + thread.isInterrupted());
	}

}

class InterruptedSleepingThread extends Thread {

	@Override
	public void run() {
		doAPseudoHeavyWeightJob();
	}

	private void doAPseudoHeavyWeightJob() {
		for (int i=0;i<Integer.MAX_VALUE;i++) {
			//You are kidding me
			System.out.println(i + " " + i*2);
			//Let me sleep <evil grin>
			if (currentThread().isInterrupted()) {
				System.out.println("Thread interrupted\n Exiting...");
				break;
			}else {
				sleepBabySleep();
			}
		}


	}

	protected void sleepBabySleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// 상위 호출 메소드에서 인터럽트 처리가 가능하도록 인터럽트 상태를 유지시킨다
			System.out.println("now => " + Thread.currentThread().isInterrupted());
			//Thread.currentThread().interrupt();

		}
	}
}
package com.may.java.concurrent.lock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *
 * @author bebeside77
 */
public class FileLockTest2 {

	public static void main(String[] args) {
		File file = new File(args[0]);
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		FileChannel channel = fileOutputStream.getChannel();

		FileLock fileLock1 = null;
		try {
			fileLock1 = channel.tryLock();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("lock1 valid : " + fileLock1.isValid());

		FileLock fileLock2 = null;
		try {
			fileLock2 = channel.tryLock();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("lock2 valid : " + fileLock2.isValid());

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (fileLock1.isValid()) {
			try {
				fileLock1.release();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

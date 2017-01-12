package com.may.java.concurrent.lock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bebeside77
 */
public class FileLockTest3 {
	private static Set<FileLock> fileLocks = new HashSet<>();

	public static void main(String[] args) {
		File file = new File("D:\\data\\people.txt");
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

		fileLocks.add(fileLock1);

		Thread thread = new Thread(() -> {
			for (FileLock fileLock : fileLocks) {
				try {
					fileLock.release();
					System.out.println("release " + fileLock.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("lock1 valid : " + fileLock1.isValid());

	}

}

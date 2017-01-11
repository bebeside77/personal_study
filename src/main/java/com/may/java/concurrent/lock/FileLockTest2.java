package com.may.java.concurrent.lock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *
 * @author bebeside77
 */
public class FileLockTest2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File(args[0]);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		FileChannel channel = fileOutputStream.getChannel();

		FileLock fileLock = channel.tryLock();

		System.out.println("lock valid : " + fileLock.isValid());

		Thread.sleep(10000);

		if (fileLock.isValid()) {
			fileLock.release();
		}
	}
}

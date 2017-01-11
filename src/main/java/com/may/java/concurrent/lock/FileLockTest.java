package com.may.java.concurrent.lock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("D:\\data\\people.txt");
		FileChannel channel = new FileOutputStream(file).getChannel();

		long now = System.nanoTime();

		for (int i = 0; i < 1000000; i++) {
			FileLock fileLock = channel.tryLock();
			fileLock.release();
		}

		System.out.println((System.nanoTime() - now) / 1000 / 1000 + " milli seconds passed.");
	}
}
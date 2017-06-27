package com.may.java;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bebeside77
 */
@Slf4j
public class CommandExecutor {

	public static void main(String[] args) throws IOException {
		String[] rsyncCommand = {"cmd.exe", "/c", "echo", "hello"};

		DefaultExecutor executor = new DefaultExecutor();
		CommandLine commandLine = CommandLine.parse(rsyncCommand[0]);

		for (int i = 1; i < rsyncCommand.length; i++) {
			commandLine.addArgument(rsyncCommand[i]);
		}

		int exitCode = executor.execute(commandLine);
		if (exitCode != 0) {
			log.error("error!!");
		}
	}
}

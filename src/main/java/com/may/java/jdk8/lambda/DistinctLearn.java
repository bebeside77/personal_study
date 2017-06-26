package com.may.java.jdk8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bebeside77
 */
@Slf4j
public class DistinctLearn {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(1);
		integers.add(1);
		integers.add(2);
		integers.add(2);
		integers.add(3);

		log.info("" + integers.stream().distinct().collect(Collectors.toList())); // [1, 2, 3]
		log.info("" + integers.stream().collect(Collectors.toList())); // [1, 1, 2, 2, 3]
		log.info("" + integers.stream().collect(Collectors.toSet())); // [1, 2, 3]

	}
}

package com.may.java;

import lombok.Data;

/**
 * @author bebeside77
 */
public class LombokTest {
	@Data
	static class Animal {
		String name;
	}

	@Data
//	@ToString(callSuper = true)
//	@EqualsAndHashCode(callSuper = true)
	static class Cat extends Animal {
		String color;
	}

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		cat1.setName("kitty");
		cat1.setColor("white");

		Cat cat2 = new Cat();
		cat2.setName("cat");
		cat2.setColor("white");

		System.out.println(cat1.equals(cat2)); // true
		System.out.println(cat1.toString()); // Cat(color=white)
		System.out.println(cat2.toString()); // Cat(color=white)
	}
}

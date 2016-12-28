package com.jorge.lambdas.animal;

import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>(); // list of animals
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));
		print(animals, new CheckIfHopper()); // pass class that does check
		print(animals, a -> a.canHop()); //es lo mismo que lo de arriba. Nos podemos ahorrar la clase CheckIfHopper
		
		
		
		List<String> bunnies = new ArrayList<>();
		bunnies.add("long ear");
		bunnies.add("floppy");
		bunnies.add("hoppy");
		System.out.println(bunnies); // [long ear, floppy, hoppy]
		bunnies.removeIf(s -> s.charAt(0) != 'h');
		System.out.println(bunnies); // [hoppy]
	}

	private static void print(List<Animal> animals, CheckTrait checker) {
		
		for (Animal animal : animals) {
			if (checker.test(animal)) // the general check
				System.out.print(animal + " ");
		}
		
		System.out.println();
		
	}
}

package com.jorge.lambdas.persona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Persona> milista = new ArrayList<Persona>();
		milista.add(new Persona("Miguel"));
		milista.add(new Persona("Alicia"));

		//Sin utilizar lambdas
		Collections.sort(milista, new Comparator<Persona>() {

			public int compare(Persona p1, Persona p2) {

				return p1.getNombre().compareTo(p2.getNombre());
			}

		});
		
		System.out.println("SIN USAR LAMBDAS:");
		for (Persona p : milista) {

			System.out.println(p.getNombre());

		}

		
		
		//Utilizando lambdas
		Collections.sort(milista, (Persona p1,Persona p2)-> p1.getNombre().compareTo(p2.getNombre()));
		
		System.out.println("USANDO LAMBDAS:");
		for (Persona p : milista) {

			System.out.println(p.getNombre());

		}
	}

}

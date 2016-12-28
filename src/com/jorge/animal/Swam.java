package com.jorge.animal;

import com.jorge.main.Bird;

public class Swam extends Bird{

	protected String textSwam = "swwwwaaammm!";
	
	public void haceRuidito(){
		//No hace falta instanciar el objeto Swam para acceder a las propiedades protected de su  padre. Pero no hace
		//falta instanciarlo porque es su padre (hereda de él), no porque sea protected
		System.out.println(text); //Acceso a variable text de su clase padre porque es protected
		makeNoise(); //Acceso a método makeNoise() de su clase padre Bird porque es protected
	}
	
	public void haceRuidito2(){
		Swam swam = new Swam();//Instanciamos el objeto Swam
		
		System.out.println(swam.text); //Lo mismo que lo de arriba pero esta vez instanciando el objeto Swam
		swam.makeNoise(); //Lo mismo que lo de arriba pero esta vez instanciando el objeto Swam
	}
	
	public void haceruidito3(){
		Bird bird = new Bird();
		
		//System.out.println(bird.text); //ERRORRRRRRR Bird no es un objeto que herede de Bird o esté en el mismo paquete que Swam
		//bird.makeNoise(); //ERRORRRRRRR Bird no es un objeto que herede de Bird o esté en el mismo paquete que Swam
	}
	
	public void haceruidito4(){
		Bird2 bird2 = new Bird2();
		
		System.out.println(bird2.text2); //CORRECTOOOOOO no hereda de Bird2 pero está en el mismo paquete
		bird2.makeNoise2(); //CORRECTOOOOOO no hereda de Bird2 pero está en el mismo paquete
	}
}

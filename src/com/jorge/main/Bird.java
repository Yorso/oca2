package com.jorge.main;

import com.jorge.animal.Swam;

//public class Bird extends Swam { //ERRORRRR ciclo detectado: Swam está heredando de Bird, luego Bird no puede heredar de Swam
public class Bird {
	protected String text = "Quack";
	
	protected void makeNoise(){
		System.out.println("NOISE: " + text);
		Swam swam = new Swam();
		System.out.println(swam.text); //De esta forma se está accediendo a la porpiedad swam de esta misma clase (BIrd)
		                               //a través de instanciar el objeto Swam,  el cual tiene acceso a la prpiedad text de Bird porque hereda
		                               //de Bird y text es protected.. Es decir, Bird accede a su propia propiedad text através de Swam
		
		//System.out.println(swam.textSwam);//ERRORRRRRRRR desde Bird no podemos acceder a la propiedad protected de Swam textSwam ya que
		                                  //Bird ni hereda de Swam (es al revés, Swam hereda de Bird) ni están en el mismo paquete
	}
}

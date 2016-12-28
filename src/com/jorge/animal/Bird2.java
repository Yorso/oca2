package com.jorge.animal;

public class Bird2 {
	protected String text2 = "Quack";
	
	protected void makeNoise2(){
		System.out.println("NOISE: " + text2);
	}
	
	public void accedeText(){
		//System.out.println("NOISE: " + textSwam);//ERRORRR: hay que instanciar Swam ya que Swam no es padre de Bird2, por lo que no puede acceder a sus propiedades sin instanciarse
		//Si Bird2 heredase de Swam (Swam es su padre), funcionaría, no haría falta instanciar Swam
		
		Swam swam = new Swam();
		System.out.println("NOISE: " + swam.textSwam); //Accede a la propiedad textSwam, que es protected.. como está en el mismo
													   //paquete pues se puede acceder a ella
	}
}

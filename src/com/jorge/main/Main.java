package com.jorge.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	//Ésto funcionaría
	public void methodA() { return;}
	//Ésto no, null lo toma como valor y la función tendría que ser void
	//public void methodB() { return null;}
	//Ésto tampoco, espera como retorno un String y hemos dicho que es void
	//public void methodC() { return "";}
	//No funciona, habría que hacer al resultado cast a int
	//public int methodE() { return 9.0;}
	//Tampoco funciona, está esperando un entero y no le devolvemos nada
	//public int methodF() { return;}
	//Tampoco, dice que no puede convertir null a int
	//public int methodF() { return null;}
	
	//Varargs mal formado, ... debe ir después del tipo, en este caso int
	//public void moreE(String[] values, ...int nums) {}
	
	
	public int howMany(boolean b, boolean... b2) {
		return b2.length;
	}
	{
	 //howMany(true, {true, true}); //Ésta forma de declaración con {} no es válida
	 howMany(true, new boolean[2]);
	 howMany(true, null);
	 howMany(true);
	}
	
	
	
	
	//Inicialización estática
	//The static initializer runs when the class is fi rst used.
	private static final int NUM_SECONDS_PER_HOUR;
	static {
		int numSecondsPerMinute = 60;
		int numMinutesPerHour = 60;
		NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
	}
	

	private static int one; //Se inicializa a su tipo => int = 0
	private static final int two; //La inicializamos en el bloque static. Como es FINAL, está obligada a inicializarse popr huevos ya sea aquí o en el bloque static
						          //No se podría inicializar dentro de un método
	private static final int three = 3;
	//private static final int four; //ERRORRRR Un FINAL debe siempre inicializarse. Una static (sólostatic sin final) no hace falta, se inicializa a su tipo
	static {
		one = 1; //Aquí le decimos que es 1
		two = 2; //Aquí inicializamos la final two
		//three = 3; ERRORRRR intentamos inicializar otra vez una final y no se puede, sólo se inicializa una vez y punto
		//two = 4; ERRROR por lo mismo que la linea de arriba, hemos inicializado two = 2; y ahora queremos otra vez y no es posible
	}
	
	private String name = "Static class";
	public int total = 8;
	private static int count = 2;
	
	private static final ArrayList<String> values = new ArrayList<>();
	
	public static void first() { }
	
	public static void second() { }
	
	public void third() { 
		System.out.println(name); 
	}
	
	public void fly(int i) {
		System.out.print("int ");
	}
	
	public void fly(long l) {
		System.out.print("long ");
	}
	
	public void fly(float f) {
		System.out.print("float " + f);
	}
		
		
	
	
	//ORDEN DE INICIALIZACIÓN => 0 10 read to construct Torchie 30 constructor
	/*
	private String name2 = "Torchie";
	{ System.out.println(name2); }
	
	private static int COUNT = 0; //Estática pero no FINAL
	static { System.out.println(COUNT); }
	static { COUNT += 10; System.out.println(COUNT); }
	{COUNT += 20; System.out.println(COUNT); }
	
	public Main() {
		System.out.println("constructor");
	}

	public static void main(String[] args) {
		System.out.println("read to construct");
		new Main();
	}
	*/
	
	//ORDEN DE INICIALIZACIÓN => 2 4 6 8 5 4556
	static { add(2); }
	static void add(int num) { System.out.print(num + " "); }
	Main() { add(5); } //OJOOOO    ésto es constructor, por delante del constructor van las variables e inicializadores de instancia
	static { add(4); }
	{ add(6); } //Inicializador de instancia
	static { new Main(); }
	static { add(4556); } //Aunque sea estático, como hacemos arriba new Main() le decimos que ya puede ir a por las variables de instancia
	                      //pintando 6 y 8 y por último va al constructor, pintando 5.. deja para lo último ésta add(4556); que hemos añadido aunque sea estática
	{ add(8); }  //Inicializador de instancia

	
	//public static int average = total / count; // DOES NOT COMPILE: Cannot make a static reference to the non-static field total
	
	
	
	
	public static long square(int x) {
		long y = x * (long) x;
		//short y2 = x * (long) x; //No funciona, quieres meter un long en un short
		//short y2 = x * x; //No funciona, quieres meter un int en un short
		short y2 = (short) (x * (long) x); //Funciona, casteamos el resultado a short para meterlo en un short
		x = -1;
		return y;
	}
	
	
	
	
	public static void main(String[] args) {
		//two = 2; //No se puede inicializar una FINAL en el método, debe hacerse en la definición de variables de instancia o en los inicializadores de instancia 
		
		run(11, 22); // Resultado: 22
		
		List<Integer> aList = new ArrayList<Integer> ();
		List<Integer> bList = new ArrayList<Integer> ();
		
		aList.add(1);
		aList.add(2);
		aList.add(3);
		
		bList.add(4);
		bList.add(5);
		bList.add(6);
		
		run2(aList, bList);
		
		first();
		second();
		//third(); //ERROR  intenta llamar a un método no estático desde uno estático
		new Main().third(); //Ésto sería una solución
		
		//Final en Listas nos deja manipular datos (add, replace, set, lo que sea...)
		values.add("changed"); //Permite añadir elementos a una lista FINAL!!!!
		values.set(0, "AAAAA"); //Permite cambiarlo!!!
		
		System.out.println(values.get(0)); // Muestra AAAAA
		
		//Lo que no nos deja FINAL en Listas es reasignarla a otro objeto distinto o nuevo
		//values = new ArrayList<>(); //Ésto no nos deja, estamos intentando reasignar values a un objeto nuevo y FINAL no nos deja hacerlo
				
		
		Main p = new Main();
		p.fly(123); //Si comentamos el método public void fly(int i) encajaría en el método public void fly(long l) sin cast ni nada
		            //Java no tiene problemas en llamar a una primitiva más grande
		p.fly(123L); //Si comentamos el método public void fly(long l) habría que añadir cast: p.fly((int) 123L); 
		//Si comentamos métodos int y long y creamos uno float: public void fly(float f), ambos callers se irán a este método float y si imprimimos su valor sería en ambos casos 123.0
		
	}
	
	public static void run(int... nums) {
		System.out.println(nums[1]);
	}
	
	public static void run2(List<Integer>... nums) { //Se crea una lista de List<Integer>
		System.out.println(nums[1].get(1)); //5  Coge la lista con index 1 y de ella el elemento con index 1
											//A los varargs se accede como en un array			
	}
		
	String walk(){
		return "";
	}
}

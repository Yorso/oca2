package com.jorge.exam;

public class Order {
	String value = "t";
	
	public int a(int a){ return 2;};
	public int a(){ return 2;};
	
   final String value1 = "1";
   static String value2 = "2";
   String value3 = "3";
   final String value4;
   
	{
		//value1 = "d"; //No se puede, value1 es FINAL y ya está inicializada arriba.
		value2 = "e"; //Aunque value2 sea estática, podemos meterla en este inicializador no estático
		value3 = "f";
		value4 = "g"; //Se puede, aunque sea final aún no se ha inicializado en ningún sitio
	}
	static {
		//value1 = "h"; //No se puede, value1 es FINAL y ya está inicializada arriba
		value2 = "i";
		//value3 = "j"; //No se puede, value3 tendría que ser estática
		//value4 = "k"; //No se puede, está inicializada ene l inicializador de instancia de arriba
	}
	
	
	
	
	{
		value += "a";
	}
	{
		value += "c";
	}

	public Order() {
		value += "b";
	}

	public Order(String s) {
		value += s;
	}

	public static void main(String[] args) {
		Order order = new Order("f"); //Aquí order vale tacf pero value es tac
		order = new Order(); //Aquí machacamos lo que valía order porun nuevo valor. value es tac y llama al constructor que añade una b a value, luego order es tacb
		System.out.println(order.value); //RES: tacb
	}
}

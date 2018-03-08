	Codigo:
	 
	String letra = "6";
	String prefijo = "Iteracion nro ";
	for (int i = 0; i < 10; i++) {
	    if (letra == String.valueOf(i)) {
	        System.out.println("El bucle continua");
	        break;
	    } else {
	        System.out.println(prefijo + i);
	    }
	}
	 
	 Respuesta:
	/* Compila, sí, es un progama Java válido.
	 * 
	 *  Resultado:
	 * Iteracion nro 0
		Iteracion nro 1
		Iteracion nro 2
		Iteracion nro 3
		Iteracion nro 4
		Iteracion nro 5
		Iteracion nro 6
		Iteracion nro 7
		Iteracion nro 8
		Iteracion nro 9
		
		En ninguno de los casos la condición se cumple porque 
		el operador "==" verifica si los objetos son iguales,
		es decir si ambos operandos referencian el mismo objeto.
		En este caso, los objetos son distintos, String.valueOf 
		devuelve un objeto distinto al referenciado en letra, 
		entonces la condición no se cumple. Si lo que queremos es,
		comparar los valores, deberíamos usar el método Objects.equals.
		De ser posible, en general, es preferible usar el metodo 
		Objects.equals en lugar de "==".
		  


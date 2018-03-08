package com.junior;

import java.io.IOException;
import java.util.List;

import com.junior.automoviles.Administrador;
import com.junior.automoviles.Automovil;


public class Junior {
		
	public static void main(String[] args) 	throws IOException{
		List<Automovil> list = Administrador.parseFile("src/com/junior/autos.txt");	
		Administrador admin = new Administrador(list);
		admin.iniciar();	
	}
}

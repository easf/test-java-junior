package com.junior.automoviles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Administrador {
	
	private List<Automovil> list = new ArrayList<Automovil>();
	
	private static String mensajeNumeroInvalido = "\nNúmero inválido, ingrese uno válido\n";
	private static String mensajeValorInvalido = "\nValor inválido, ingrese un valor adecuado\n";
	 
	public Administrador(List<Automovil> list){
		this.list = list;
	}
	
	/*
	 * Opciones primarias
	 * **/
	public void iniciar() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
        	System.out.print( "\nOpciones\n"
					+ "1- Listar autos, mostrando su marca, color, número de chasis y si es deportivo\n"
					+ "2- Seleccionar auto por medio de su número de chasis\n"
					+ "3- Finalizar programa\n"
					+ "Ingrese el número de la opción elegida: ");
			try{
	            int op = Integer.parseInt(br.readLine());
	            
	            if (op == 3){System.out.println("\nAdiós...\n"); break;}
	     
	            switch (op) {
				case 1:
					listarAutos();
					break;
				case 2:
					Automovil autoSeleccionado = seleccionarAuto();
					this.usarAutoSeleccionado(autoSeleccionado);
					break;
				default:
					System.err.println(mensajeNumeroInvalido);
					break;
				}
	            
	        }catch(NumberFormatException nfe){
	            System.err.println(mensajeValorInvalido);
	        }
		}	
	}
	
	/*
	 * Opcion primaria listar autos 
	 * **/
	private void listarAutos(){
		
		int n = 0;
		for (Automovil auto : this.list) {
			System.out.println(String.format(
					"auto %d -> marca: %s, color: %s, chasis: %s, deportivo: %s ",
					n, 
					auto.getMarca(), 
					auto.getColor(), 
					auto.getNumeroDeChasis(), 
					((auto instanceof Deportivo)? "sí" : "no" ))
			); 
			n++;
		}
		
	}
	
	/*
	 * Opcion primaria seleccionar auto por chasis 
	 * **/
	private Automovil seleccionarAuto() throws IOException{
		Automovil autoSel = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true){
			System.out.println("Ingrese número de chasis: ");	
			try{
				String ch = br.readLine().toUpperCase();
				int n = 0;
				for (Automovil auto : this.list) {
					if (auto.getNumeroDeChasis().equals(ch)){
						autoSel = auto;
						System.out.println(String.format(
								"auto %d elegido -> marca: %s, color: %s, chasis: %s, deportivo: %s ", 
								n,
								autoSel.getMarca(),
								autoSel.getColor(),
								autoSel.getNumeroDeChasis(),
								((autoSel instanceof Deportivo)? "sí" : "no" ))
						); 
					}
					n++;
				}
				
				if(autoSel.equals(null)){ 
					System.out.println("\nEl número de chasis es incorrecto, vuelva a intentarlo\n"); 
					continue;
				}
				else{
					break;
				}
			}catch (Exception e) {
				System.err.println("\nPor favor, vuelva a intentarlo\n");
			}
		}
		return autoSel;
	}

	
	/*
	 * Opcion secundaria conducir auto 
	 * **/
	private void usarAutoSeleccionado(Automovil auto) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Con el auto elegido usted puede:\n"
					+ "1- prenderlo\n"
					+ "2- acelerar\n"
					+ "3- frenar\n"
					+ "4- apagarlo\n"
					+ "5- dejarlo\n" 
					+ "Ingrese el número de la acción elegida: ");	
			try{
				int acc = Integer.parseInt(br.readLine());
				
				if (acc == 5){System.out.println("\nUsted ha dejado el auto\n");break;}
				
				switch (acc) {
				case 1:
					auto.prenderse();
					break;
				case 2:
					auto.acelerar();
					break;
				case 3:
					auto.frenar();
					break;
				case 4:
					auto.apagarse();
					break;
				default:
					System.err.println(mensajeNumeroInvalido);
					break;
				}
			}catch (NumberFormatException e) {
				System.err.println(mensajeValorInvalido);
			}
		}
	}

	
	/*
	 * Implementacion que permite la lectura del archivo de autos y la carga de los datos
	 * en una lista de objetos de tipo Automovil
	 * **/
	
	// enum de la cabecera del archivo
	private enum c { AUTO, COLOR, PUERTAS, RUEDAS, KM, CHASIS, MARCA, DEPOR, SEG } 
	
	public static List<Automovil> parseFile(String fileName) throws IOException{
		List<Automovil> list = new ArrayList<Automovil>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    br.readLine(); // ignorar cabecera del archivo
		    String line = br.readLine();
		    Deportivo dauto = null;
		    while (line != null) {
		    	String[] ls = line.split(","); 
		    	if (ls[c.DEPOR.ordinal()].equals("si")){
		    		dauto = new Deportivo( ls[c.COLOR.ordinal()], 
							   Byte.parseByte(ls[c.PUERTAS.ordinal()]), 
							   Byte.parseByte(ls[c.RUEDAS.ordinal()]), 
							   Integer.parseInt(ls[c.KM.ordinal()]),  
							   ls[c.CHASIS.ordinal()], ls[c.MARCA.ordinal()]);
		    		dauto.setSegundos0A100KmH(Byte.parseByte(ls[c.SEG.ordinal()]));
		    		list.add(dauto);
		    	}else{
		    		list.add(new Automovil( ls[c.COLOR.ordinal()], 
							   Byte.parseByte(ls[c.PUERTAS.ordinal()]), 
							   Byte.parseByte(ls[c.RUEDAS.ordinal()]), 
							   Integer.parseInt(ls[c.KM.ordinal()]),  
							   ls[c.CHASIS.ordinal()], ls[c.MARCA.ordinal()])
		    				);
		    	}
		        line = br.readLine();
		    }
		}catch (IOException e) {
			System.err.println(e);
		}
		return list;
	}

}


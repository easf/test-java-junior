package automoviles;

public class Deportivo extends Automovil {

	private byte segundosOA100KmH;
	
	public Deportivo(String color, byte puertas, byte ruedas,
					 int kilometraje, String numeroDeChasis, String marca) {
		
		super(color, puertas, ruedas, kilometraje, numeroDeChasis, marca);
	}
	
	/*
	 * Metodo reimplementado segun lo que pedia el ejercicio
	 * **/
	@Override
	public void acelerar(){
		if (this.isPrendido()) System.out.println(String.format("\nAcelerando... %d segundos le toma llegar de 0 a 100 Km/H\n", 
				this.getSegundos0A100KmH()));
		else System.out.println("\nPrimero debe encender el auto\n");

	}
	
	/*
	 * Getters and setters 
	 **/
	
	public byte getSegundos0A100KmH(){
		return this.segundosOA100KmH;
	}
	
	public void setSegundos0A100KmH(byte segundos0A100KmH){
		this.segundosOA100KmH = segundos0A100KmH;
	}
	
}

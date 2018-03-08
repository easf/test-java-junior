package automoviles;

public class Automovil {

	private String color;
	private byte puertas;
	private byte ruedas;
	private int kilometraje;
	private String numeroDeChasis;
	private String marca;
	private boolean prendido = false;

	public Automovil( String color, byte puertas, byte ruedas, 
					  int kilometraje, String numeroDeChasis, String marca) {
		
		this.color = color;
		this.puertas = puertas;
		this.ruedas = ruedas;
		this.kilometraje = kilometraje;
		this.numeroDeChasis = numeroDeChasis;
		this.marca = marca;
	}
	
	public void acelerar() {
		if (this.prendido) System.out.println("\nAcelerando...\n");
		else System.out.println("\nPrimero debe encender el auto\n");
	}
	
	public void frenar() {
		if (this.prendido) System.out.println("\nFrenando...\n");
		else System.out.println("\nPrimero debe encender el auto\n");
	}
	
	public void prenderse() {
		if (! this.prendido){
			System.out.println("\nPrendiendose... Prendido\n"); this.prendido = true;
		} else {
			System.out.println("\nEl auto ya estaba prendido\n");
		}
	}
	
	public void apagarse() {
		if (this.prendido){
			System.out.println("\nApagandose... Apagado\n"); this.prendido = false;
		}else{
			System.out.println("\nEl auto ya estaba apagado\n");
		}
		
	}
	
	/*
	 * Getters and setters 
	 **/
	
	public String getColor(){
		return this.color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public byte getPuertas(){
		return this.puertas;
	}
	
	public void setPuertas(byte puertas){
		this.puertas = puertas;
	}
	
	public byte getRuedas(){
		return this.ruedas;
	}
	
	public void setRuedas(byte ruedas){
		this.ruedas = ruedas;
	}
	
	public int getKilometraje(){
		return this.kilometraje;
	}
	
	public void setKilometraje(int kilometraje){
		this.kilometraje = kilometraje;
	}
	
	public String getNumeroDeChasis(){
		return this.numeroDeChasis;
	}
	
	public void setNumeroDeChasis(String numeroDeChasis){
		this.numeroDeChasis = numeroDeChasis;
	}
	
	public String getMarca(){
		return this.marca;
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public boolean isPrendido(){
		return this.prendido; 
	}	
}

package arbol;

import java.sql.Date;

public class Arbol {

	private int id;
	private String nombreComun;
	private String nombreCientifico;
	private int altura;
	private boolean singular;
	private String origen;
	private Habitad habitats;
	private String  fecha_encontrado;
	
	
	public Arbol(int id, String nombreComun, String nombreCientifico, int altura, boolean singular, String origen,
			Habitad habitats, String fecha_encontrado) {
		
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.altura = altura;
		this.singular = singular;
		this.origen = origen;
		this.habitats = habitats;
		this.fecha_encontrado = fecha_encontrado;
	}


	public Arbol() {
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreComun() {
		return nombreComun;
	}


	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}


	public String getNombreCientifico() {
		return nombreCientifico;
	}


	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public boolean isSingular() {
		return singular;
	}


	public void setSingular(boolean singular) {
		this.singular = singular;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public Habitad getHabitats() {
		return habitats;
	}


	public void setHabitats(Habitad habitats) {
		this.habitats = habitats;
	}


	public String getFecha_encontrado() {
		return fecha_encontrado;
	}


	public void setFecha_encontrado(String fecha_encontrado) {
		this.fecha_encontrado = fecha_encontrado;
	}


	@Override
	public String toString() {
		return "Arbol [id=" + id + ", nombreComun=" + nombreComun + ", nombreCientifico=" + nombreCientifico
				+ ", altura=" + altura + ", singular=" + singular + ", origen=" + origen + ", habitats=" + habitats
				+ ", fecha_encontrado=" + fecha_encontrado + "]";
	}
	
	
	
	
	

}

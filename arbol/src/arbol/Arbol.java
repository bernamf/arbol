package arbol;

public class Arbol {

	private int id;
	private String nombreComun;
	private String nombreCientifico;
	private String habitat;
	private boolean singular;
	private String origen;
	private Habitad habitats;
	
	
	
	
	public Arbol(int id, String nombreComun, String nombreCientifico, String habitat, boolean singular, String origen,
			Habitad habitats) {
		
		this.id = id;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.habitat = habitat;
		this.singular = singular;
		this.origen = origen;
		this.habitats = habitats;
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




	public String getHabitat() {
		return habitat;
	}




	public void setHabitat(String habitat) {
		this.habitat = habitat;
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




	@Override
	public String toString() {
		return "Arbol [id=" + id + ", nombreComun=" + nombreComun + ", nombreCientifico=" + nombreCientifico
				+ ", habitat=" + habitat + ", singular=" + singular + ", origen=" + origen + ", habitats=" + habitats
				+ "]";
	}

	
	

	
	
	
}

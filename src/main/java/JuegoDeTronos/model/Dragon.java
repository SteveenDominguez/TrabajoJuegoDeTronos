package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dragon") 
public class Dragon {
	@Id
	private int id;
	private String nombre;
	private String edad;
	private String fuerza;
	private String color;
	private String numAsesinatos;
	private String comidaFavorita;
	
	@JoinColumn(name = "id_Region", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Region region;
	
	
	public Dragon(int id, String nombre, String edad, String fuerza, String color, String numAsesinatos,
			String comidaFavorita, Region region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.fuerza = fuerza;
		this.color = color;
		this.numAsesinatos = numAsesinatos;
		this.comidaFavorita = comidaFavorita;
		this.region = region;
	}
	public Dragon() {
		super();
	}
	public int getRegion() {
		return region.getId();
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getFuerza() {
		return fuerza;
	}
	public void setFuerza(String fuerza) {
		this.fuerza = fuerza;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumAsesinatos() {
		return numAsesinatos;
	}
	public void setNumAsesinatos(String numAsesinatos) {
		this.numAsesinatos = numAsesinatos;
	}
	public String getComidaFavorita() {
		return comidaFavorita;
	}
	public void setComidaFavorita(String comidaFavorita) {
		this.comidaFavorita = comidaFavorita;
	}
	
	
	


}

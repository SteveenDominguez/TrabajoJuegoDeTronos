package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="guerrero") 
public class Guerrero {
	@Id
	private int id;
	private String nombre;
	private String especialidad;
	private String cargo;
	private String numAsesinatos;
	private String interes;
	
	@JoinColumn(name = "id_Region", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Region region;
	
	
	public Guerrero(int id, String nombre, String especialidad, String cargo, String numAsesinatos,
			String interes, Region region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.cargo = cargo;
		this.numAsesinatos = numAsesinatos;
		this.interes = interes;
		this.region = region;
	}
	public Guerrero() {
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialdiad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNumAsesinatos() {
		return numAsesinatos;
	}
	public void setNumAsesinatos(String numAsesinatos) {
		this.numAsesinatos = numAsesinatos;
	}
	public String getInteres() {
		return interes;
	}
	public void setInteres(String interes) {
		this.interes = interes;
	}
	
	
	


}

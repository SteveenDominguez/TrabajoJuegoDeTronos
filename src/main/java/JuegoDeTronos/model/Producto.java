package JuegoDeTronos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	private int ID;
	private String nombre;
	@JoinColumn(name = "ID_Region", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Region region;

	public int getId() {
		return ID;
	}

	public void setId(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRegion() {
		return region.getId();
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Producto(int iD, String nombre, Region region) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.region = region;
	}

	public Producto() {
		super();
	}
	
	
}

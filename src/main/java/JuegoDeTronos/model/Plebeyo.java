package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plebeyo")
public class Plebeyo {
	@Id
	private int ID;
	private String nombre;
	private String foto;
	
	public Plebeyo() {
		super();
	}
	
	public Plebeyo(int iD, String nombre, String foto) {
		super();
		this.ID = iD;
		this.nombre = nombre;
		this.foto = foto;
	}
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}

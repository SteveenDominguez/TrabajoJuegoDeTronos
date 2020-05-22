package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noble")
public class Noble {
	@Id
	private int ID;
	private String nombre;
	private String digno;
	
	public Noble(int id, String nombre, String digno) {
		super();
		this.ID=id;
		this.nombre=nombre;
		this.digno=digno;
	}
	
	public Noble() {
		super();
	}
	
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		ID = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDigno() {
		return digno;
	}
	public void setDigno(String digno) {
		this.digno = digno;
	}
	
}

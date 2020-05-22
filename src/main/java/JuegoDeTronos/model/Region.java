package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="region") 
public class Region {
	@Id
	private int ID;
	private String nombre;
	private String clima;
	private String mapa;
	
	public Region(int id, String nombre, String clima, String mapa) {
		this.ID=id;
		this.nombre=nombre;
		this.clima=clima;
		this.mapa=mapa;
	}
	
	public Region() {
		super();
	}
	
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getMapa() {
		return mapa;
	}
	public void setMapa(String mapa) {
		this.mapa = mapa;
	}


}

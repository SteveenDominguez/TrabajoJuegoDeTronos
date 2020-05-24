package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;



@Entity
@Table(name="subdito") 
public class Subdito {
	@Id
	private int id;
	private String nombre;
	private int numHijos;
	private String problema;
	
	@JoinColumn(name = "id_Padre", nullable = true )
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@Nullable
	private Subdito padre;
	
	@JoinColumn(name = "id_Region", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Region region;
	
	
	public Subdito(int id, String nombre, int numHijos, String problema, Subdito padre, Region region) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numHijos = numHijos;
		this.problema = problema;
		this.padre = padre;
		this.region = region;
	}
	
	public Subdito() {
		super();
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
	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public int getPadre() {
		return padre.getId();
	}

	public void setPadre(Subdito padre) {
		this.padre = padre;
	}

	public int getRegion() {
		return region.getId();
	}
	public void setRegion(Region region) {
		this.region = region;
	}

}

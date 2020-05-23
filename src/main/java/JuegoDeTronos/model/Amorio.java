package JuegoDeTronos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="amorio")
public class Amorio {
	@Id
	private int ID;
	@JoinColumn(name = "ID_Plebeyo", nullable = false)
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Plebeyo plebeyo;
	@JoinColumn(name = "ID_Noble", nullable = false)
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	private Noble noble;
	@JoinColumn(name = "ID_Region", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Region region;
	
	public int getId() {
		return ID;
	}
	public void setId(int iD) {
		ID = iD;
	}
	public int getPlebeyo() {
		return plebeyo.getId();
	}
	public void setPlebeyo(Plebeyo plebeyo) {
		this.plebeyo = plebeyo;
	}
	public int getNoble() {
		return noble.getId();
	}
	public void setNoble(Noble noble) {
		this.noble = noble;
	}
	public int getRegion() {
		return region.getId();
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public Amorio(int iD, Plebeyo plebeyo, Noble noble, Region region) {
		super();
		ID = iD;
		this.plebeyo = plebeyo;
		this.noble = noble;
		this.region = region;
	}
	
	public Amorio() {
		super();
	}
	
	
	
}

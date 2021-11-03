package at.ac.htlinn.jpa.bsp01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table( name = "wohnort")
@SecondaryTable( name = "stadt") 
@SecondaryTable( name = "land")

public class Wohnort {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	private String strasze;
	@Column( table = "stadt") 
	private String stadt; 
	@Column( table = "stadt") 
	private String bundesland; 
	@Column( table = "stadt") 
	private String plz; 
	@Column( table = "land") 
	private String land;
	
	
	// Generated via source -> generate ...
	public Wohnort() {
		super();
	}

	public String getStrasze() {
		return strasze;
	}

	public void setStrasze(String strasze) {
		this.strasze = strasze;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getBundesland() {
		return bundesland;
	}

	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	@Override
	public String toString() {
		return "Wohnort [strasze=" + strasze + ", stadt=" + stadt + ", bundesland=" + bundesland + ", plz=" + plz
				+ ", land=" + land + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bundesland == null) ? 0 : bundesland.hashCode());
		result = prime * result + ((land == null) ? 0 : land.hashCode());
		result = prime * result + ((plz == null) ? 0 : plz.hashCode());
		result = prime * result + ((stadt == null) ? 0 : stadt.hashCode());
		result = prime * result + ((strasze == null) ? 0 : strasze.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wohnort other = (Wohnort) obj;
		if (bundesland == null) {
			if (other.bundesland != null)
				return false;
		} else if (!bundesland.equals(other.bundesland))
			return false;
		if (land == null) {
			if (other.land != null)
				return false;
		} else if (!land.equals(other.land))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		if (stadt == null) {
			if (other.stadt != null)
				return false;
		} else if (!stadt.equals(other.stadt))
			return false;
		if (strasze == null) {
			if (other.strasze != null)
				return false;
		} else if (!strasze.equals(other.strasze))
			return false;
		return true;
	} 

	
}

package at.ac.htlinn.jpa.bsp01;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Skriptum {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String titel;  
	    
	@ManyToMany
	@JoinTable(name = "skript_autor",
	           joinColumns = { @JoinColumn(name = "fk_skript") },
	           inverseJoinColumns = { @JoinColumn(name = "fk_autor") })
	private List<Autor> autoren = new ArrayList<Autor>();
	 
	    

}

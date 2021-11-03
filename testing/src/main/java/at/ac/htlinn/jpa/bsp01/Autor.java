package at.ac.htlinn.jpa.bsp01;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private String vorname;
	private String nachname;  
	@ManyToMany(mappedBy="autoren")
	private List<Skriptum> skripts = new ArrayList<Skriptum>();

}
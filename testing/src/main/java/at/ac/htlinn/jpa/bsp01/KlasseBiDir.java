package at.ac.htlinn.jpa.bsp01;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity
public class KlasseBiDir {
	@Id
	@ GeneratedValue
	private Long id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="klasse")
	@JoinColumn(name = "klasse_fk")	
	List<SchuelerUniDir> schueler = new ArrayList<>();
	
}

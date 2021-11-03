package at.ac.htlinn.jpa.bsp01;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity


public class User {
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column ( nullable  = false)
	private String Username;
	
	@Column ( nullable  = false)
	private String email;
	
	@Column ( nullable  = false)
	private String passwort;
	
	@ManyToMany(mappedBy = "User")
	private List<Chat> chat  = new ArrayList<Chat>();
	
	
}
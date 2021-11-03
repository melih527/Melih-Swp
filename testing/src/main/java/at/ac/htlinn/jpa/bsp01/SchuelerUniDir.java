package at.ac.htlinn.jpa.bsp01;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class SchuelerUniDir {
	@Id
	@GeneratedValue
	private Long id;
	private String vorname;
	private String nachname;
}

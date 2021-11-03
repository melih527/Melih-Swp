package at.ac.htlinn.jpa.bsp01;

import java.io.Serializable;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor 
@EqualsAndHashCode
@ToString
@Data
@Embeddable 
public class SVN implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String number;
    String birthday;
    
}

 
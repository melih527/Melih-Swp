package at.ac.htlinn.jpa.bsp01;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Person {
	@EmbeddedId
	SVN svn;
	String firstName;
	String lastName;
	
	
	//Generiren:
	
	public Person() {						//@data
		super();
	}
	
	
	public SVN getSvn() {
		return svn;
	}
	public void setSvn(SVN svn) {
		this.svn = svn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

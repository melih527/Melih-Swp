package at.ac.htlinn.jpa.bsp01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(SVN.class)
public class Person2 {
	@Id
	String number;
	@Id
	String birthday;
	
	String firstName;
	String lastName;
	
	/*
	 * Unterschiede bei Abfrage JPQL: Embeddedid
	 *     select p.svn.number from Person p
	 * und
	 *     select p.number from Person p bei ClassId
	 *     
	 * testen. FK kommen später
	 */
}

package at.ac.htlinn.jpa.bsp02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/*
 * Columns + Basis Annotations
 * =============================
 @Target({ METHOD, FIELD}) 
 @Retention( RUNTIME) 
 public @interface Column { 
 String name() default ""; 
 boolean unique() default false; 
 boolean nullable() default true;
 boolean insertable() default true; 
 boolean updatable() default true; 
 String columnDefinition() default ""; 
 String table() default ""; 
 int length() default 255; 
 int precision() default 0; // decimal precision 
 int scale() default 0; // decimal scale 
 }
 
 @Target({ METHOD, FIELD}) 
 @Retention( RUNTIME) 
 public @interface Basic 
 { 
 FetchType fetch() default EAGER; 
 boolean optional() default true;
 }



Java to JDBC Date Type Mappings Java type JDBC type 
====================================================
java.time.Duration			BIGINT 
java.time.Instant 			TIMESTAMP 
java.time.LocalDateTime		TIMESTAMP 
java.time.LocalDate 		DATE 
java.time.LocalTime 		TIME 
java.time.OffsetDateTime 	TIMESTAMP 
java.time.OffsetTime 		TIME 
java.time.ZonedDateTime 	TIMESTAMP

bei "alten" Klassen:
----------------------------------------
@Temporal( TemporalType.DATE)
private Date dateOfBirth; 
@Temporal( TemporalType.TIMESTAMP) 
private Date creationDate;

Transiente Felder werden nicht gespeichert:
--------------------------------------------
@Transient 
private Integer age;
*/


@Entity
public class Student2 {

	// Default ID
	// NULLABLE, length, ...
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  private String email;
  @Column(length = 2000)
  private String bio;
  private LocalDate dateOfBirth;

  public Student2() {
  }

  public Student2(String firstName, String lastName, String email, String bio, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
  }


  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Student2 firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Student2 lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Student2 email(String email) {
    this.email = email;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Student2 bio(String bio) {
    this.bio = bio;
    return this;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Student2 dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Artist{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", bio='" + bio + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      '}';
  }
  
  
}

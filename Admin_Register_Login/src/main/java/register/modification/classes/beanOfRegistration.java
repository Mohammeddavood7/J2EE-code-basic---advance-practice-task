package register.modification.classes;

import java.io.Serializable;

public class beanOfRegistration implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
  private String pass;
  private String fname;
  private String lname;
  private String mail;
  private long phno;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
  
  

}

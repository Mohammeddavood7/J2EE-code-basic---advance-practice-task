package login.register.all.dml.operation;

import java.io.Serializable;

public class CustomerDetails implements Serializable 
{
	
	private static final long serialVersionUID = -777182301736581729L;
	private String name;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}

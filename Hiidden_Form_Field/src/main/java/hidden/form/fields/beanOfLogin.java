package hidden.form.fields;


import java.io.Serializable;

public class beanOfLogin implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;
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
	

}

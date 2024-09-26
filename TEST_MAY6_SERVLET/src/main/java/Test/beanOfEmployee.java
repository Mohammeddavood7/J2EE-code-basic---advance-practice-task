package Test;

public class beanOfEmployee
{
	private int id;
	private String name;
	private int  salary;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "beanOfEmployee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
	

}

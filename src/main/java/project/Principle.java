package project;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Principle 
{
	private int id;
	private String Pname;
	private int age;
	@Id
	private String Email;
	private String Passward;
	private double MoNO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassward() {
		return Passward;
	}
	public void setPassward(String passward) {
		Passward = passward;
	}
	public double getMoNO() {
		return MoNO;
	}
	public void setMoNO(double moNO) {
		MoNO = moNO;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Principle [id=" + id + ", Pname=" + Pname + ", age=" + age + ", Email=" + Email + ", Passward="
				+ Passward + ", MoNO=" + MoNO + "]";
	}

}

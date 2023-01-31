package project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	private int id;
	private String name;
	private String Semail;
	private double SMoNo;
	private double fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSemail() {
		return Semail;
	}
	public void setSemail(String semail) {
		Semail = semail;
	}
	public double getSMoNo() {
		return SMoNo;
	}
	public void setSMoNo(double sMoNo) {
		SMoNo = sMoNo;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", Semail=" + Semail + ", SMoNo=" + SMoNo + ", fees=" + fees
				+ "]";
	}
	
	

}

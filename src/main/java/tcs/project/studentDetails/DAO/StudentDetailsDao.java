package tcs.project.studentDetails.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdetails")
public class StudentDetailsDao {
	@Column(name="sname")
	private String sname;
	@Id
	@Column(name="sid")
	private Integer sid;
	@Column(name="saddress")
	private String saddress;

	public StudentDetailsDao(String sname, int sid, String address) {
		super();
		this.sname = sname;
		this.sid = sid;
		this.saddress = address;
	}
	
	public StudentDetailsDao() {}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String address) {
		this.saddress = address;
	}
	

}

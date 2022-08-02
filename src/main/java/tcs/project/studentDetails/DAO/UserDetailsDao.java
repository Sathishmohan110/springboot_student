package tcs.project.studentDetails.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logindetails")
public class UserDetailsDao {
	@Id
	@Column(name="lid")
	private Integer lid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	public UserDetailsDao(Integer lid, String username, String password) {
		super();
		this.lid = lid;
		this.username = username;
		this.password = password;
	}
	public UserDetailsDao() {}
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}

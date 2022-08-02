package ResponseApi;

import java.sql.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tcs.project.studentDetails.DAO.StudentDetailsDao;
import tcs.project.studentDetails.DAO.UserDetailsDao;

public class jwtchanger {
	private String secret="Chettikadu";
	
	public String generatejwt(UserDetailsDao d) {
		Date date=new Date(0);
		 
		Claims claim=Jwts.claims().setIssuer(d.getUsername()).setIssuedAt(date);
		String key=Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS256, secret).compact();
		return key;
		
		
	}

}

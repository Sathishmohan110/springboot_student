package Validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import customException.SdetailsValidationException;
import customException.Serror;
import tcs.project.studentDetails.DAO.StudentDetailsDao;
@Component
public class sdetailsValidation {
	 public boolean inputvalidation(StudentDetailsDao dao) {
		List<Serror> e=new ArrayList<>();
		if(dao.getSid()==0) {
			e.add(new Serror("The Id is zero"));
		}
		if(dao.getSaddress()==null) {
			e.add(new Serror("The address is empty"));
		}
		if(dao.getSname()==null) {
			e.add(new Serror("The username is empty"));
		}
		if( e.size()!=0) {
			throw new SdetailsValidationException("Error occured ,please verify",e);
		}
		return true;
	}

}

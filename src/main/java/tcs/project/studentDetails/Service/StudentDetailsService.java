package tcs.project.studentDetails.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ResponseApi.jwtchanger;
import ResponseApi.signupdto;
import Validation.sdetailsValidation;
import customException.UsernameAvailableException;
import tcs.project.studentDetails.DAO.StudentDetailsDao;
import tcs.project.studentDetails.DAO.UserDetailsDao;
import tcs.project.studentDetails.Repository.StudentDetailsRepository;
import tcs.project.studentDetails.Repository.UserDetailsRepository;

@Service
public class StudentDetailsService {
	@Autowired
	StudentDetailsRepository repo;
	@Autowired
	UserDetailsRepository rep;
	sdetailsValidation validation=new sdetailsValidation();
	private final Logger log =LoggerFactory.getLogger(StudentDetailsService.class);
 
	public boolean studentexsistTest(StudentDetailsDao dao) {
		log.info("Book exists service method called");
		return (repo.findById(dao.getSid()).isEmpty());
		
		
		
	}
	

	public String login(signupdto d2) {
		log.info("login  service method called");
		UserDetailsDao d=rep.findOneByUsername(d2.getUsername());
	
		if (!(d==null)) {
			if (d2.getPassword().equals(d.getPassword())){
			jwtchanger changer=new jwtchanger();
			log.info("login sucess and jwt token is returned");
			return changer.generatejwt(d);}
			
		}
		log.error("login failed and mismatch message returned ");
		return "password mismathch";
		
	}

	public List<StudentDetailsDao> getBySname(String name) {
		log.info("GET by student Name Service method is called ");
		
		return  repo.findAllBySname(name);
		
	}
	public ResponseEntity<String> addstudent(StudentDetailsDao dao) throws Exception {
		log.info("Add student details Service method called ");
		if(validation.inputvalidation(dao)) {
		if(this.studentexsistTest(dao)) {
			repo.save(dao);
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("hi your data had been added");
			}
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("your record already exists in the db");
		
	}
		log.error("The record is already available so, error message is throwned");
	throw new ArithmeticException();
	}
	

	public StudentDetailsDao getSdetails(int sid) {
		log.info("GET by the Student ID service method called");
	
		try {
			Optional<StudentDetailsDao> o=repo.findById(sid);
			
			log.info("The Student Details is successfully returned ");
			return o.get();}
			catch(Exception e) {
				log.error("The Id is not availabe , so error message is throwed");
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		
	}


	public ResponseEntity upadateSdetails(StudentDetailsDao dao) {
		log.info("Update student Details service method is called");
		 ResponseEntity response;
			if(this.studentexsistTest(dao)) {
			  
				repo.save(dao);
				String s="Data does not exists so new record created";
				HttpHeaders header=new HttpHeaders();
				header.add("response", s);
				log.info("The record is not available in the database , so it is created and stored in the database");
				 response=new ResponseEntity(s,header,HttpStatus.CREATED);
				return response;
			}
			else {
			 
				repo.save(dao);
				HttpHeaders header=new HttpHeaders();
				header.add("response", "The record updated in the database");
				response=new ResponseEntity("the record updated",header,HttpStatus.FOUND);
				log.info("The record is successfully updated in the database ");
				return response;
			}
	}


	public String deleteSdetails(int id) {
		try {
			log.info("Delete student details service method has been called by the controller delete method");
			StudentDetailsDao dao=repo.findById(id).get();
			repo.delete(dao);
			return "The record has been deleted successfully";
			}
			catch (Exception e) {
				return "The given id does not exists";
			}
	}


	public Object signup(UserDetailsDao d) throws Exception {
		log.info("Sign up Service   method is  called by controller Signup method");
		UserDetailsDao sample=rep.findOneByUsername(d.getUsername());
		if(sample==null) {
			log.info("The record is successfully created ");
			return rep.save(d);
		}
//		return "details already available";
		log.error("The record is already present so error has been throwned");
		throw new UsernameAvailableException("sorry... the username is already taken try  with new one");
} 
	}

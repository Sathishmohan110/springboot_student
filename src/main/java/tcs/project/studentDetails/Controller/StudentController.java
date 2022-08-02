package tcs.project.studentDetails.Controller;



import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import ResponseApi.ResponseApi;
import ResponseApi.signupdto;
import tcs.project.studentDetails.DAO.StudentDetailsDao;
import tcs.project.studentDetails.DAO.UserDetailsDao;
import tcs.project.studentDetails.Repository.StudentDetailsRepository;
import tcs.project.studentDetails.Repository.UserDetailsRepository;
import tcs.project.studentDetails.Service.StudentDetailsService;

@RestController
@RequestMapping("/student")
public class StudentController {
	private static final org.slf4j.Logger log=LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentDetailsRepository repo;
	@Autowired
	StudentDetailsService service;
	@Autowired		
	UserDetailsRepository rep;
	@PostMapping("/addstudent")
	public ResponseEntity<String> addStudentImplementation(@RequestBody StudentDetailsDao dao) throws Exception {
		log.info("Add student details Controller  method called");
		return service.addstudent(dao);
		
		
	}
	@GetMapping("/getsdetails/{sid}")
	public StudentDetailsDao getstudentDetailsImplementation( @PathVariable(value="sid") int sid) {
		log.info("Get student details Controller  method called");
		return service.getSdetails( sid);
		
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity updateSdetailsImplementation(@RequestBody StudentDetailsDao dao,@PathVariable(value="id" ) int id) {
		log.info("Update student details Controller  method called");
		dao.setSid(id);
		 return service.upadateSdetails(dao);  
		  
		
		
	}
	@PostMapping("/delete/sdetails/{id}")
	public String deteleSdetailsImplementation(@PathVariable(value="id") int id ) {
		log.info("Delete student details Controller  method called");
		return service.deleteSdetails(id);
		
	}
	@GetMapping("/getAllSdetails")
	public List<StudentDetailsDao> getAllSdetails() {
		log.info("GET all  student details Controller  method called");
		return repo.findAll();
	}
	@PostMapping ("/signup")
	public Object loginMethod(@RequestBody UserDetailsDao d) throws Exception {
		log.info("Sign up Controller  method called");
		return service.signup(d);
		
	}
	@PostMapping("/login")
	public String login(@RequestBody signupdto d) {
		
		return service.login(d);
	}
	@GetMapping("/getsname/{name}")
	public List<StudentDetailsDao> getbysname(@PathVariable(value="name") String name ) {
		log.info("Login  Controller  method called");
		return service.getBySname(name);
		
	}
	@GetMapping("/username")
	public UserDetailsDao getusername(@RequestBody UserDetailsDao d) {
		log.info("GET username Controller  method called");
	    return rep.findOneByUsername(d.getUsername());
	    }
	
}

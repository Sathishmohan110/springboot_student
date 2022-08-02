package tcs.project.studentDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ResponseApi.ResponseApi;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tcs.project.studentDetails.DAO.UserDetailsDao;
import tcs.project.studentDetails.Repository.UserDetailsRepository;

@RestController
@RequestMapping("/logi")
public class LoginController {
	@GetMapping("/help")
	public UserDetailsDao help(@RequestBody UserDetailsDao rep) {
		return rep;
	}
	
	
		
	}



package tcs.project.studentDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import Validation.sdetailsValidation;
import tcs.project.studentDetails.Controller.StudentController;
import tcs.project.studentDetails.DAO.StudentDetailsDao;
import tcs.project.studentDetails.Service.StudentDetailsService;

@SpringBootTest
class StudentDetailsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	StudentController con;
//	@MockBean
//	StudentDetailsService service;
	@MockBean
	sdetailsValidation validation;
	
	public StudentDetailsDao buildSdetails() {
		StudentDetailsDao d=new StudentDetailsDao("kanimozli",66,"old bustand,Erode");
		return d;
	}
	
@Test
public void addSdetailsTest() throws Exception {
	StudentDetailsDao dao=this.buildSdetails();
	when(validation.inputvalidation(dao)).thenReturn(true);
//	when(service.studentexsistTest(dao)).thenReturn(true);
	
	ResponseEntity<String> result=con.addStudentImplementation(dao);

	System.out.println(result.getStatusCodeValue());
	System.out.println(result.getBody());
    assertEquals(result.getBody(),"your record already exists in the db");
	assertEquals(result.getStatusCode().value(),208);
}
@Test
public void getSdetailsTest() {
	StudentDetailsDao dao=this.buildSdetails();
	StudentDetailsDao daoOutput=con.getstudentDetailsImplementation(dao.getSid());
	assertEquals(dao.getSid(), daoOutput.getSid());
}
}

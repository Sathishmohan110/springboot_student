package tcs.project.studentDetails.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tcs.project.studentDetails.DAO.StudentDetailsDao;

public interface StudentDetailsRepository extends JpaRepository<StudentDetailsDao, Integer> {

   List findAllBySname(String name);

}

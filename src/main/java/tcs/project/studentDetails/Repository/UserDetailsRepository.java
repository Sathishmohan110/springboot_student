package tcs.project.studentDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tcs.project.studentDetails.DAO.UserDetailsDao;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsDao, Integer> {

	UserDetailsDao findOneByUsername(String s);

}

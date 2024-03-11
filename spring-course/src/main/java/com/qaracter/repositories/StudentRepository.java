//package com.qaracter.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.qaracter.entities.StudentEntity;
//
//public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
//    // Custom query methods can be defined here
//	
//	@Query("SELECT s FROM Student s WHERE s.groupName = ?1")
//    List<StudentEntity> findByGroupName(String groupName);
//	
//	 @Query("SELECT s FROM Student s WHERE s.groupName = :groupName AND s.avgGrade >= :minAvgGrade")
//	 List<StudentEntity> findByGroupNameAndMinAvgGrade(@Param("groupName") String groupName, 
//	                                                @Param("minAvgGrade") Double minAvgGrade);
//}

package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import klu.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("select count(S) from Student S")
	public int totalRecords();
}

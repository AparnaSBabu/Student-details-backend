package com.admission.student.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.admission.student.request.Student;
import com.admission.student.utils.StudentUtils;

@Repository
public class StudentDALImpl implements StudentDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Long getCountofStudents() {
		Long count = mongoTemplate.count(null, Student.class);
		return count;
	}

	@Override
	public Student saveStudentDetails(Student student) {
		Long count = getCountofStudents();
		student.setRollno(StudentUtils.generateRollNo(count));
		mongoTemplate.save(student);
		return student;
	}

}

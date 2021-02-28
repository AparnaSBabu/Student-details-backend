package com.admission.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admission.student.dal.StudentDALImpl;
import com.admission.student.request.Student;

@Service
public class StudentDetailsService {
	
	@Autowired
	public StudentDALImpl userDAL;

	public Student saveDetails(Student student) {
		Student studentResponse=userDAL.saveStudentDetails(student);
		return studentResponse;
		
	}
}

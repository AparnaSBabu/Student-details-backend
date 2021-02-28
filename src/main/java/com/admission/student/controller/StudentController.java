package com.admission.student.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admission.student.request.Student;
import com.admission.student.service.StudentDetailsService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentDetailsService studentService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/savedetails")
	public ResponseEntity<?> saveStudentDetails(@RequestBody Student student) {
		LOG.info("Student details" + student.getDivision());
		Student studentSaved = null;
		ResponseEntity<?> responseEntity = null;
		try {
			studentSaved = studentService.saveDetails(student);
			if (studentSaved != null) {
				responseEntity = new ResponseEntity<>(studentSaved, HttpStatus.OK);
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		} catch (Exception ex) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return responseEntity;

	}

}
package com.admission.student.dal;

import com.admission.student.request.Student;

public interface StudentDAL {

	Student saveStudentDetails(Student student);

	Long getCountofStudents();

}
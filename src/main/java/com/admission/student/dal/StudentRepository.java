package com.admission.student.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admission.student.request.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}

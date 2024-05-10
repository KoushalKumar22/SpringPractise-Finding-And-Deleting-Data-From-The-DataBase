package com.SpringPractise.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    List<Student> findByName(String name);

    List<Student> findByRoll(int roll);
}

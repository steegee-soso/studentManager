package com.soso.studentmanager;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    boolean deleteByEmail(String email);
}

package com.in28minutes.springboot.lerarn_jpa_and_hibernate.course;

import com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//   private final CourseJdbcRepository repository;

   private final CourseJpaRepository repository;

   public CourseCommandLineRunner(CourseJpaRepository repository) {
      this.repository = repository;
   }

   @Override
   public void run(String... args) throws Exception {
      repository.insert(new Course(1, "Learn Jpa", "Ryu"));
      repository.insert(new Course(2, "Learn Azure", "Ryu"));
      repository.insert(new Course(3, "Learn Devops", "Ryu"));

      repository.deleteById(2);

      System.out.println(repository.findById(1));
   }
}

package com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.course.jpa;

import com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
   // Jpa를 활용하여 데이터베이스에 연결하려면 EntityManager필요
   @PersistenceContext
   private EntityManager entityManager;

   public void insert(Course course) {
      entityManager.merge(course);
   }

   public Course findById(long id) {
      return entityManager.find(Course.class, id);

   }

   public void deleteById(long id) {
      Course course = entityManager.find(Course.class, id);
      entityManager.remove(course);
   }


}

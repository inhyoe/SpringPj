package com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.lerarn_jpa_and_hibernate.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
   private final JdbcTemplate springJDBCTemplate;

   public CourseJdbcRepository(JdbcTemplate springJDBCTemplate) {
      this.springJDBCTemplate = springJDBCTemplate;
   }

   public static String INSERT_QUERY = "insert into course(id,name,author)" +
           " values(?,?,?);";
   public static String DELETE_QUERY = "delete from course where id = ?";

   public static String SELECT_QUERY = "select * from course where id = ?";


   public void insert(Course course) {
      springJDBCTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
   }

   public void deleteById(long id) {
      springJDBCTemplate.update(DELETE_QUERY, id);
   }

   // BeanPropertyRowMapper 을 사용할 때는
   // Bean Property를 기반으로 RowMapper을 생성함
   // RowMapper란 Bean Property를 객체로 객체로 반환해주는 매서드
   public Course findById(long id) {
      return springJDBCTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
   }
}

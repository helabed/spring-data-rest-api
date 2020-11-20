package com.rubywebworks.springdata.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCourses() {
    List<Course> courses = new ArrayList<>();
    courseRepository.findAll().forEach(courses::add);
    return courses;
  }

  public List<Course> getAllCoursesByTopicId(String topicId) {
    log("topicId: "+ topicId);
    List<Course> courses = new ArrayList<>();
    courseRepository.findByTopicId(topicId).forEach(courses::add);
    log("courses: "+ courses);
    return courses;
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public Optional<Course> getCourse(String id) {
    return courseRepository.findById(id);
  }

  public void updateCourse(String id, Course course) {
    courseRepository.save(course);
  }

  public void deleteCourse(String id) {
    courseRepository.deleteById(id);
  }

  public void log(String message) {
    System.out.println(message);
  }
}
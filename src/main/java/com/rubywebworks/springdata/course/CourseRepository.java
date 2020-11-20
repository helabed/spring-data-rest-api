package com.rubywebworks.springdata.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
  // only implements what is not implemented by default
  // this is our goal, let's work towards it step by step.
  //public List<Course> getCoursesByTopicId(String topicId);
  // start with a simpler example of what we want
  //public List<Course> getCoursesByName(String name);
  // If we abide by the spring-data naming conventions, then get implementations for free.
  // Below are dynamic finder methods that can be provided auto-magically by spring-data
  // similar to the Rails Active Record Finders.
  public List<Course> findByName(String name);                // because 'name' is a property of Course
  public List<Course> findByDescription(String description);  // because 'description' is a property of Course
    // we need to find courses by the topic object's id. So:
  public List<Course> findByTopicId(String topicId);
}

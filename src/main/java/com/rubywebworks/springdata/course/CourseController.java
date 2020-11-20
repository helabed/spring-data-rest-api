package com.rubywebworks.springdata.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

  @Autowired   // marks this instance as needing to be dependency injected into this class.
  private CourseService courseService;

  @RequestMapping("/courses") // mapping /courses web url to this method getAllTopics(), defaults to GET method.
                             // Spring MVC auto magically converts the List<Course> into JSON and returns it to the
                             // caller, in this case the web browser.
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }

  @RequestMapping("/courses/{courseId}")
  public Optional<Course> getCourse(@PathVariable("courseId") String id) {
    return courseService.getCourse(id);
  }

  // Example of a curl command to produce a POST
  // curl -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":\"ruby\",\"name\":\"Ruby on Rails\",\"description\":\"Introduction to Rails\"}" \
  //   http://localhost:8080/courses
  @RequestMapping(method=RequestMethod.POST, value="/courses")
  public void addCourse(@RequestBody Course course) {
    courseService.addCourse(course);
  }

  // Example of a curl command to produce a PUT
  // curl -X PUT -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":\"ruby\",\"name\":\"Ruby on Rails\",\"description\":\"Introduction to Ruby on Rails\"}" \
  //   http://localhost:8080/courses/rub
  @RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
  public void updateCourse(@RequestBody Course course, @PathVariable String id) {
    courseService.updateCourse(id, course);
  }

  // Example of a curl command to produce a DELETE
  // curl -X DELETE -H "Accept: text/json" -H "Content-type: application/json" http://localhost:8080/courses/ruby
  @RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
  public void deleteTopic(@PathVariable String id) {
    courseService.deleteTopic(id);
  }
}

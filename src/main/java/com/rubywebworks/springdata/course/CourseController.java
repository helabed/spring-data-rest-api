package com.rubywebworks.springdata.course;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rubywebworks.springdata.topic.Topic;
import com.rubywebworks.springdata.topic.TopicService;

@RestController
public class CourseController {

  @Autowired   // marks this instance as needing to be dependency injected into this class.
  private CourseService courseService;

  @Autowired   // marks this instance as needing to be dependency injected into this class.
  private TopicService topicService;

  @RequestMapping("/courses")
  // mapping /courses web url to this method getAllTopics(), defaults to GET method.
  // Spring MVC auto magically converts the List<Course> into JSON and returns it to the
  // caller, in this case the web browser.
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }
  @RequestMapping("/topics/{topicId}/courses")
  public List<Course> getAllCoursesByTopicId(@PathVariable("topicId") String topicId) {
    return courseService.getAllCoursesByTopicId(topicId);
  }

  @RequestMapping("/courses/{courseId}")
  public Optional<Course> getCourse(@PathVariable("courseId") String id) {
    return courseService.getCourse(id);
  }

  @RequestMapping("/topics/{topicId}/courses/{id}")
  public Optional<Course> getCourseByTopicId(@PathVariable("id") String id) {
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

  @RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
  public void addCourseByTopicId(@RequestBody Course course, @PathVariable("topicId") String topicId) {
    if (topicId != null) {
      Optional<Topic> result = topicService.getTopic(topicId);
      if( result.isPresent() ) {
        course.setTopic(result.get());
      }
    }
    courseService.addCourse(course);
  }

  // Example of a curl command to produce a PUT
  // curl -X PUT -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":\"ruby\",\"name\":\"Ruby on Rails\",\"description\":\"Introduction to Ruby on Rails\"}" \
  //   http://localhost:8080/courses/ruby
  @RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
  public void updateCourse(@RequestBody Course course, @PathVariable String id) {
    courseService.updateCourse(id, course);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
  public void updateCourseByTopicId(@RequestBody Course course, @PathVariable String id, @PathVariable("topicId") String topicId) {
    if (topicId != null) {
      Optional<Topic> result = topicService.getTopic(topicId);
      if( result.isPresent() ) {
        course.setTopic(result.get());
      }
    }
    courseService.updateCourse(id, course);
  }

  // Example of a curl command to produce a DELETE
  // curl -X DELETE -H "Accept: text/json" -H "Content-type: application/json" http://localhost:8080/courses/ruby
  @RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
  public void deleteCourse(@PathVariable String id) {
    courseService.deleteCourse(id);
  }

  // Example of a curl command to produce a DELETE
  // curl -X DELETE -H "Accept: text/json" -H "Content-type: application/json" http://localhost:8080/topics/ruby/courses/ruby_course2
  @RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
  public void deleteCourse(@PathVariable String id, @PathVariable("topicId") String topicId) {
    courseService.deleteCourse(id);
  }
}

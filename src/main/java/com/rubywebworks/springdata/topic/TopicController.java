package com.rubywebworks.springdata.topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

  @Autowired   // marks this instance as needing to be dependency injected into this class.
  private TopicService topicService;

  @RequestMapping("/topics") // mapping /topics web url to this method getAllTopics(), defaults to GET method.
                             // Spring MVC auto magically converts the List<Topic> into JSON and returns it to the
                             // caller, in this case the web browser.
  public List<Topic> getAllTopics() {
    return topicService.getAllTopics();
  }

  @RequestMapping("/topics/{topicId}")
  public Topic getTopic(@PathVariable("topicId") String id) {
    return topicService.getTopic(id);
  }

  // Example of a curl command to produce a POST
  // curl -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":\"ruby\",\"name\":\"Ruby on Rails\",\"description\":\"Introduction to Rails\"}" \
  //   http://localhost:8080/topics
  @RequestMapping(method=RequestMethod.POST, value="/topics")
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  // Example of a curl command to produce a PUT
  // curl -X PUT -H "Accept: text/json" -H "Content-type: application/json" -d \
  //   "{\"id\":\"ruby\",\"name\":\"Ruby on Rails\",\"description\":\"Introduction to Ruby on Rails\"}" \
  //   http://localhost:8080/topics/rub
  @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
  public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
    topicService.updateTopic(id, topic);
  }

  // Example of a curl command to produce a DELETE
  // curl -X DELETE -H "Accept: text/json" -H "Content-type: application/json" http://localhost:8080/topics/ruby
  @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}

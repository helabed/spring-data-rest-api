package com.rubywebworks.springdata.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

  private List<Topic> topics = new ArrayList<>(Arrays.asList(
      new Topic("spring", "Spring Framework", "Introduction to the Spring Framework"),
      new Topic("java", "Core Java", "Introduction to Core Java"),
      new Topic("javascript", "Javascript Programming", "Introduction to JavaScript Programming")
    ));

  public List<Topic> getAllTopics() {
    return topics;
  }

  public Topic getTopic(String id) {
    return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
  }

  public void addTopic(Topic topic) {
    topics.add(topic);
  }

  public void updateTopic(String id, Topic topic) {
    for( int i = 0; i < topics.size(); i++) {
      Topic t = topics.get(i);
      if (t.getId().equals(id)) {
        topics.set(i, topic);
        return;
      }
    }
  }

  public void deleteTopic(String id) {
    topics.removeIf(t -> t.getId().equals(id));
  }
}
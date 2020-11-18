package com.rubywebworks.springdata.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
  // only implements what is special
}
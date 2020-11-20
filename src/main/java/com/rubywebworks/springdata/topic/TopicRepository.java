package com.rubywebworks.springdata.topic;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
  // only implements what is special
  public Optional<Topic> findById(String id);
}
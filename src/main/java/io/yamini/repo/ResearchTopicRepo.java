package io.yamini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.yamini.Model.ResearchTopic;

public interface ResearchTopicRepo  extends JpaRepository<ResearchTopic, Long >  {

}

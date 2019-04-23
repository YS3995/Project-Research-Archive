package io.yamini.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import io.yamini.Model.ProjectTopic;

public interface ProjectTopicRepo  extends JpaRepository<ProjectTopic, Long > {

}

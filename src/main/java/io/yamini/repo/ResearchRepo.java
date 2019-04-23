package io.yamini.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import io.yamini.Model.Research;

public interface ResearchRepo extends JpaRepository<Research, Long > {

}

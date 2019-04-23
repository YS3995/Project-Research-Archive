package io.yamini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.yamini.Model.User;


public interface UserRepo extends JpaRepository<User, String > {

}

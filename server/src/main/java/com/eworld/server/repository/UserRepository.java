package com.eworld.server.repository;

//import com.eworld.server.User;
//import com.eworld.server.entity.UserAccountEntity;

import com.eworld.server.entity.UserAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccountEntity, Integer> {
    UserAccountEntity getUserAccountEntityByUsername(String username);
}



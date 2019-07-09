package com.eworld.server.repository;

import com.eworld.server.entity.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserAccountEntity, Integer> {
    UserAccountEntity getUserAccountEntityByUsername(String username);
}



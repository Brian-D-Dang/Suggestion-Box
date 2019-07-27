package com.eworld.server.user;

import com.eworld.server.user.UserAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserAccountEntity, Integer> {
    UserAccountEntity getUserAccountEntityByUsername(String username);
    List<UserAccountEntity> findUserAccountEntityByUsernameOrEmail(String username, String Email);
}



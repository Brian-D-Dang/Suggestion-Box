package com.eworld.server.repository;

import com.eworld.server.entity.PasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<PasswordEntity, Integer> {
    PasswordEntity getPasswordEntityByUserAccountId(int userAccountId);
}

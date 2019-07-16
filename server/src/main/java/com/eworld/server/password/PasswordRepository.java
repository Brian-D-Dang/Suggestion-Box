package com.eworld.server.password;

import com.eworld.server.password.PasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<PasswordEntity, Integer> {
    PasswordEntity getPasswordEntityByUserAccountId(int userAccountId);
}

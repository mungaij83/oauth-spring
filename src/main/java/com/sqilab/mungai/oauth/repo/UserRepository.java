package com.sqilab.mungai.oauth.repo;

import com.sqilab.mungai.oauth.models.CustomUser;
import com.sqilab.mungai.oauth.services.UserDetailService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by mungai on 17/07/2017.
 */
public interface UserRepository extends CrudRepository<CustomUser,Long>{
    Optional<CustomUser> findByUsername(String username);
}

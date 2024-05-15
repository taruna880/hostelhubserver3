package com.usermanagement.repository;

import com.usermanagement.modelentity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(String roleName);

 //  Optional<Role> deleteByUserId(Long userId);



}

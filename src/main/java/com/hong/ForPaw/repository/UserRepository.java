package com.hong.ForPaw.repository;

import com.hong.ForPaw.domain.User.Role;
import com.hong.ForPaw.domain.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<Role> findRoleById(Long id);
}

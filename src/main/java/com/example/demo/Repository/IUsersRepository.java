package com.example.demo.Repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUsersRepository extends JpaRepository<User,Long>
{
    void deleteById(Long id);
    Optional<User> findByCode(String code);
    Optional<User> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByPersonalemail(String personalemail);
    Boolean existsByCode(String code);
}

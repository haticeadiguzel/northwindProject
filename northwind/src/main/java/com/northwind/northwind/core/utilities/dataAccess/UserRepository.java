package com.northwind.northwind.core.utilities.dataAccess;

import com.northwind.northwind.core.utilities.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getByEmail(String email);
}

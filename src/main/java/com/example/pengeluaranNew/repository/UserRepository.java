package com.example.pengeluaranNew.repository;

import java.util.List;
import com.example.pengeluaranNew.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> 
{
    User findByUuid(String uuid);
    User findByName(String name);
    User findByAddress(String address);
    User findByEmail(String email);
    User findByPhone(String phone);

         
}

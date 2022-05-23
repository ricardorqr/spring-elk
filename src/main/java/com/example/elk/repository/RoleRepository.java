package com.example.elk.repository;

import com.example.elk.model.Role;
import com.example.elk.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleEnum name);


}

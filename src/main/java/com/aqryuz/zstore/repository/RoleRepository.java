package com.aqryuz.zstore.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aqryuz.zstore.entity.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findRoleByName(String name);
}

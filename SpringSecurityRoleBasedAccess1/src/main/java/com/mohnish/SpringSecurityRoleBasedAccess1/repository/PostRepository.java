package com.mohnish.SpringSecurityRoleBasedAccess1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohnish.SpringSecurityRoleBasedAccess1.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}

package com.msr.blog.MasUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasUserRepository extends JpaRepository<MasUser, Integer> {
    MasUser findByUsername(String username);
}

package com.devrezaur.main.repository;

import com.devrezaur.main.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepo extends JpaRepository<Admin, Integer> {
    // Custom query method to find Admin by email/username (admin address)
    Admin findByAdminAddress(String adminAddress);
}

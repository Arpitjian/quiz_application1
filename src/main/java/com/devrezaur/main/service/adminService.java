package com.devrezaur.main.service;

import com.devrezaur.main.model.Admin;
import com.devrezaur.main.repository.adminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService {

    @Autowired
    private adminRepo adminRepo;

    // Save a new admin to the database
    public void saveAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    // Find admin by email/username
    public Admin findAdminByAddress(String adminAddress) {
        return adminRepo.findByAdminAddress(adminAddress);
    }
    public Admin authenticateAdmin(String adminAddress, String adminPassword) {
        Admin admin = adminRepo.findByAdminAddress(adminAddress);

        if (admin != null && admin.getAdminPassword().equals(adminPassword)) {
            return admin; // Authentication successful
        }
        return null; // Authentication failed
    }
}

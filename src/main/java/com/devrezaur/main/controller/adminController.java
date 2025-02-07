package com.devrezaur.main.controller;

import com.devrezaur.main.model.Admin;
import com.devrezaur.main.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminController {

    @Autowired
    private adminService adminService;

    // Show the registration page
    @GetMapping("/registerAdmin")
    public String showAdminRegistrationPage() {
        return "registerAdmin.html";  // This returns the registerAdmin.html page
    }

    // Handle the form submission for admin registration
    @PostMapping("/registerAdmin")
    public String registerAdmin(@RequestParam String adminAddress,
                                @RequestParam String adminPassword,
                                @RequestParam String confirmPassword,
                                Model model) {

        // Check if passwords match
        if (!adminPassword.equals(confirmPassword)) {
            model.addAttribute("errorMessage", "Passwords do not match!");
            return "registerAdmin";  // Return to registration page with error message
        }

        // Check if admin address already exists
        Admin existingAdmin = adminService.findAdminByAddress(adminAddress);
        if (existingAdmin != null) {
            model.addAttribute("errorMessage", "Admin address already exists!");
            return "registerAdmin";  // Return to registration page with error message
        }

        // Save the new admin to the database
        Admin newAdmin = new Admin();
        newAdmin.setAdminAddress(adminAddress);
        newAdmin.setAdminPassword(adminPassword);

        adminService.saveAdmin(newAdmin);

        model.addAttribute("successMessage", "Admin registered successfully!");
        return "redirect:/adminLogin";  // Redirect to login page after successful registration
    }
    @PostMapping("/adminLogin")
    public String loginAdmin(@RequestParam("adminAddress") String adminAddress,
                             @RequestParam("adminPassword") String adminPassword,
                             Model model) {

        Admin admin = adminService.authenticateAdmin(adminAddress, adminPassword);

        if (admin != null) {
            // If authentication is successful, redirect to the dashboard or admin page
            model.addAttribute("message", "Welcome " + admin.getAdminAddress());
            return "createTestPage.html"; // Redirect to the admin dashboard or homepage
        } else {
            // If authentication fails, show an error message
            model.addAttribute("errorMessage", "Invalid username or password!");
            return "adminLogin.html"; // Return to login page
        }
    }
}

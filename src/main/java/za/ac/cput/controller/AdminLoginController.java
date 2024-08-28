package za.ac.cput.controller;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.Customer;
import za.ac.cput.services.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/adminlogin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    // Create a new AdminLogin
    @PostMapping("/create")
    public AdminLogin create(@RequestBody AdminLogin adminLogin){
        return adminLoginService.create(adminLogin);
    }


    @GetMapping("/read/{adminId}")
    public AdminLogin read(@PathVariable Long adminId){
        return adminLoginService.read(adminId);
    }

    @PostMapping("/update")
    public AdminLogin update(@RequestBody AdminLogin adminLogin){
        return adminLoginService.update(adminLogin);
    }
}

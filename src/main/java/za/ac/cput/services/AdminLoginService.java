package za.ac.cput.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.repository.AdminLoginRepository;

import java.util.List;

@Service
public class AdminLoginService {
    private AdminLoginRepository repo;
    @Autowired
    AdminLoginService(AdminLoginRepository repository){
        this.repo = repository;
    }

    public List<AdminLogin> getall() {
        return repo.findAll();
    }

    public AdminLogin create(AdminLogin adminLogin) {
        return repo.save(adminLogin);
    }

    public AdminLogin read(Long aLong) {
        return repo.findById(aLong).orElse(null);
    }

    public AdminLogin update(AdminLogin adminLogin) {
        return repo.save(adminLogin);
    }

}


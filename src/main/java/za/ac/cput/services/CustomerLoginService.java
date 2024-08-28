package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.repository.CustomerLoginRepository;

import java.util.List;

@Service
public class CustomerLoginService {
    private CustomerLoginRepository customerLoginRepository;
    @Autowired
    CustomerLoginService(CustomerLoginRepository repository){
        this.customerLoginRepository = repository;
    }
    public CustomerLogin create(CustomerLogin customerLogin) {
        return customerLoginRepository.save(customerLogin);
    }
    public CustomerLogin read(Long aLong) {
        return customerLoginRepository.findById(aLong).orElse(null);
    }

    public List<CustomerLogin> getall() {
        return customerLoginRepository.findAll();
    }


    public CustomerLogin deleteCustomerLogin(Long id) {
        customerLoginRepository.deleteById(id);
        return null;
    }
    public CustomerLogin update(CustomerLogin customerLogin) {
        return customerLoginRepository.save(customerLogin);
    }

}


package za.ac.cput.controller;

import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.services.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customerlogin")
public class CustomerLoginController {

    @Autowired
    private CustomerLoginService customerLoginService;

    @PostMapping("/create")
    public CustomerLogin create(@RequestBody CustomerLogin customerLogin) {
        return customerLoginService.create(customerLogin);
    }

    @GetMapping("/read/{customerId}")
    public CustomerLogin read(@PathVariable Long customerId){
        return customerLoginService.read(customerId);
    }

//    @DeleteMapping("/{id}")
//    public void deleteCustomerLogin(@PathVariable Long id) {
//        customerLoginService.deleteCustomerLogin(id);
//    }
    @PostMapping("/update")
    public CustomerLogin update(@RequestBody CustomerLogin customerLogin){
        return customerLoginService.update(customerLogin);
    }
}

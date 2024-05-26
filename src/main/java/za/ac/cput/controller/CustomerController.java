package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable Long customerId){
        return customerService.read(customerId);
    }

    @GetMapping("/readall")
    public List<Customer> readall(){
        return customerService.getall();
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return customerService.update(customer);
    }
}

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

    @GetMapping("/read/{addressId}")
    public Address read(@PathVariable Long addressId){
        return addressService.read(addressId);
    }

    @GetMapping("/getall")
    public List<Address> getall(){
        return addressService.getall();
    }

    @PostMapping("/update")
    public Address update(@RequestBody Address address){
        return addressService.update(address);
    }
}

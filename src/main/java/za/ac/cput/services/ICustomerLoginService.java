package za.ac.cput.services;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerLogin;

import java.util.List;

public interface ICustomerLoginService extends IService<CustomerLogin, Long>{
    List<CustomerLogin> getall();
}

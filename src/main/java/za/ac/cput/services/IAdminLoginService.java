package za.ac.cput.services;

import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerLogin;

import java.util.List;

public interface IAdminLoginService extends IService<CustomerLogin,Long>{
    List<AdminLogin> getall();
}

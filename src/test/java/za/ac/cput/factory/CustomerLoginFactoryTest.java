package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.CustomerLogin;

import static org.junit.jupiter.api.Assertions.*;

class CustomerLoginFactoryTest {

    @Test
    void createCustomerLogin() {
        CustomerLogin customerLogin = CustomerLoginFactory.createCustomerLogin(101L, "FredKrug@outlook.com","Freddy121","Fredrick Krugerand");
        assertNotNull(customerLogin);
        System.out.println(customerLogin);
    }
}
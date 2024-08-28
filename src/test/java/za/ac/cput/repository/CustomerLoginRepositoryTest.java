package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.factory.AdminLoginFactory;
import za.ac.cput.factory.CustomerLoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerLoginRepositoryTest {
    private CustomerLogin customerLogin;
    @Autowired
    private CustomerLoginRepository repository;
    @BeforeEach
    void setUp() {
        customerLogin =  CustomerLoginFactory.createCustomerLogin(1991L,"danielgen@gmail.com","dangen12345","Daniel Genevieve");
        assertNotNull(customerLogin);
        repository.save(customerLogin);

    }
    @Test
    void findByCustomerId() {
        customerLogin = repository.findByCustomerId(1991L);
        System.out.println("Found: " + customerLogin);
    }
}
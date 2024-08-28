package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.factory.AdminLoginFactory;
import za.ac.cput.factory.CustomerLoginFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerLoginServiceTest {

    @Autowired
    private CustomerLoginService service;
    CustomerLogin customerLogin;
    CustomerLogin customerLogin2;
    @BeforeEach
    void setUp() {
        customerLogin = CustomerLoginFactory.createCustomerLogin(82743L,"walterzo@gmail.com","waltzolo1212","Walter Jakobs");
        customerLogin2 = CustomerLoginFactory.createCustomerLogin(1111L,"DeleteTest@gmail.com","DeleteTest","delete Test");

    }

    @Test
    @Order(1)
    void createCustomerLogin() {
        CustomerLogin add1 = service.create(customerLogin);
        assertNotNull(add1);
        System.out.println("First Added : " +  add1);
        CustomerLogin add2 = service.create(customerLogin2);
        assertNotNull(add2);
        System.out.println("Second Added : " +  add2);
    }

    @Test
    @Order(2)
    void getCustomerLoginById() {
        CustomerLogin read = service.read(customerLogin.getCustomerId());
        assertNotNull(read);
        System.out.println(read);
        CustomerLogin read2 = service.read(customerLogin2.getCustomerId());
        assertNotNull(read2);
        System.out.println(read2);
    }

//    @Test
//    @Order(3)
//    void deleteCustomerLogin() {
//        CustomerLogin delete = service.deleteCustomerLogin(1111L);
//        System.out.println("Deleted : " + delete);
//
//    }
    @Test
    @Order(3)
    void getall() {
        System.out.println(service.getall());
    }
}
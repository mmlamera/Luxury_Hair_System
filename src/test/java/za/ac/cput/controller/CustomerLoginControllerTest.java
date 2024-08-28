package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.factory.CustomerLoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerLoginControllerTest {
    @Autowired
    private TestRestTemplate trt;
    private String Base_Url = "http://localhost:8080/LuxuryHairVendingSystemDB/customerlogin";
    private static CustomerLogin customerLogin;
    private static CustomerLogin customerLogin2;

    @BeforeEach
    void setUp() {
        customerLogin = CustomerLoginFactory.createCustomerLogin(1004L,"mikejones@gmail.com","242123mjj","Mikael Jones");
        customerLogin2 = CustomerLoginFactory.createCustomerLogin(1005L,"phillip121@gmail.com","6543ds","Phillip Lewis");

    }

    @Test
    @Order(1)
    void create() {
        String url = Base_Url + "/create";
        ResponseEntity<CustomerLogin> postResp = trt.postForEntity(url, customerLogin, CustomerLogin.class);
        assertNotNull(postResp);
        assertNotNull(postResp.getBody());
        CustomerLogin addSaved = postResp.getBody();
        assertEquals(customerLogin.getCustomerId(), addSaved.getCustomerId());
        System.out.println("Saved data: " + addSaved);

        String url2 = Base_Url + "/create";
        ResponseEntity<CustomerLogin> postResp2 = trt.postForEntity(url2, customerLogin2, CustomerLogin.class);
        assertNotNull(postResp2);
        assertNotNull(postResp2.getBody());
        CustomerLogin addSaved2 = postResp2.getBody();
        assertEquals(customerLogin2.getCustomerId(), addSaved2.getCustomerId());
        System.out.println("Saved data: " + addSaved2);

    }

    @Test
    @Order(2)
    void read() {
        String url = Base_Url + "/read/" + customerLogin.getCustomerId();
        System.out.println("URL: " + url);
        ResponseEntity<CustomerLogin> response = trt.getForEntity(url, CustomerLogin.class);
        assertEquals(customerLogin.getCustomerId(), response.getBody().getCustomerId());
        System.out.println("Read: " + response.getBody());

        String url2 = Base_Url + "/read/" + customerLogin2.getCustomerId();
        System.out.println("URL: " + url2);
        ResponseEntity<CustomerLogin> response2 = trt.getForEntity(url2, CustomerLogin.class);
        assertEquals(customerLogin2.getCustomerId(), response2.getBody().getCustomerId());
        System.out.println("Read: " + response2.getBody());
    }

//    @Test
//    void deleteCustomerLogin() {
//
//    }

    @Test
    @Order(3)
    void update() {
        String url = Base_Url + "/update";
        CustomerLogin newCustomerLogin = new CustomerLogin.Builder().copy(customerLogin).setEmail("mikejones11@email.com").build();
        ResponseEntity<CustomerLogin> postResponse = trt.postForEntity(url,newCustomerLogin, CustomerLogin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CustomerLogin customerloginUpdated = postResponse.getBody();
        assertEquals(newCustomerLogin.getEmail(), customerloginUpdated.getEmail());
        System.out.println("Updated Values: " + customerloginUpdated);
    }
}
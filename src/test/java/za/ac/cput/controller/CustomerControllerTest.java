package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerControllerTest {
    @Autowired
    private TestRestTemplate trt;
    private String Base_Url = "http://localhost:8080/LuxuryHairVendingSystemDB/customer";
    private static Customer customer;
    @BeforeEach
    void setUp() {
        customer = CustomerFactory.buildCust(121212L,"Jakob","Coffe","jcofffie@gmail.com","0878769534");
    }

    @Test
    @Order(1)
    void create() {
       String url = Base_Url + "/create";
       ResponseEntity<Customer> post = trt.postForEntity(url,customer, Customer.class);
       assertNotNull(post);
       assertNotNull(post.getBody());
       Customer newCustAdded = post.getBody();
       assertEquals(customer.getCustomerId(),newCustAdded.getCustomerId());
        System.out.println(newCustAdded);
    }

    @Test
    @Order(2)
    void read() {
        String url = Base_Url + "/read/" +customer.getCustomerId();
        ResponseEntity<Customer> response  = trt.getForEntity(url,Customer.class);
        assertEquals(customer.getCustomerId(),response.getBody().getCustomerId());
        System.out.println(response);
    }


    @Test
    @Order(3)
    void update() {
        String url = Base_Url + "/update";
        Customer newCustomer = new Customer.Builder().copy(customer).setLastName("Mild").build();
        ResponseEntity<Customer> post = trt.postForEntity(url,newCustomer,Customer.class);
        assertNotNull(post.getBody());
        assertNotNull(post);
        Customer updated = post.getBody();
        assertEquals(newCustomer.getCustomerId(),updated.getCustomerId());
        System.out.println("Update: " + updated);
    }

    @Test
    @Order(4)
    void readall() {
      String url = Base_Url +"/readall";
      HttpHeaders header = new HttpHeaders();
      HttpEntity<String> entity = new HttpEntity(null,header);
      ResponseEntity<String> response = trt.exchange(url,HttpMethod.GET,entity,String.class);
        System.out.println("List of all: ");
        System.out.println(response.getBody());
    }
}
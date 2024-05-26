package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.repository.AddressRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressControllerTest {

    @Autowired
    private TestRestTemplate trt;
    private String Base_Url = "http://localhost:8080/LuxuryHairVendingSystemDB/address";
    private static Address address;

    @BeforeEach
    void setUp() {
        address = AddressFactory.buildAdd(12837L,12, "winners way","JHB", 8878);

    }

    @Test
    @Order(1)
    void create() {
        String url = Base_Url + "/create";
        ResponseEntity<Address> postResp = trt.postForEntity(url, address, Address.class);
        assertNotNull(postResp);
        assertNotNull(postResp.getBody());
        Address addSaved = postResp.getBody();
        assertEquals(address.getAddressId(), addSaved.getAddressId());
        System.out.println("Saved data: " + addSaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = Base_Url + "/read/" + address.getAddressId();
        System.out.println("URL: " + url);
        ResponseEntity<Address> response = trt.getForEntity(url, Address.class);
        assertEquals(address.getAddressId(), response.getBody().getAddressId());
        System.out.println("Read: " + response.getBody());

    }

    @Test
    @Order(3)
    void update() {
        String url = Base_Url + "/update";
        Address newAddress = new Address.Builder().copy(address).setStreetName("Flint crescent").build();
        ResponseEntity<Address> postResponse = trt.postForEntity(url,newAddress, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Address addressUpdated = postResponse.getBody();
        assertEquals(newAddress.getStreetName(), addressUpdated.getStreetName());
        System.out.println("Updated Values: " + addressUpdated);
    }

    @Test
    @Order(4)
    void getall() {
        String url = Base_Url + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,header);
        ResponseEntity<String> response = trt.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}
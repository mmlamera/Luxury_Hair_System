package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.factory.AdminLoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminLoginControllerTest {
    @Autowired
    private TestRestTemplate trt;
    private String Base_Url = "http://localhost:8080/LuxuryHairVendingSystemDB/adminlogin";
    private static AdminLogin adminLogin;
    @BeforeEach
    void setUp() {
        adminLogin = AdminLoginFactory.createAdminLogin(6556L,"johndon@gmail.com","622716jd","John Doe");
    }

    @Test
    @Order(1)
    void create() {
        String url = Base_Url + "/create";
        ResponseEntity<AdminLogin> postResp = trt.postForEntity(url, adminLogin, AdminLogin.class);
        assertNotNull(postResp);
        assertNotNull(postResp.getBody());
        AdminLogin addSaved = postResp.getBody();
        assertEquals(adminLogin.getAdminId(), addSaved.getAdminId());
        System.out.println("Saved data: " + addSaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = Base_Url + "/read/" + adminLogin.getAdminId();
        System.out.println("URL: " + url);
        ResponseEntity<AdminLogin> response = trt.getForEntity(url, AdminLogin.class);
        assertEquals(adminLogin.getAdminId(), response.getBody().getAdminId());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    void update() {
        String url = Base_Url + "/update";
        AdminLogin newAdminLogin = new AdminLogin.Builder().copy(adminLogin).setEmail("johndoedoe2@email.com").build();
        ResponseEntity<AdminLogin> postResponse = trt.postForEntity(url,newAdminLogin, AdminLogin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        AdminLogin adminloginUpdated = postResponse.getBody();
        assertEquals(newAdminLogin.getEmail(), adminloginUpdated.getEmail());
        System.out.println("Updated Values: " + adminloginUpdated);
    }
}
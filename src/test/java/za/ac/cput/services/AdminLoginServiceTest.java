package za.ac.cput.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.factory.AdminLoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminLoginServiceTest {

    @Autowired
    private AdminLoginService service;
    AdminLogin adminLogin;
    @BeforeEach
    void setUp() {
        adminLogin = AdminLoginFactory.createAdminLogin(56241L,"jakeronald@gmail.com","jron1212","Jake Ronald");

    }

    @Test
    @Order(4)
    void getall() {
        System.out.println(service.getall());
    }

    @Test
    @Order(1)
    void create() {
        AdminLogin add = service.create(adminLogin);
        assertNotNull(add);
        System.out.println("Added : " +  add);
    }

    @Test
    @Order(2)
    void read() {
        AdminLogin read = service.read(adminLogin.getAdminId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        AdminLogin update = new AdminLogin.Builder().copy(adminLogin).setPassword("Jake007").build();
        AdminLogin updated = service.update(update);
        System.out.println(updated);
    }
}
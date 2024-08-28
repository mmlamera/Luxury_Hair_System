package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.AdminLoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdminLoginRepositoryTest {
    private AdminLogin adminLogin;
    @Autowired
    private AdminLoginRepository repository;
    @BeforeEach
    void setUp() {
        adminLogin = AdminLoginFactory.createAdminLogin(1221L,"peterpaulgmail.com","paulpeter34","Paul John Peter");
        assertNotNull(adminLogin);
        repository.save(adminLogin);

    }
    @Test
    void findByAdminId() {
        adminLogin = repository.findByAdminId(1221L);
        System.out.println("Found: " + adminLogin);
    }
}
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.AdminLogin;

import static org.junit.jupiter.api.Assertions.*;

class AdminLoginFactoryTest {

    @Test
    void createAdminLogin() {
        AdminLogin adminLogin = AdminLoginFactory.createAdminLogin(1221L, "kellyklark@outlook.com","kkk123","Kelly Kasey Klark");
        assertNotNull(adminLogin);
        System.out.println(adminLogin);
    }
}
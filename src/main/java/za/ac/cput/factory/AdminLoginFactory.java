package za.ac.cput.factory;

import za.ac.cput.domain.AdminLogin;
import za.ac.cput.util.Helper;

public class AdminLoginFactory {

    public static AdminLogin createAdminLogin(Long adminId,String email, String password, String fullName) {
        if(Helper.isNullOrEmpty(String.valueOf(adminId)) || Helper.isNullOrEmpty(email)|| Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(fullName)) {
            return null;
        }
            return new AdminLogin.Builder()
                .setAdminId(adminId)
                .setEmail(email)
                .setPassword(password)
                .setFullName(fullName)
                .build();
    }
}


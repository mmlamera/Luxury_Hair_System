package za.ac.cput.factory;

import za.ac.cput.domain.CustomerLogin;
import za.ac.cput.util.Helper;

public class CustomerLoginFactory {

    public static CustomerLogin createCustomerLogin(Long customerId,String email, String password, String fullName) {
        if(Helper.isNullOrEmpty(String.valueOf(customerId)) || Helper.isNullOrEmpty(email)|| Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(fullName)) {
            return null;
        }

        return new CustomerLogin.Builder()
                .setCustomerId(customerId)
                .setEmail(email)
                .setPassword(password)
                .setFullName(fullName)
                .build();
    }
}

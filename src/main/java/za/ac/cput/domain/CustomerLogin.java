package za.ac.cput.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CustomerLogin {

    @Id
    private Long customerId;
    private String email;
    private String password;
    private String fullName;

    public CustomerLogin() {}


    private CustomerLogin(Builder builder) {
        this.customerId = builder.customerId;
        this.email = builder.email;
        this.password = builder.password;
        this.fullName = builder.fullName;
    }

    public Long getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerLogin that = (CustomerLogin) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, password, fullName);
    }

    @Override
    public String toString() {
        return "CustomerLogin{" +
                "id=" + customerId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }


    public static class Builder {
        private Long customerId;
        private String email;
        private String password;
        private String fullName;

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public Builder copy(CustomerLogin customerLogin){
            this.customerId = customerLogin.customerId;
            this.email = customerLogin.email;
            this.password = customerLogin.password;
            this.fullName = customerLogin.fullName;
            return this;
        }

        public CustomerLogin build() {
            return new CustomerLogin(this);
        }
    }
}

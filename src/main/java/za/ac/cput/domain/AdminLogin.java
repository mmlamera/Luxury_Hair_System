package za.ac.cput.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AdminLogin {

    @Id
    private Long adminId;
    private String email;
    private String password;
    private String fullName;

    public AdminLogin() {}


    private AdminLogin(Builder builder) {
        this.adminId = builder.adminId;
        this.email = builder.email;
        this.password = builder.password;
        this.fullName = builder.fullName;
    }

    // Getters and Setters
    public Long getAdminId() { return adminId; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getFullName() { return fullName; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminLogin that = (AdminLogin) o;
        return Objects.equals(adminId, that.adminId) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, email, password, fullName);
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "id=" + adminId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    // Builder pattern
    public static class Builder {
        private Long adminId;
        private String email;
        private String password;
        private String fullName;

        public Builder setAdminId(Long id) {
            this.adminId = id;
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

        public Builder copy(AdminLogin adminLogin){
            this.adminId = adminLogin.adminId;
            this.email = adminLogin.email;
            this.password = adminLogin.password;
            this.fullName = adminLogin.fullName;
            return this;
        }

        public AdminLogin build() {
            return new AdminLogin(this);
        }
    }
}


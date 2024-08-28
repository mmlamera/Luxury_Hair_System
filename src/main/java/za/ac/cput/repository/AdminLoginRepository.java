package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.AdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, Long> {
    AdminLogin findByAdminId(Long id);
}

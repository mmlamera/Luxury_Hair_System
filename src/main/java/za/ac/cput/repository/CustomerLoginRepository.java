package za.ac.cput.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CustomerLogin;
@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerLogin, Long> {
    CustomerLogin findByCustomerId(Long id);
}

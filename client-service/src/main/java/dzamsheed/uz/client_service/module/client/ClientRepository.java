package dzamsheed.uz.client_service.module.client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Integer id);
}

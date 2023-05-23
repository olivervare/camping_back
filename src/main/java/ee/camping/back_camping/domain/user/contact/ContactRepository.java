package ee.camping.back_camping.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select c from Contact c where c.id = ?1")
    Contact getContactBy(Integer id);

    @Query("select c from Contact c where c.user.id = ?1")
    Contact getUserContactBy(Integer id);


}
package org.example.workserver.repository;

import org.example.workserver.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Bid, Long> {
    Bid findByPhone(String phone);
}

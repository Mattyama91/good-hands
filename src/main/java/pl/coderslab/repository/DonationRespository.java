package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Donation;

public interface DonationRespository extends JpaRepository<Donation, Long> {
}

package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Donation;

public interface DonationRespository extends JpaRepository<Donation, Long> {
}

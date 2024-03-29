package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;

public interface DonationRespository extends JpaRepository<Donation, Long> {
    @Query(value = "SELECT SUM(quantity)\n" +
            "FROM donation;",
            nativeQuery = true)
    Integer sumOfQuantity();
}

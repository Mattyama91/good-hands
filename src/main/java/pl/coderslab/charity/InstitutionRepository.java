package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}

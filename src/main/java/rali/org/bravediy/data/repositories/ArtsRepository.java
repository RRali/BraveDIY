package rali.org.bravediy.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rali.org.bravediy.data.models.Art;

@Repository
public interface ArtsRepository extends JpaRepository<Art, Long> {
}

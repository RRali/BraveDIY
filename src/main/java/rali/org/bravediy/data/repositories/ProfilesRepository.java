package rali.org.bravediy.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import rali.org.bravediy.data.models.Profile;

import java.util.Optional;

public interface ProfilesRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> getByNameIgnoreCase(String name);

    Optional<Profile> getByUserUsername(String username);
}

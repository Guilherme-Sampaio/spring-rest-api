package project.guilherme.repository;

import project.guilherme.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}

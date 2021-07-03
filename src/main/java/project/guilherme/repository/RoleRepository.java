package project.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.guilherme.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

}

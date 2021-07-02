package project.guilherme.repository;

import project.guilherme.entities.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

}

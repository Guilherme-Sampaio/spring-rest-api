package project.guilherme.repository;

import project.guilherme.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

    List<AppointmentModel> findByUserId(Long userId);
}

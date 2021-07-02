package project.guilherme.controller;

import project.guilherme.entities.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.guilherme.repository.AppointmentRepository;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping
    public ResponseEntity<AppointmentModel> createAppointment(AppointmentModel appointment) {
        try {
            AppointmentModel newAppointment = appointmentRepository.save(appointment);
            return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

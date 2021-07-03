package project.guilherme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.guilherme.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import project.guilherme.repository.AppointmentRepository;

@RestController
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(final AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping(path = "/appointments")
    @PreAuthorize("hasRole('ROLE_DEV')")
    public void createAppointment(@RequestBody AppointmentModel appointment) {
        appointmentRepository.save(appointment);
    }

    @GetMapping(path = "/appointments/user/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_DEV')")
    public Iterable<AppointmentModel> getAppointmentsByUserId(@PathVariable Long id) {
        return appointmentRepository.findByUserId(id);
    }

    @GetMapping(path = "/appointments")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Iterable<AppointmentModel> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}

package project.guilherme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.guilherme.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import project.guilherme.repository.AppointmentRepository;
import project.guilherme.service.LoggerService;

@Controller
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(final AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping(path = "/appointments")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_DEV')")
    public AppointmentModel createAppointment(@RequestBody AppointmentModel appointment) {
        LoggerService.logger("Guilherme appointment: " + appointment);
        return appointmentRepository.save(appointment);
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

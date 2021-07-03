package project.guilherme.controller;

import org.springframework.web.bind.annotation.*;
import project.guilherme.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import project.guilherme.repository.AppointmentRepository;

@RestController
//@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(final AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping(path = "/appointments")
    public void createAppointment(@RequestBody AppointmentModel appointment) {
        appointmentRepository.save(appointment);
    }

    @GetMapping(path = "/appointments/user/{id}")
    public Iterable<AppointmentModel> getAppointmentsByUserId(@PathVariable Long id) {
        return appointmentRepository.findByUserId(id);
    }

    @GetMapping(path = "/appointments")
    public Iterable<AppointmentModel> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}

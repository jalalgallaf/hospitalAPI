package com.restaurantsystem.hosptialapi.seeder;

import com.github.javafaker.Faker;
import com.restaurantsystem.hosptialapi.models.Appointment;
import com.restaurantsystem.hosptialapi.models.Patient;
import com.restaurantsystem.hosptialapi.models.Staff;

import com.restaurantsystem.hosptialapi.repository.AppointmentRepository;
import com.restaurantsystem.hosptialapi.repository.PatientRepository;
import com.restaurantsystem.hosptialapi.repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class DataBaseSeeder implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final StaffRepository staffRepository;
    private final AppointmentRepository appointmentRepository;
    private static final Logger logger = Logger.getLogger(DataBaseSeeder.class.getName());


    @Override
    @Transactional
    public void run(String... args) throws Exception  {
        for(int i=0; i<100; i++) {

            Faker faker = new Faker();

            try {
                Patient patient = new Patient();
                patient.setFirstName(faker.name().firstName());
                patient.setLastName(faker.name().lastName());
                patient.setDateOfBirth(faker.date().birthday());
                patient.setGender(faker.options().option("Male", "Female"));
                patient.setPhoneNumber(faker.phoneNumber().phoneNumber());
                patient.setEmail(faker.internet().emailAddress());
                patient.setAddress(faker.address().fullAddress());
                patient.setEmergencyContact(faker.name().fullName());

                patientRepository.save(patient);

                Staff staff = new Staff();
                List<String> hospitalRoles = Arrays.asList("Nurse", "Doctor", "Surgeon", "Radiologist", "Pharmacist", "Physiotherapist", "Dietitian", "Paramedic");
                staff.setFirstName(faker.name().firstName());
                staff.setLastName(faker.name().lastName());
                staff.setRole(faker.options().option(hospitalRoles.toArray(new String[0])));
                staff.setContactNumber(faker.phoneNumber().phoneNumber());
                staff.setEmail(faker.internet().emailAddress());
                staff.setDepartment(faker.job().field());

                staffRepository.save(staff);

                Appointment appointment = new Appointment();
                appointment.setPatient(patient);
                appointment.setStaff(staff);
                appointment.setAppointmentDate(faker.date().future(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                appointment.setNotes(faker.lorem().sentence());

                appointmentRepository.save(appointment);

                logger.info("Record saved: Patient " + patient.getFirstName() + " " + patient.getLastName() + ", Staff " + staff.getFirstName() + " " + staff.getLastName() + ", Appointment on " + appointment.getAppointmentDate());
            } catch (Exception e) {
                logger.severe("Error saving data: " + e.getMessage());
            }

        }

    }
}
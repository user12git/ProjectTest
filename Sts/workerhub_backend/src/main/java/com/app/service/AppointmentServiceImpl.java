package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Appointment;
import com.app.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService
{

	@Autowired
	AppointmentRepository aRepo;
	
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		
		return aRepo.save(appointment);
	}

	

//	public List<Appointment> getAppointmentsByUserId(Long userId) {
//        return aRepo.findByUserId(userId);
//    }

	public List<Appointment> getAppointmentsByUserId(Long userId) {
	    return aRepo.findByUserId(userId);
	}



	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return aRepo.findAll();
	}



	@Override
	public List<Appointment> getAppointmentsByWorkerId(Long workerId) {
		
		return aRepo.findByWorkerId(workerId);
	}



	public Appointment updateAppointmentStatus(Long appointmentId, String status) {
		Appointment appointment = aRepo.findById(appointmentId).orElse(null);

        if (appointment != null) {
            appointment.setStatus(status);
            return aRepo.save(appointment);
        }
        return null;
    }

}

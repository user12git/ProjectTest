package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDTO;
import com.app.entity.Appointment;
import com.app.service.AppointmentService;
import com.app.service.AppointmentServiceImpl;
import com.app.util.JwtTokenUtil;


@RequestMapping("/appointment")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController 
{
	@Autowired
	AppointmentService aservice;
	
	@Autowired
	  private ModelMapper modelmapper;
	  
	  @Autowired
	  private JwtTokenUtil jwtTokenUtil;
	  
	  @GetMapping("/all")
	    public List<Appointment> getAllAppointments() {
	        return aservice.getAllAppointments();
	    }
	  
	  @GetMapping("/u/{userId}")
	  public List<Appointment> getAppointmentsByUserId(@PathVariable Long userId) {
		  System.out.println("Fetching appointments for user ID: " + userId);
		  List<Appointment> appointments = aservice.getAppointmentsByUserId(userId);
		    System.out.println("Appointments found: " + appointments);
		    return appointments;
	  }
	  
	  @GetMapping("/w/{workerId}")
	  public List<Appointment> getAppointmentsByWorkerId(@PathVariable Long workerId) {
		 
		  List<Appointment> appointments = aservice.getAppointmentsByWorkerId(workerId);
		    return appointments;
	  }
	  
	  @PutMapping("/{id}/status")
	    public ResponseEntity<Appointment> updateStatus(@PathVariable Long id, @RequestParam String status) {
	        Appointment updatedAppointment = aservice.updateAppointmentStatus(id, status);
	        return ResponseEntity.ok(updatedAppointment);
	    }

	  
	  
//	  @GetMapping("/u/{userId}")
//	  public List<Appointment> getUserAppointments(@PathVariable Long userId) {
//	      return aservice.findByUserId(userId);
//	  }
//	  @GetMapping("/u/{userId}")
//	  public ResponseEntity<List<Appointment>> getAppointmentsByUserId(@PathVariable Long userId) {
//	        List<Appointment> appointments = aservice.getAppointmentsByUserId(userId);
//	        if (appointments.isEmpty()) {
//	            return ResponseEntity.noContent().build();
//	        }
//	        return ResponseEntity.ok(appointments);
//	    }
	  
	
	@PostMapping("/add")
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentDTO a) {
		
		Appointment apo=modelmapper.map(a, Appointment.class);
		
		return new ResponseEntity<>(aservice.bookAppointment(apo),HttpStatus.CREATED);
		
//		try {
//        Appointment savedAppointment = aservice.bookAppointment(appointment);
//        return ResponseEntity.ok(savedAppointment);
//		}
//		catch (Exception e) {
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error booking appointment");
//	    }
    }

}

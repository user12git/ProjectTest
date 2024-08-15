package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
//	@Query("SELECT a FROM Appointment a WHERE a.userId = :userId")
//    List<Appointment> findByUserId(@Param("userId") Long userId);
	
	List<Appointment> findByUserId(Long userId);
	
	List<Appointment> findByWorkerId(Long workerId);
	
	


}

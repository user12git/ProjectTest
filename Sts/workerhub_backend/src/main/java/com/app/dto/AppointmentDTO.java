package com.app.dto;

import java.time.LocalDate;

import com.app.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class AppointmentDTO 
{
	
	private String workerName;
	
	private String userName;
	
	private String uphone;
	
	private String wphone;
	
	private String workerField;
	
	private String visitingCharge;
	
	private String address;
	
	private String pincode;
	
	private String status = "pending";
	
	private LocalDate date;
	
	private Long userId;
	
	private Long workerId;

	public AppointmentDTO(String workerName, String userName, String uphone, String wphone, String workerField,
			String visitingCharge, String address, String pincode, Long userId, Long workerId) {
		super();
		this.workerName = workerName;
		this.userName = userName;
		this.uphone = uphone;
		this.wphone = wphone;
		this.workerField = workerField;
		this.visitingCharge = visitingCharge;
		this.address = address;
		this.pincode = pincode;
		this.date = LocalDate.now();
		this.userId = userId;
		this.workerId = workerId;
	}

	

	
	
	

}

package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@Setter@Getter
@ToString
public class Appointment 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

	@Column(name="Worker_Name")
    private String workerName;
	@Column(name="User_Name")
	private String userName;
	@Column(name="User_Phone")
	private String uphone;
	@Column(name="Worker_Phone")
	private String wphone;
	@Column(name="Worker_Field")
    private String workerField;
	@Column(name="Visiting_Charge")
    private String visitingCharge;
	@Column(name="Address")
    private String address;
	@Column(name="PinCode")
	private String pincode;
	@Column(name="Appointment_Date")
	private LocalDate date;
	@Column(name="Status")
	private String status = "pending";
	@Column(name="userId")
    private Long userId;
	@Column(name="WorkerId")
	private Long workerId;
	public Appointment(Long id, String workerName, String userName, String uphone, String wphone, String workerField,
			String visitingCharge, String address, String pincode, Long userId, Long workerId) {
		super();
		this.id = id;
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

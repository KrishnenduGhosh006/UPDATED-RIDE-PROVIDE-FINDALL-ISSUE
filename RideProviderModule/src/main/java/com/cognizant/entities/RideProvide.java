package com.cognizant.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min; 
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Ride_Provide" )
public class RideProvide {

	
	
	@Id
	@Column(name="Rp_Id")
	private  String  rpId;
	
	
	@Column(name="Adhar_Card")
	@NotNull
	private Long adharcard;
	
	
	@Column(name="Email_Id")
	@NotEmpty
	@Email
	private String emailId;
	
	@Column(name="Phone")
	@NotNull
	private long phone;
	
	@Column(name="First_Name")
	@NotEmpty
	@Size(min=3)
	private String firstName;
	
	@Column(name="Last_Name")
	@NotEmpty
	@Size(min=3)
	private String lastName;
	
	@Column(name="Dl_No")
	@NotNull
	@Size(min=16, max=16)
	private String dlNo;
	
	@Column(name="Valid_Upto")
	@NotNull
	@Future
	private LocalDate validUpto;
	
	@Column(name="Status")
	@NotEmpty
	private String status;

	public String getRpId() {
		return rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	public Long getAdharcard() {
		return adharcard;
	}

	public void setAdharcard(Long adharcard) {
		this.adharcard = adharcard;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public LocalDate getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(LocalDate validUpto) {
		this.validUpto = validUpto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adharcard, dlNo, emailId, firstName, lastName, phone, rpId, status, validUpto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RideProvide other = (RideProvide) obj;
		return adharcard == other.adharcard && Objects.equals(dlNo, other.dlNo)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && phone == other.phone && Objects.equals(rpId, other.rpId)
				&& Objects.equals(status, other.status) && Objects.equals(validUpto, other.validUpto);
	}
	

	
	
	
	
	
	
	
	

}

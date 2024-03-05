package com.cognizant.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="Ride_Info" )
//@IdClass(RideInfoId.class)


public class RideInfo {


@Embeddable
public
class RideInfoVehicleRpId implements Serializable {
	String vechileNo;
	
	String Rp_Id;
	
	public RideInfoVehicleRpId() {
		System.out.println("--RideInfoVehicleRpId--");
	}

	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getRp_Id() {
		return Rp_Id;
	}

	public void setRp_Id(String rp_Id) {
		Rp_Id = rp_Id;
	}

	@Override
	public String toString() {
		return "RideInfoVehicleRpId [vechileNo=" + vechileNo + ", Rp_Id=" + Rp_Id + "]";
	}
	
	
	
}

	
	/*
	@Id
	@jakarta.persistence.Column(name="Vechile_No")
	@NotNull
	private String vechileNo;

	@Id
	@jakarta.persistence.Column(name="rp_id")
	@NotNull
	private String rpId;
	*/
	@EmbeddedId RideInfo.RideInfoVehicleRpId rideInfoVehicleRpId;
	@jakarta.persistence.Column(name="Car_Type")
	@NotEmpty
	private String carType;
	
	
	
	public RideInfo.RideInfoVehicleRpId getRideInfoVehicleRpId() {
		return rideInfoVehicleRpId;
	}

	public void setRideInfoVehicleRpId(RideInfo.RideInfoVehicleRpId rideInfoVehicleRpId) {
		this.rideInfoVehicleRpId = rideInfoVehicleRpId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public RideProvide getRideProvide() {
		return rideProvide;
	}

	public void setRideProvide(RideProvide rideProvide) {
		this.rideProvide = rideProvide;
	}

	@jakarta.persistence.Column(name="Car_Name")
	@NotEmpty
	private String CarName;
	
	@jakarta.persistence.Column(name="Fuel_Type")
	@NotEmpty
	private String fuelType;
	
	@jakarta.persistence.Column(name="No_Of_Seats")
	@NotNull
	@Min(value=0)
	private int noOfSeats;

	@ManyToOne
   @JoinColumn(name = "Rp_Id", referencedColumnName = "Rp_Id",insertable = false,updatable = false)
    private RideProvide rideProvide;
/*
	public String getVechileNo() {
		return vechileNo;
	}

	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}

	public String getRpId() {
		return rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public RideProvide getRideProvide() {
		return rideProvide;
	}

	public void setRideProvide(RideProvide rideProvide) {
		this.rideProvide = rideProvide;
	}
*/



	@Override
	public String toString() {
		return "RideInfo [rideInfoVehicleRpId=" + rideInfoVehicleRpId + ", carType=" + carType + ", CarName=" + CarName
				+ ", fuelType=" + fuelType + ", noOfSeats=" + noOfSeats + ", rideProvide=" + rideProvide + "]";
	}
	
	
}

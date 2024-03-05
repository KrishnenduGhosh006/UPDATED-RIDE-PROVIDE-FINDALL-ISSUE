package com.cognizant.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Simles" )
public class Simles {

	@Id
	@jakarta.persistence.Column(name="Smile_Id")
	private Integer smileId;
	
	@jakarta.persistence.Column(name="Rp_Id")
	@NotNull
	private String rpId;
	
	@jakarta.persistence.Column(name="Source")
	@NotEmpty
	private String source;
	
	@jakarta.persistence.Column(name="Destination")
	@NotEmpty
	private String destination;	
	
	@jakarta.persistence.Column(name="Occupancy")
	@NotNull
	@Min(value=0)
	private int occupancy;

	@ManyToOne
   // @JoinColumn(name = "Rp_Id", referencedColumnName = "Rp_Id",insertable = false,updatable = false)
    private RideInfo rideInfo;

	public Integer getSmileId() {
		return smileId;
	}

	public void setSmileId(Integer smileId) {
		this.smileId = smileId;
	}

	public String getRpId() {
		return rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public RideInfo getRideInfo() {
		return rideInfo;
	}

	public void setRideInfo(RideInfo rideInfo) {
		this.rideInfo = rideInfo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destination, occupancy, rideInfo, rpId, smileId, source);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Simles other = (Simles) obj;
		return Objects.equals(destination, other.destination) && occupancy == other.occupancy
				&& Objects.equals(rideInfo, other.rideInfo) && Objects.equals(rpId, other.rpId)
				&& Objects.equals(smileId, other.smileId) && Objects.equals(source, other.source);
	}

	
	
}

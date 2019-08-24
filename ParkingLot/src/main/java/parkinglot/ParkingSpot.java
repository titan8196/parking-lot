package parkinglot;

import parkinglot.Vehicle.Vehicle;


public class ParkingSpot {
	
	private int spotNumber;
	private Vehicle vehicle;
	
	public ParkingSpot(){
		
	}
	
	public ParkingSpot(int spotNumber, Vehicle vehicle){
		this.spotNumber = spotNumber;
		this.vehicle = vehicle;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}

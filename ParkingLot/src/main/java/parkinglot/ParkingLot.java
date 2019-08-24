package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import parkinglot.Vehicle.Vehicle;

public class ParkingLot {
	private ParkingSpot[] parkingSpots;
	private Map<String , ArrayList<ParkingSpot>> colorToVehicle;
	private int availableSlots;
	
	public ParkingLot(){
		
	}
	
	public ParkingLot(int numSpots){
		this.availableSlots = numSpots;
		parkingSpots = new ParkingSpot[numSpots];
		this.colorToVehicle = new HashMap<String, ArrayList<ParkingSpot>>();
		System.out.println("Created a parking lot with " + numSpots + " slots");
	}
	
	public boolean parkVehicle(Vehicle vehicle){
		if(isSlotAvailable()){
			for(int i=0; i<parkingSpots.length; i++){
				if(parkingSpots[i]==null){
					ParkingSpot parkingSpot = new ParkingSpot();
					parkingSpot.setSpotNumber(i+1);
					parkingSpot.setVehicle(vehicle);
					parkingSpots[i] = parkingSpot;
					availableSlots--;
					System.out.println("Allocated slot number: " + parkingSpots[i].getSpotNumber());
					mapVehicleToColor(colorToVehicle,parkingSpots[i]);
					return true;
				}
			}
		}
		System.out.println("Sorry, parking lot is full");
		return false;
	}
	
	private boolean isSlotAvailable(){
		return availableSlots!=0;
	}
	
	private void mapVehicleToColor(Map<String,ArrayList<ParkingSpot>> colorToVehicle, ParkingSpot parkingSpot){
		Vehicle vehicle = parkingSpot.getVehicle();
		if(colorToVehicle.containsKey(vehicle.getColor())){
			ArrayList<ParkingSpot> listParkingSpot = colorToVehicle.get(vehicle.getColor());
			listParkingSpot.add(parkingSpot);
			colorToVehicle.put(vehicle.getColor(),listParkingSpot);
		} else {
			ArrayList<ParkingSpot> listParkingSpot = new ArrayList<ParkingSpot>();
			listParkingSpot.add(parkingSpot);
			colorToVehicle.put(vehicle.getColor(),listParkingSpot);
		}
	}
}

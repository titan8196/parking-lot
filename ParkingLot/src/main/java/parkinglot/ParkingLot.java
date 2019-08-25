package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import parkinglot.Vehicle.Vehicle;
import static parkinglot.Utils.Constants.*;

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
	
	public boolean leave(int slotNumber){
		for(int i=0; i<parkingSpots.length; i++){
			if( parkingSpots[i] != null && parkingSpots[i].getSpotNumber()==slotNumber) {
				removeFromMap(colorToVehicle,parkingSpots[i]);
				parkingSpots[i] = null;
				System.out.println("Slot number " + slotNumber + " is free");
				availableSlots--;
				return true;
			}
		}
		System.out.println("Slot already empty");
		return false;
	}
	
	private void removeFromMap(Map<String,ArrayList<ParkingSpot>> colorToVehicle, ParkingSpot parkingSpot){
		Vehicle vehicle = parkingSpot.getVehicle();
		ArrayList<ParkingSpot> listParkingSpot = colorToVehicle.get(vehicle.getColor());
		listParkingSpot.remove(parkingSpot);
		colorToVehicle.put(vehicle.getColor(), listParkingSpot);
	}
	
	public void status(){
		System.out.println("Slot No. Registration No Colour");
		for (int i=0; i<parkingSpots.length;i++){
			if(parkingSpots[i]!=null){
				System.out.println(parkingSpots[i].getSpotNumber()+ "    "  + 
						"    " + parkingSpots[i].getVehicle().getRegistrationNumber() + "   " +
			parkingSpots[i].getVehicle().getColor());
			}
		}
	}
	
	public void getAllCarsWithColor(String color,String type){
		ArrayList<ParkingSpot> listParkingSlot = colorToVehicle.get(color);
		Vehicle car;
		
		if (listParkingSlot == null){
			System.out.println("Not found");
		} else {
			for(int i=0;i<listParkingSlot.size();i++){
				car = listParkingSlot.get(i).getVehicle();
				if(TYPE_REGISTRATION_NUMBER.equalsIgnoreCase(type)){
					System.out.print(car.getRegistrationNumber());
				} else if (TYPE_SLOT_NUMBER.equalsIgnoreCase(type)){
					System.out.print(listParkingSlot.get(i).getSpotNumber());
				}
				if(i!=listParkingSlot.size()-1){
					System.out.print(", ");
				}else {
					System.out.println("");
				}
			}
		}
	}
	
	public void getSlotNumForRegistrationNum(String RegistrationNumber){
		int flag=0;
		for(int i=0; (i<parkingSpots.length) && (flag==0);i++){
			if(parkingSpots[i] != null && 
					parkingSpots[i].getVehicle().getRegistrationNumber().equalsIgnoreCase(RegistrationNumber)){
				System.out.println(parkingSpots[i].getSpotNumber());
				flag=1;
			}
		}
		if (flag==0){
			System.out.println("Not found");
		}
	}
}

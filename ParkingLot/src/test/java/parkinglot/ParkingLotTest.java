package parkinglot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parkinglot.Vehicle.Car;
import parkinglot.Vehicle.Vehicle;

public class ParkingLotTest {
	
	private ParkingLot parkingLot;
	
	private Vehicle vehicle;
	
	@Before
	public void setUp(){
		parkingLot = new ParkingLot(6);
	}
	
	@Test
	public void parkVehicleSlotAvailable(){
		vehicle = new Car("KA-01-P-333", "White");
		assertEquals(parkingLot.parkVehicle(vehicle),true);
	}
	
	@Test
	public void parkVehicleNoSlotAvailable(){
		for(int i=0; i<6;i++){
			vehicle = new Car("KA-01-P-33"+i, "White");
			parkingLot.parkVehicle(vehicle);
		}
		vehicle = new Car("KA-01-P-336", "White");
		assertEquals(parkingLot.parkVehicle(vehicle),false);
	}
	
	@Test
	public void parkVehiclePartialSlotAvailable(){
		for(int i=0; i<4;i++){
			vehicle = new Car("KA-01-P-33"+i, "White");
			parkingLot.parkVehicle(vehicle);
		}
		vehicle = new Car("KA-01-P-334", "White");
		assertEquals(parkingLot.parkVehicle(vehicle),true);
	}
	
	@Test
	public void leaveSlotVehicleExists(){
		vehicle = new Car("KA-01-P-333", "White");
		parkingLot.parkVehicle(vehicle);
		assertEquals(parkingLot.leave(1),true);
	}
	
	@Test
	public void leaveSlotVehicleDoesntExists(){
		vehicle = new Car("KA-01-P-333", "White");
		parkingLot.parkVehicle(vehicle);
		assertEquals(parkingLot.leave(2),false);
	}
}

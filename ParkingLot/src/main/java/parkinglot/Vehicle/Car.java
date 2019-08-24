package parkinglot.Vehicle;

public class Car extends Vehicle{
	
	public Car(String registrationNumber, String color){
        spotsNeeded = 1;
        type = VehicleType.CAR;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}

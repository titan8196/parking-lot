package parkinglot.Vehicle;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String color;
    protected int spotsNeeded;
    protected VehicleType type;
    
    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    
    public VehicleType getType(){
        return type;
    }

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

}

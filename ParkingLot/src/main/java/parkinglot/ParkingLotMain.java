package parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parkinglot.Vehicle.Car;
import parkinglot.Vehicle.Vehicle;
import static parkinglot.Utils.Constants.*;

public class ParkingLotMain {

	public static void main(String[] args) throws IOException {
		ParkingLot parkingLot=null;
		if(args.length==0){
			String command;
			String[] splitCommand;
			int exitFlag=0;
			do{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				command = reader.readLine();
				splitCommand = command.split(" ");
				switch(splitCommand[0]){
					case CREATE_PARKING_LOT:
						parkingLot = new ParkingLot(Integer.parseInt(splitCommand[1]));
						break;
					case PARK_VEHICLE:
						String registrationNum = splitCommand[1];
						String color = splitCommand[2];
						Vehicle vehicle = new Car(registrationNum,color);
						parkingLot.parkVehicle(vehicle);
						break;
					case LEAVE_SPOT:
						parkingLot.leave(Integer.parseInt(splitCommand[1]));
						break;
					case PRINT_PARKING_LOT:
						parkingLot.status();
						break;
					case PRINT_CAR_NUM_FOR_COLOR:
						parkingLot.getAllCarsWithColor(splitCommand[1], TYPE_REGISTRATION_NUMBER);
						break;
					case PRINT_SLOT_NUM_FOR_COLOR:
						parkingLot.getAllCarsWithColor(splitCommand[1], TYPE_SLOT_NUMBER);
						break;
					case PRINT_SLOT_NUM_FOR_CAR_NUM:
						parkingLot.getSlotNumForRegistrationNum(splitCommand[1]);
						break;
					case EXIT:
						exitFlag=1;
						break;
					default:
						System.out.println("Invalid command");
						
				}
			}while(exitFlag==0);
		}

	}

}

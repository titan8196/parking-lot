package parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parkinglot.Vehicle.Car;
import parkinglot.Vehicle.Vehicle;
import static parkinglot.Utils.Constants.*;

public class ParkingLotMain {

	private static String command;
	private static String[] splitCommand;
	private static int exitFlag=0;
	private static ParkingLot parkingLot=null;
	private static BufferedReader reader;
	
	public static void main(String[] args) throws IOException {
		
		if(args.length==0){
			do{
				reader = new BufferedReader(new InputStreamReader(System.in));
				command = reader.readLine();
				executeParkingLotSystem(command);	
			}while(exitFlag==0);
		} else if (args.length==1){
			File file = new File(args[0]); 
			reader = new BufferedReader(new FileReader(file));
			while ((command = reader.readLine()) != null){
				executeParkingLotSystem(command);
			}
		} else {
			System.out.println("Invalid Number of Arguments passed.");
		}
		
	}
	
	private static void executeParkingLotSystem(String command) throws IOException{
		splitCommand = command.split(" ");
		switch(splitCommand[0]){
			case CREATE_PARKING_LOT:
				if(splitCommand.length!=2){
					System.out.println("Invalid command");
				}else{
					parkingLot = new ParkingLot(Integer.parseInt(splitCommand[1]));
				}
				break;
			case PARK_VEHICLE:
				if(splitCommand.length!=3){
					System.out.println("Invalid command");
				}
				else{
					String registrationNum = splitCommand[1];
					String color = splitCommand[2];
					Vehicle vehicle = new Car(registrationNum,color);
					parkingLot.parkVehicle(vehicle);
				}
				break;
			case LEAVE_SPOT:
				if(splitCommand.length!=2){
					System.out.println("Invalid command");
				}else{
					parkingLot.leave(Integer.parseInt(splitCommand[1]));
				}
				break;
			case PRINT_PARKING_LOT:
				parkingLot.status();
				break;
			case PRINT_CAR_NUM_FOR_COLOR:
				if(splitCommand.length!=2){
					System.out.println("Invalid command");
				}else{
					parkingLot.getAllCarsWithColor(splitCommand[1], TYPE_REGISTRATION_NUMBER);
				}
				break;
			case PRINT_SLOT_NUM_FOR_COLOR:
				if(splitCommand.length!=2){
					System.out.println("Invalid command");
				}else{
					parkingLot.getAllCarsWithColor(splitCommand[1], TYPE_SLOT_NUMBER);
				}
				break;
			case PRINT_SLOT_NUM_FOR_CAR_NUM:
				if(splitCommand.length!=2){
					System.out.println("Invalid command");
				}else{
					parkingLot.getSlotNumForRegistrationNum(splitCommand[1]);
				}
				break;
			case EXIT:
				exitFlag=1;
				break;
			default:
				System.out.println("Invalid command");
		}
	}

}

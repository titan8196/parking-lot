# Parking Lot
This is an automated parking lot system designed to allow customers to park their vehicles without human intervention.

## Getting Started
The actual code sits under ParkingLot folder which can be imported in any IDE to start with development. Application is to be built using gradle.

### Prerequisites

Before importing the project check if gradle plugin exists in your IDE. If not first install gradle plugin and then proceed with import.

### Building the Project

To build the project use either of the three approaches below
1. Right click on build.gradle file in your workspace. Click on Run As-> Run Configurations-> Gradle Project-> New Launch Configuration.
Now Select working directory as "ParkingLot". Click on Add task under gradle task and add below task.   
``` 
clean build 
```
Click on Run and it will build the project
	
2. Open command prompt in Root location (ParkingLot) and run below command
``` 
$ gradlew clean build 
```

3. Execute setup file inside bin folder
```
$ bin/setup
```
**Note : This will only work on Linux**
	   
Any of the above three approaches will run application build + unit tests.

### Running the application

Once the application is built. You can run the application using any of the below three approaches.
1. Directly using Java class file -> Right click on ParkingLotMain.java file -> Click on Run As -> Java Application. If you want to specify application arguments, 
click on run configuration and enter arguments and then click on Run.
2. Open command prompt in the following folder /ParkingLot/build/libs and run below command 
```
java -classpath ParkingLot.jar parkingLot.ParkingLotMain
```

3. Execute parking_lot file inside bin folder
```
$ bin/parking_lot
```

**Note : This will only work on Linux**
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.sumeer.ParkingLot.*;
import java.io.*;


public class ParkingLotTest {

	private static final PrintStream os = null;
	private static BufferedReader inputLine = null;
	private static boolean closed = false;
		
	public static void main(String args[]) {
	    // need
	    if (args.length > 0) {
			    
			    	System.out.println(args[0]);
			    	 // The name of the file to open.
			        String fileName = args[0];

			        // This will reference one line at a time
			        String line = null;

			        try {
			            // FileReader reads text files in the default encoding.
			            FileReader fileReader = 
			                new FileReader(fileName);

			            // Always wrap FileReader in BufferedReader.
			            BufferedReader bufferedReader = 
			                new BufferedReader(fileReader);

			            while((line = bufferedReader.readLine()) != null) {
			                System.out.println(line);
			            }   

			            // Always close files.
			            bufferedReader.close();         
			        }
			        catch(FileNotFoundException ex) {
			            System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");                
			        }
			        catch(IOException ex) {
			            System.out.println(
			                "Error reading file '" 
			                + fileName + "'");                  
			            // Or we could just do this: 
			            // ex.printStackTrace();
			        }
			    
			  }
		 
		ParkingSlot PS = new ParkingSlot();// eclipse is givng an error
		inputLine = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (!closed) {
				System.out.println("waiting...");
				String str =  inputLine.readLine().trim();
				System.out.println(str);
				str.trim();
			if (str.startsWith("create_parking_lot")) {
				String[] tokens = str.split(" ");
				int number = Integer.parseInt(tokens[1]);	
				PS = new ParkingSlot(number);
			}
			
			if (str.startsWith("park")) {
				String[] tokens = str.split(" ");
				String carNumber = tokens[1];
				String carColor = tokens[2];
				//park <reg> <color>
				int slotNumber = PS.AddVehicle(carNumber, carColor);
				//slot number to be printed is 1 more than the index returned
				System.out.println("Allocated slot number: " + slotNumber);
			}
			if (str.startsWith("leave")) {
				String[] tokens = str.split(" ");
				int slotNumber = Integer.parseInt(tokens[1]);	
				//leave <slotNumber>
				//error checks have to be put in
				PS.removeVehicle(slotNumber);
				System.out.println("Slot number " + slotNumber + " is free");
			
			}
			if (str.startsWith("status")) {
				
				PS.getParkingStatus();
				
			
			}
			if (str.startsWith("registration_numbers_for_cars_with_color")) {
				
				String[] tokens = str.split(" ");
				String carNumber = tokens[1];
				
			
			}
			if (str.startsWith("registration_numbers_for_cars_with_color")) {
				
				String[] tokens = str.split(" ");
				String carNumber = tokens[1];
				
			
			}
			
		} 
	} catch (IOException e) {
				 
	}
}
}

import java.util.*;
import java.util.regex.*;

public class TimeAndTimeAgain {
    private static Scanner s = new Scanner(System.in);
    public static void main(String args[]) {
    	
    	parseInput_NoRegex();
//    	parseInput_WithRegex();
      
    }
    
    private static void parseInput_WithRegex() {
		
    	int numberOfIterations = Integer.parseInt(s.nextLine());
    	

    	Pattern hoursRegex = Pattern.compile("(\\d+)h");
    	Pattern minutesRegex = Pattern.compile("(\\d+)m");
    	Pattern secondsRegex = Pattern.compile("(\\d+)s");
    	
    	System.out.println();
    	for (int i = 0; i < numberOfIterations; i ++) {
	    	String[] time = new String[] {"","",""};
    		String input = s.nextLine();
	    	
    		Matcher matcher = secondsRegex.matcher(input);
    		try {
				while(matcher.find())
					time[2] = matcher.group(1);
			} catch (IllegalStateException e) {
			}
    		matcher = minutesRegex.matcher(input);
    		try {
				if(matcher.find())
					time[1] = matcher.group(1);
			} catch (IllegalStateException e) {
			}
    		matcher = hoursRegex.matcher(input);
    		try {
				if(matcher.find())
					time[0] = matcher.group(1);
			} catch (IllegalStateException e) {
			}
    		
    		// Fill in with leading zeros
    		for (int j = 0; j < time.length; j++) {
    			if(time[j].equals("")) time[j] = "00";
    			else if (time[j].length() == 1) time[j] = "0" + time[j];
    		}
    		
    		// Print out final string
    		System.out.println(time[0]+ ":"+time[1]+":"+time[2]);
    	}
    	
	}

	public static void parseInput_NoRegex() {
    	
    	int numberOfIterations = Integer.parseInt(s.nextLine());
    	
    	for (int j = 0; j < numberOfIterations; j++) {
		
			String line = s.nextLine();
	      
	    	// Stores the indexes of each time increment into an array
	        int[] time = new int[] {line.indexOf("h"),line.indexOf("m"),line.indexOf("s")};
	      
	        // Setup variables
	        int toTry = 0,i = 0,counter = 0;
	        String[] timeStrings = new String[3];
	        while (time[0] != -1 || time[1] != -1 || time[2] != -1) {
	        	// Set i to first time increment with a valid value
	        	i = time[0] != -1 ? 0 : (time[1] != -1 ? 1 : (time[2] != -1 ? 2 : -1));
	        	
	        	// Format the new String
	        	try {
	        		toTry = i == 0 ? time[0] : (i == 1 ? time[1] : time[2]);
	        		timeStrings[i] = String.format("%02d", Integer.parseInt(line.substring(toTry-2,toTry))) + (i == 2 ? "" : ":");
	        	} catch (IndexOutOfBoundsException|NumberFormatException ex) {
	        		timeStrings[i] = String.format("%02d", Integer.parseInt(line.substring(toTry-1,toTry))) + (i == 2 ? "" : ":");
	        	}
	        	// Create strings for blank time increments
	        	if (counter == 0 && time[0] == -1) timeStrings[0] = "00:";
	        	if (counter == 0 && time[1] == -1) timeStrings[1] = "00:";
	        	if (counter == 0 && time[2] == -1) timeStrings[2] = "00";
	        	time[i] = -1;
	        	counter ++;
	        }
	        // Print out the final time
	        System.out.println();
	        for (String s : timeStrings)
	        	System.out.print(s);
    	}
    }
}

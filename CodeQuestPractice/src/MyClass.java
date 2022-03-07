import java.util.*;
import java.io.*;

public class MyClass {
    private static Scanner s = new Scanner(System.in);
    public static void main(String args[]) {
      
    	Scanner s = new Scanner(System.in);
    	int i = s.nextInt();
    	
    	System.out.println(i);
//      do {
//        System.out.println(
        		parseInput();
//        		);
//      } while (s.hasNextLine());
      
    }
    
    public static void parseInput() {
//    	String line = s.findInLine("\dh 0");
//    }
    	
    	String line = s.nextLine();
      int number = line.indexOf("s");
      
      int hours = line.indexOf("h");
      int minutes = line.indexOf("m");
      int seconds = line.indexOf("s");
      String totalString = "";
      
      int toTry = 0;
      for (int i = 0; i < 3; i++) {
	      try {
	    	  toTry = i == 0 ? hours : (i == 1 ? minutes : seconds);
	    	  if (Integer.parseInt(line.substring(toTry-2,toTry-1)) >= 0 && Integer.parseInt(line.substring(toTry-2,toTry-1)) <= 9) {
	    		  totalString += String.format("%2s", line.substring(toTry-2,toTry)) + (i == 2 ? "" : ":");
	    	  }
	    	  else {
	    		  totalString += String.format("%2s", line.substring(toTry-1,toTry)) + (i == 2 ? "" : ":");
	    	  }
	      } catch (IndexOutOfBoundsException ex) {
	    	  totalString += String.format("%2s", line.substring(toTry-1,toTry)) + (i == 2 ? "" : ":");
	      }
      }
      
//      for (int i = 0; i < String.valueOf(number).length(); i++) {
//          switch (s.next().substring(i,i+1)) {
//            case "s": seconds = Integer.parseInt(s.next().substring(i-1,i)); break;
//            case "h": hours = Integer.parseInt(s.next().substring(i-1,i)); break;
//            case "m": minutes = Integer.parseInt(s.next().substring(i-1,i)); break;
//          }
//      }
      System.out.println(totalString);
      
//      return String.format("%2d", hours) + ":" + String.format("%2d", minutes) + ":" + String.format("%2d", seconds);
    }
}

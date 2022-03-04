import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class TimeAndTimeAgain
	{

		public static void main(String[] args)
			{
				try(Scanner input = new Scanner(System.in))
				{
					int numTimeCases = input.nextInt();
					
					//gets all the digits before the s and stops at s
					Pattern hourRegex = Pattern.compile(".*(\\d+)h.*");
					Pattern minuteRegex = Pattern.compile(".*(\\d+)m.*");
					Pattern secondRegex = Pattern.compile(".*(\\d+)s.*");
					
					
					//loop through content 
					for(int num = 0; num < numTimeCases; num++)
						{
							int hour = 0; 
							int minute = 0; 
							int second = 0; 
							
							String data = input.nextLine();
							
							Matcher matcher1 = hourRegex.matcher(data);
							if(matcher1.matches())
								{
									hour = Integer.parseInt(matcher1.group(1));
								}
							
							Matcher matcher2 = minuteRegex.matcher(data);
							if(matcher2.matches())
								{
									minute = Integer.parseInt(matcher2.group(1));
								}
							
							
							Matcher matcher3 = secondRegex.matcher(data);
							if(matcher3.matches())
								{
									second = Integer.parseInt(matcher3.group(1));
								}
							
							System.out.println(hour + ":" + minute + ":" + second);
						}
					
					
					
				
				}

			}

	}

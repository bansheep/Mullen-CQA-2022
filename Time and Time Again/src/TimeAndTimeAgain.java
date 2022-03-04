import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.IOException;

public class TimeAndTimeAgain
	{
		public static void main(String[] args) throws IOException
			{
			Scanner input = new Scanner(new File("TimeAndTimeAgainTextfile.txt"));
			int numberOfCases = input.nextInt();
			for (int i = 0; i < numberOfCases; i++)
				{
				int hour = 0;
				int minute = 0; 
				int second = 0;
				String data = input.nextLine();
				
				Pattern secondRegex = Pattern.compile(".*(//d+)s.*");
				Matcher matcher1 = secondRegex.matcher(data);
				if (matcher1.matches())
					second = Integer.parseInt(matcher1.group(1));
				
				Pattern minuteRegex = Pattern.compile(".*(//d+)m.*");
				Matcher matcher2 = minuteRegex.matcher(data);
				if (matcher2.matches())
					minute = Integer.parseInt(matcher2.group(1));
				
				Pattern hourRegex = Pattern.compile(".*(//d+)h.*");
				Matcher matcher3 = hourRegex.matcher(data);
				if (matcher3.matches())
					hour = Integer.parseInt(matcher3.group(1));
				
				System.out.println(hour + ":" + minute + ":" + second);
				}

			}
	}

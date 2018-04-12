import java.util.Map;
import java.util.HashMap;

public class AlarmClock{

	public static final Map<Integer, String> timeMapping;
	public static boolean isAM = false;

	static{
		timeMapping = new HashMap<>();
		timeMapping.put(1, " one");
		timeMapping.put(2, " two");
		timeMapping.put(3, " three");
		timeMapping.put(4, " four");
		timeMapping.put(5, " five");
		timeMapping.put(6, " six");
		timeMapping.put(7, " seven");
		timeMapping.put(8, " eight");
		timeMapping.put(9, " nine");
		timeMapping.put(10, " ten");
		timeMapping.put(11, " eleven");
		timeMapping.put(12, " twelve");
		timeMapping.put(13, " thirteen");
		timeMapping.put(14, " fourteen");
		timeMapping.put(15, " fifteen");
		timeMapping.put(16, " sixteen");
		timeMapping.put(17, " seventeen");
		timeMapping.put(18, " eighteen");
		timeMapping.put(19, " nineteen");
		timeMapping.put(20, " twenty");
		timeMapping.put(30, " thirty");
		timeMapping.put(40, " forty");
		timeMapping.put(50, " fifty");
	}

	public static void main(String[] args){
		int hour, minute;

		String[] time = new String[2];
		for(String x: args){
			time = x.split(":");
		}

		if(time[0].equals("00") && time[1].equals("00")){
			System.out.println("It is midnight!");
		}else{
			hour = Integer.parseInt(time[0]);
			minute = Integer.parseInt(time[1]);
			int formatted_hour = convertHour(hour);

			String str_hour = ""; 
			String str_minute = "";

			str_hour = lookupMap(formatted_hour);

			str_minute = convertMinute(minute);

			printOutput(str_hour, str_minute);
		}

		System.exit(0);
	}

	public static String lookupMap(int searchIndex){
		String str = "";
		for(Map.Entry<Integer, String> entry : timeMapping.entrySet()){
				if(entry.getKey() == searchIndex){
					str = entry.getValue();
				}
			}
		return str;
	}

	public static int convertHour(int hour){
		if(hour >= 12){
			isAM = false;

			if(hour == 12){
				return 12;
			}
			return hour % 12;
		}else{
			isAM = true;
			return hour;
		}
	}

	public static String convertMinute(int minute){
		String str = "";
		int mod = 0;

		if(minute <= 20 || minute == 30 || minute == 40 || minute == 50){
			str = lookupMap(minute);
			return str;
		}else if(minute >= 21 && minute <= 29){
			mod = 20;
		}else if(minute >= 31 && minute <= 39){
			mod = 30;
		}else if(minute >= 41 && minute <= 49){
			mod = 40;
		}else if(minute >= 51 && minute <= 59){
			mod = 50;
		}

		str = lookupMap(mod);

		int result = minute % mod; 
		str = str + " " + lookupMap(result);
		return str;
	}

	public static void printOutput(String str_hour, String str_minute){
		StringBuilder sb = new StringBuilder();
		sb.append("The time is" + str_hour + str_minute);
		
		if(isAM){
			sb.append(" am");
		}else{
			sb.append(" pm");
		}

		System.out.println(sb);
	}

}
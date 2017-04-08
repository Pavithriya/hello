import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GetWeekEndsInAYear {

	private Calendar cal = null;
	private int year = -1;
	
	private ArrayList weekendList = null;
	
	public GetWeekEndsInAYear(int year){
		this.year = year;
		
		cal = Calendar.getInstance();
		try{
                  // Sets the date to the 1st day of the 1st month of the specified year
			cal.setTime(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + this.year));
		}catch(java.text.ParseException e){
			System.err.println("Error parsing date: " + e.getMessage());
			e.printStackTrace();
		}
		
		weekendList = new ArrayList(53);
	}

	public void findWeekends(){
            // The while loop ensures that you are only checking dates in the specified year
		while(cal.get(Calendar.YEAR) == this.year){
                  // The switch checks the day of the week for Saturdays and Sundays
			switch(cal.get(Calendar.DAY_OF_WEEK)){
				case Calendar.SATURDAY:
				case Calendar.SUNDAY:
					weekendList.add(cal.getTime());
					break;
			}
                  // Increment the day of the year for the next iteration of the while loop
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
      // Convenience method which just displays the contents of the ArrayList to the console
	public void displayWeekends(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < weekendList.size(); i++){
			System.out.println("WEEKEND: " + sdf.format((Date)weekendList.get(i)));
		}
	}

	public static void main(String[] args){
            // The program requires one argument of a year, so for example you could run the program with "java WeekendCalculator 2006"
		GetWeekEndsInAYear wf = new GetWeekEndsInAYear(2017);
		wf.findWeekends();
		wf.displayWeekends();
	}
}

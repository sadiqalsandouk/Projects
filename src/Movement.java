import java.io.*;   
import java.util.*;
import java.text.*;
public class Movement 
{
	public static void MovementFinch(int Length) 
	throws Exception 
	{
	Random RanNum = new Random();
	int  RandomWheelSpeed = RanNum.nextInt(255) + 1;
	
	//passing length variable through classes
	int Distance = Length;
	//time equation separated due to casting errors
	double Speed = (double) ((RandomWheelSpeed));
	double Time2 = Distance/Speed;
	//0.117 = m (constant)
	int Time3 = (int) ((Time2*1000)/0.117);
	//display wheel speed velocity in console
	
	System.out.println("Random Speed Generated: " + RandomWheelSpeed);
	//(start time)
	long start = System.currentTimeMillis();	
	SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
	Date date1 = new Date();
	System.out.println("***********************************************");
	System.out.println("Currently Drawing Zigzag");
	
	//loops until sections the user inputs completes
		for (int i=0; i<Zigzag.Sections/2 ; i++)
			
		{
			//set LED green
			Zigzag.mainFinch.setLED(0,255,0);
			Zigzag.mainFinch.buzz(6000,Time3);
			//move
			Zigzag.mainFinch.setWheelVelocities(RandomWheelSpeed, RandomWheelSpeed, Time3);
			//turn
			Zigzag.mainFinch.setWheelVelocities(-50, 50, 2000);
			//set LED red
			Zigzag.mainFinch.setLED(255,0,0);
			//play tune2
			Zigzag.mainFinch.buzz(3000,Time3);
			//move
			Zigzag.mainFinch.setWheelVelocities(RandomWheelSpeed, RandomWheelSpeed, Time3);
			//turn
			Zigzag.mainFinch.setWheelVelocities(50, -50, 2000);
			}	
			//retraces zigzag
			Zigzag.mainFinch.setWheelVelocities(60, -60, 1900);
	
		for (int i=0; i<Zigzag.Sections/2 ; i++)
				
			{
				//set LED green
				Zigzag.mainFinch.setLED(0,255,0);
				//play tune1
				Zigzag.mainFinch.buzz(6000,Time3);
				//move
				Zigzag.mainFinch.setWheelVelocities(RandomWheelSpeed, RandomWheelSpeed, Time3);
				//turn
				Zigzag.mainFinch.setWheelVelocities(50, -50, 2000);
				//set LED red
				Zigzag.mainFinch.setLED(255,0,0);
				//play tune2
				Zigzag.mainFinch.buzz(3000,Time3);
				//move
				Zigzag.mainFinch.setWheelVelocities(RandomWheelSpeed, RandomWheelSpeed, Time3);
				//turn
				Zigzag.mainFinch.setWheelVelocities(-50, 50, 2000);
				
			}
			//Ending Algorithm
			//(error will occur due to the file path differing to each system program is ran on)
			Zigzag.mainFinch.playClip("C:\\Users\\sadiq\\eclipse-workspace\\Zigzag\\src\\one.wav");  //jingle
			Zigzag.mainFinch.setWheelVelocities(-60, 60, 1900); //return
			Zigzag.mainFinch.buzz(10000,2000); //ending tune
			//flashes LED yellow
			for (int i=0; i<=6; i++)
			{
			Zigzag.mainFinch.setLED(255,255,0, 250);
			Zigzag.mainFinch.setLED(0,0,0, 250);
			}
			Zigzag.mainFinch.setLED(0,0,0, 3000);
			Zigzag.mainFinch.quit();
			System.out.println("***********************************************");
			System.out.println("Zigzag Complete.");
			System.out.println("(textfile.txt Updated)");
			System.out.println("***********************************************");
			System.out.println("You Can View Your Results On The Textfile!");
			//equations to calculate information from program
			int TraversedPath = (Zigzag.Length*Zigzag.Sections);
			double LengthSqr =  Math.pow(Zigzag.Length,2);
			double StraightLine0 = LengthSqr + LengthSqr;
			double StraightLine = Math.sqrt(StraightLine0);
			double TotalStraightLine = StraightLine*(Zigzag.Sections/2);
			//(end time)
			long end = System.currentTimeMillis();	
			SimpleDateFormat sdf2=new SimpleDateFormat("HH:mm:ss");
			Date date2 = new Date();
		
			//calculate elapsed time
			long diff = (end-start)/1000;
			
			
			//write to textfile
			File file = new File("textfile.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("The Program Is Now Complete!");
			pw.println("----------------------------");
			pw.println("The Traversed Path Is: " + TraversedPath+"cm");
			pw.println("The 'Straight Line' Distance Travelled Is: " + Math.round(TotalStraightLine)+"cm (to the nearest centimetre)");
			pw.println("Start Time: "+sdf1.format(date1));
			pw.println("End Time: "+sdf2.format(date2));
			pw.println("Total Elapsed Time: "+diff+" seconds");
			pw.println("");
			pw.println("try it again!");
			pw.close();
		}
	}
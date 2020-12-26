import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.*;
import javax.swing.*;
public class Zigzag 
{
	//declared GLOBAL variables
	public static int Sections, Length, distance;
	public static Finch mainFinch = new Finch();
	public static void main(String args[]) 
	throws Exception 
	{
		//list for sections valid numbers
		ArrayList<Integer> SectionsValidNo = new ArrayList<Integer>(5);
		SectionsValidNo.add(2);
		SectionsValidNo.add(4);
		SectionsValidNo.add(6);
		SectionsValidNo.add(8);
		SectionsValidNo.add(10);

		//start the program UI
		
		int StartProgram = JOptionPane.showConfirmDialog(null,"Would you like to start the program?");
		if(StartProgram == JOptionPane.YES_OPTION)
		{
			//runs program if yes selected	
		}
		else 
		{
			//terminates program if no/cancel selected
			System.exit(0); 
		}
		JOptionPane.showMessageDialog(null, "Please place the finch on the ground level at a 45 degree angle to the right ");

		// sections input & exception handling (UI)
		do
		{
			try 
			{
				Sections = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of sections of the zigzag [value must not exceed 10 & must be an even number] : "));

				if (SectionsValidNo.contains(Sections)==true) 
				{

					break;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "ERROR: value must not exceed 10 & must be an even number", "ERROR: Invalid Value", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Please input a valid integer ", "ERROR: Invalid Value", JOptionPane.ERROR_MESSAGE);
			}
		}
		while (SectionsValidNo.contains(Sections)==false);
		JOptionPane.showMessageDialog(null, "Great, one more step! ");

		// length input & exception handling (UI)
		do 
		{
			try 
			{
				Length = Integer.parseInt(JOptionPane.showInputDialog("Please enter the length of each section [value must be between 20-80 (cm)] : "));
				if (Length<=80 && Length >=20) 
				{
					distance = Length;
					break;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "ERROR: value must be between 20-80 (cm) ", "ERROR: Invalid Value", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Please input a valid integer ", "ERROR: Invalid Value", JOptionPane.ERROR_MESSAGE);
			}
		}
		while (Length>80 || Length <20);

		//Finch Level (Algorithm 1)
		FinchLevel.mainFinchLevel();
		//Zigzag Movement (Algorithm 2/3/4/5)
		Movement.MovementFinch(distance);
	}
}
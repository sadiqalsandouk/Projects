import javax.swing.JOptionPane; 
public class FinchLevel
{
	public static void mainFinchLevel()
	{
		// to start the program, finch must be level on the floor		
		while (Zigzag.mainFinch.isFinchLevel() == false)
		{
			JOptionPane.showMessageDialog(null, "Please ensure finch is level on the floor. ");
		} 
		if (Zigzag.mainFinch.isFinchLevel() == true) 
		{
			//do nothing
		}
	}
}
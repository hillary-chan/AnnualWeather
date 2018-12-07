/**
 * Purpose: To store weather information about a designated city over the course of 12 months in arrays and allow the 
 * user to choose the temperature and precipatation scales as they see fit. 
 * 
 * @author Hillary Hemry
 * @version 11/30/2018
 *
 */
import java.util.Scanner;
public class AnnualWeatherV1
{
    public static void main (String [ ] args)
    {

        //Declare and initialize variables
        Scanner in = new Scanner(System.in);
        String city = "Orlando";
        String state = "Florida";
  
        String [] month = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."}; 
        double [] temp ={60.9, 62.6, 67.4, 71.5, 77.1, 81.2, 82.4, 82.5, 81.1, 75.3, 68.8, 63.0};        //initialize with Fahrenheit values
        double [] precipitation ={2.4, 2.4, 3.5, 2.4, 3.7, 7.4, 7.2, 6.3, 5.8, 2.7, 2.3, 2.3};      //initialize with inch values
    
        String fahrenheit = "F";    //fahrenheit
        String celcius = "C";       //celcius
        String inches = "in."; //inches
        String centimeter = "cm"; //centimeters
        String tempChoice = "";
        String lengthChoice = "";
        String tempUnit = "";
        String precipUnit = "";
        
        double sumPrecip = 0;
        double sumTemp = 0;
        double averageTemp = 0;
        
        /*Have user choose temperature scale (fahrenheit/celcius)
        and precipatation length (in/cm) */
        System.out.println("Choose the temperature scale ( F = Fahrenheit, C = Celcius): ");
        tempChoice = in.nextLine();
        System.out.println("Choose the precipatation scale (I = inches, CM = centimeters): ");
        lengthChoice = in.nextLine();
        
        //If user chooses fahrenheit
        if (tempChoice.equalsIgnoreCase("F")) 
        {
            tempUnit = "F";
        }
        
        //If user choose celcius, convert array data 
        else if (tempChoice.equalsIgnoreCase("C"))
        {
            tempUnit = "C";
            for (int i=0; i<12; i++)
            {
                temp[i] = temp[i] - 32; 
                temp[i] = (.555) * (temp[i]);
                temp[i] = ((temp[i] * 10)); 
                temp[i] = ((int)temp[i]);
                temp[i] = temp[i] / 10; 
            }
        }
        
        //If user chooses inches
        if(lengthChoice.equalsIgnoreCase("I"))
        {
            precipUnit = "in."; 
        }
        else if(lengthChoice.equalsIgnoreCase("CM"))
        {
            precipUnit = "cm"; 
            for(int i=1; i<12; i++)
            {
                precipitation[i] = precipitation[i] * 2.54;
                precipitation[i] = precipitation[i] * 10;
                precipitation[i] = ((int)precipitation[i]); 
                precipitation[i] = precipitation[i] / 10; 
            }
        }
                
        //Processing - calculate average temperature and total precipitation
        for( int index = 0; index < temp.length; index++)
        {
            sumPrecip += precipitation[index];
            sumTemp += temp[index];
            averageTemp = sumTemp / temp.length;
        }
    
        //Output: display table of weather data including average and total
        System.out.println();
        System.out.printf("%35s\n","Weather Data");
        System.out.printf("%45s\n", "Location: " + city +", " + state);
        System.out.printf("%8s%18s%24s\n","Month", "Temperature (" +  tempUnit + ")","Precipitation (" + precipUnit + ")");
        System.out.println();
        System.out.println("***************************************************");
        for( int index = 0; index < temp.length; index++)
        {
            System.out.printf("%8s%13s%20s\n", month[index], temp[index], precipitation[index]);  
  
        }
        System.out.println("***************************************************"); 
        System.out.printf("%8s%18s\n", "Average: " + averageTemp, "Annual: " + sumPrecip);

    }//end main
}//end class


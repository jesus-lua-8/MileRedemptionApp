package sample;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*********************************************************************
 *                                                                   *
 *  This class will handle the miles and destinations read from a    *
 *  file and information will be sorted to determine what tickets    *
 *  are available from economy class to first class.                 *
 *                                                                   *
 ********************************************************************/
public class MileRedeemer
{

    Destination destination;
    private int remainingMiles;

    ArrayList<Destination> destinationList = new ArrayList<Destination>();

/*********************************************************************
 *                                                                   *
 *  readDestinations takes an scanner object and uses it to read the *
 *  file passed in from the user. Once the file has been read, the   *
 *  data per departure will be split and stored in an array.         *
 *                                                                   *
 ********************************************************************/
    public void readDestinations(Scanner fileScanner)
    {
        String destinationRecord;   //From input will contain full string

        destination = new Destination();
        
        while(fileScanner.hasNext())
        {
            destinationRecord = fileScanner.nextLine();
            String[] substrings = destinationRecord.split(";",5);
            String[] substringsTwo = substrings[4].split("-",2);
            //substrings = substrings[4].split("-",2);

            destinationList.add( new Destination(substrings[0],Integer.parseInt(substrings[1]) ,Integer.parseInt(substrings[2])
            ,Integer.parseInt(substrings[3]),Integer.parseInt(substringsTwo[0]),Integer.parseInt(substringsTwo[1])));
        }
        fileScanner.close();

        Destination[] destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);

        Arrays.sort(destinationArray, new MileageComparator()); //Sorts the array based on Normal Miles.
        
    }

/*********************************************************************
 *                                                                   *
 *  getCityNames will extract the city names from the array which    *
 *  is storing the data from file. A string array will be returned   *
 *  will all the city names.                                         *
 *                                                                   *
 ********************************************************************/
    public String[] getCityNames()
    {
        
        String cityNames[] = new String[9];    //cityNames will contain the city names only.
        Destination[] destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);
        
        for(int i = 0; i < destinationArray.length;i++)
        {
            cityNames[i] = destinationArray[i].getDestinationName();
        }

        Arrays.sort(cityNames);

        return cityNames;
    }

/*********************************************************************
 *                                                                   *
 *  redeemMiles will take two paramemter the miles and month.        *
 *  The miles will be used to determine which flights will the user  *
 *  be able to take and with remaining miles the user will be        *
 *  prompted and option for upgrade to first class. The month will   *
 *  determine if the user qualifies for off season discount.         *
 *                                                                   *
 ********************************************************************/
    public String[] redeemMiles(int miles, int month)
    {

        Destination[] destinationArray = (Destination[]) destinationList.toArray(new Destination[destinationList.size()]);

        ArrayList<String> mileageArray = new ArrayList<String>();
        Arrays.sort(destinationArray, new MileageComparator()); //Sorts the array based on Normal Miles
        int mileChecker;

        for(int j = 0; j < destinationArray.length; j++)
        {
            if((destinationArray[j].getStartMonth() <= month) && (month <= destinationArray[j].getEndMonth()))
            {
                if(miles >= destinationArray[j].getOffSeasonM())
                {
                    miles = miles - destinationArray[j].getOffSeasonM();
                    mileageArray.add(destinationArray[j].getDestinationName());
                }
            }
            else
            {
                if(miles >= destinationArray[j].getNormalMiles())
                {
                    miles = miles - destinationArray[j].getNormalMiles();
                    mileageArray.add(destinationArray[j].getDestinationName());
                }
            }
        }
        remainingMiles = miles;
        mileChecker = miles;

        if(mileageArray.isEmpty())
        {
            mileageArray.add("*** Your client has not accumulated Frequent Flyer Miles ***");
        }
        else
        {
            for(int i = 0; i < destinationArray.length;i++)
            {
                if(miles >= destinationArray[i].getFirstClassUpgrade())
                {
                    for(int j = 0; j < mileageArray.size(); j++)
                    {
                        if(mileageArray.get(j).equals(destinationArray[i].getDestinationName()))
                        {
                            miles = miles - destinationArray[i].getFirstClassUpgrade();
                            mileageArray.set(j,destinationArray[i].getDestinationName() + " in First Class");
                        }
                        else{
                            mileageArray.set(j,mileageArray.get(j) + " in Economy Class");
                        }
                    }
                    remainingMiles = miles;
                }
            }
        }
        if(mileChecker == remainingMiles)
        {
                for(int j = 0; j < mileageArray.size(); j++)
                {
                    if(mileageArray.get(j).length() >= 55){
                        break;
                    }
                    else{
                        mileageArray.set(j,mileageArray.get(j) + " in Economy Class");
                    }

                }

        }
        String[] mileageArrayTwo = new String[mileageArray.size()];
        mileageArray.toArray(mileageArrayTwo);

        return mileageArrayTwo;
    }

/*********************************************************************
 *                                                                   *
 *  getRemainingMiles will return the miles that remain after choosen*
 *  longest and available flights.                                   *
 *                                                                   *
 ********************************************************************/
    public int getRemainingMiles(){
        return remainingMiles;
    }

    /*********************************************************************
     *                                                                   *
     * getDestinationArr will return an ArrayList of Destination objects.*
     *                                                                   *
     ********************************************************************/
    public ArrayList<Destination> getDestinationArr()
    {
        return destinationList;
    }


}
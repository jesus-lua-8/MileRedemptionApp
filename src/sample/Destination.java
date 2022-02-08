package sample;

/*********************************************************************
 *                                                                   *
 *  Destination class will created instance variables as well with   *
 *  set and get methods for access to the data for other classes to  *
 *  use.                                                             *
 *                                                                   *
 ********************************************************************/
public class Destination {
        private String destinationName;
        private int ticket;
        private int offSeasonM;
        private int firstClassUpgrade;
        private int startMonth;
        private int endMonth;

/*********************************************************************
 *                                                                   *
 *  Destination is a constructor that will initialize the variables. *
 *                                                                   *
 ********************************************************************/
    Destination()
    {
        destinationName = "";
        ticket = 1;
        offSeasonM = 1;
        firstClassUpgrade = 1;
        startMonth = 1;
        endMonth = 1;
    }

/*********************************************************************
 *                                                                   *
 *  Destination constructor will take 6 parameters, the name of the  *
 *  destination, the normal miles, the off season miles, miles       *
 *  for upgrading to first class, starting month of season and ending*
 *  month of the season. The parameters will initalize the instance  *
 *  variables.                                                       *
 *                                                                   *
 ********************************************************************/
    Destination(String name, int ticket, int offSeason, int upgrade,int sM,int eM)
    {
        destinationName = name;
        this.ticket = ticket;
        this.offSeasonM = offSeason;
        firstClassUpgrade = upgrade;
        startMonth = sM;
        endMonth = eM;
    }

/*********************************************************************
 *                                                                   *
 *  setDestinationName will set the name to the instance variable    *
 *  destinationName.                                                 *
 *                                                                   *
 ********************************************************************/
    public void setDestinationName(String name)
    {
        destinationName = name;
    }

/*********************************************************************
 *                                                                   *
 *  setNormalMiles will set the normal miles intance variable ticket *
 *                                                                   *
 ********************************************************************/
    public void setNormalMiles(int ticket){
        this.ticket = ticket;
    }

/*********************************************************************
 *                                                                   *
 *  setOffSeasonM will set the off season miles to the instance      *
 *  variable offSeasonM.                                             *
 *                                                                   *
 ********************************************************************/    
    public void setOffSeasonM(int offSeasonM)
    {
        this.offSeasonM = offSeasonM;
    }

/*********************************************************************
 *                                                                   *
 *  setFirstClassUpgrade will set the miles to first class upgrade   *
 *  to the instance variable fistClassUpgrade.                       *
 *                                                                   *
 ********************************************************************/    
    public void setFirstClassUpgrade(int upgrade)
    {
        firstClassUpgrade = upgrade;
    }

/*********************************************************************
 *                                                                   *
 *  setStartMonth will set the starting month of the off season to   *
 *  the instance variable startMonth.                                *
 *                                                                   *
 ********************************************************************/    
    public void setStartMonth(int startM){
        startMonth = startM;
    }

/*********************************************************************
 *                                                                   *
 *  setEndMonth will set the ending month of the off season to the   *
 *  instance variable endMonth.                                      *
 *                                                                   *
 ********************************************************************/
    public void setEndMonth(int endM){
        endMonth = endM;
    }

/*********************************************************************
 *                                                                   *
 *  getDestiantionName will return the destination name.             *
 *                                                                   *
 ********************************************************************/
    public String getDestinationName()
    {
        return destinationName;
    }

/*********************************************************************
 *                                                                   *
 *  getNormalMiles will return an integer representing normal miles. *
 *                                                                   *
 ********************************************************************/    
    public int getNormalMiles(){
        return ticket;
    }

/*********************************************************************
 *                                                                   *
 *  getOffSeasonM will return an integer representing the off season *
 *  mileage.                                                         *
 *                                                                   *
 ********************************************************************/    
    public int getOffSeasonM(){
        return offSeasonM;
    }

/*********************************************************************
 *                                                                   *
 *  getFirstClassUpgrade will return an integer representing the     *
 *  upgrade first class miles.                                       *
 *                                                                   *
 ********************************************************************/    
    public int getFirstClassUpgrade(){
        return firstClassUpgrade;
    }

/*********************************************************************
 *                                                                   *
 *  getStartMonth will return an integer representing the start month*
 *  of the season.
 *                                                                   *
 ********************************************************************/    
    public int getStartMonth(){
        return startMonth;
    }

/*********************************************************************
 *                                                                   *
 *  getEndMonth will return an integer representing the end month of *
 *  the season.                                                      *
 *                                                                   *
 ********************************************************************/
    public int  getEndMonth(){
        return endMonth;
    }
}

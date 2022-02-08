package sample;
import java.util.Comparator;

/*********************************************************************
 *                                                                   *
 *  MileageComparator will compare the elements of the Destination   *
 *  class for future usage of sorting. The different will be         *
 *  calculated and then returned.                                    *
 *                                                                   *
 ********************************************************************/
public class MileageComparator implements Comparator<Destination>{
    @Override
    public int compare(Destination d1, Destination d2)
    {
        return (d2.getNormalMiles() - d1.getNormalMiles());
    }
}

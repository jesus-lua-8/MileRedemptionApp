package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/*******************************************************************
 *                                                                 *
 * This class will be in charge of controlling the GUI and output  *
 * settings in the user interface.                                 *
 *                                                                 *
 ******************************************************************/
public class Controller implements Initializable {



    String[] monthList = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    @FXML public TextField remainingMiles;      //will contain the customers remaining miles
    @FXML public Button redeemMiles;            //The button that will initiate the calculations
    @FXML public TextField NormalMiles;         //Nomral miles of the flight per location
    @FXML public TextField SupersaverMiles;     //Miles that can be saved if flight within season time
    @FXML public TextField upgradeMiles;        //Miles to upgrade to first class
    @FXML public TextField saverDates;          //Will take the month in which the user wishes to travel
    @FXML public TextField enterMiles;          //Miles user has saved up
    @FXML public ChoiceBox<String> monthSelection;      //Choice box that will display the months
    ArrayList<Destination> destinationAR;       //Will contain the destination objects and information on all flights

    MileRedeemer redeemerVar = new MileRedeemer();

    private int Miles = 0;
    private int month = 0;

    @FXML
    private ListView<String> travelOptions;
    @FXML
    private ListView<String> destinationNames = new ListView<>();

    /*************************************************************
     *                                                           *
     * This function will get a copy of the string city names.   *
     *                                                           *
     ************************************************************/
    public void initializeArray(String[] cityNames) throws Exception
    {
        destinationNames.getItems().addAll(cityNames);
    }

    /*******************************************************************
     *                                                                 *
     * setMileRedeemerObject will copy an instance of an object        *
     * of MileRedeemer class.                                          *
     *                                                                 *
     ******************************************************************/
    public void setMileRedeemerObject(MileRedeemer obj)
    {
        redeemerVar = obj;
    }
    
    //It populates the choiceBox array with the months
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monthSelection.getItems().addAll(monthList);
    }

    /********************************************************************
     *                                                                  *
     * When the user clicks the mouse on the user interface then        *
     * on the text fields the instance variables will be displayed      *
     * with the information.                                            *
     *                                                                  *
     *******************************************************************/
    public void OnMouseClicked(MouseEvent mouseEvent) {

        final String[] enterMonth = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        for(int i = 0; i < destinationAR.size(); i++)
        {
            if(destinationAR.get(i).getDestinationName().equals(destinationNames.getSelectionModel().getSelectedItem().toString()))
            {
                NormalMiles.setText(Integer.toString(destinationAR.get(i).getNormalMiles()));
                SupersaverMiles.setText(Integer.toString(destinationAR.get(i).getOffSeasonM()));
                upgradeMiles.setText(Integer.toString(destinationAR.get(i).getFirstClassUpgrade()));
                saverDates.setText(enterMonth[destinationAR.get(i).getStartMonth()] + "-" +
                        enterMonth[destinationAR.get(i).getEndMonth()]);
            }
        }


    }

    /************************************************************************
     *                                                                      *
     * copyDestinationArray gets a copy of an Array List of objects of the  *
     * Destiantion class.                                                   *
     *                                                                      *
     ***********************************************************************/
    public void copyDestinationArray(ArrayList<Destination> destinationArr)
    {
        destinationAR = destinationArr;
    }

    /***************************************************************************
     *                                                                         *
     * onActionMiles will get the option from the choice box and as well as    *
     * the input of miles, then it will compute the travel options by calling  *
     * the mileRedeemer function. Results are displayed in a ListView.         *
     *                                                                         *
     **************************************************************************/
    public void onActionMiles(ActionEvent actionEvent) {
        String monthChosen;

        travelOptions.getItems().clear();

        Miles = Integer.parseInt(enterMiles.getText());

        monthChosen = monthSelection.getValue();

        switch(monthChosen){
            case "Jan":
                month = 1;
                break;
            case "Feb":
                month = 2;
                break;
            case "Mar":
                month = 3;
                break;
            case "Apr":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "Jun":
                month = 6;
                break;
            case "Jul":
                month = 7;
                break;
            case "Aug":
                month = 8;
                break;
            case "Sep":
                month = 9;
                break;
            case "Oct":
                month = 10;
                break;
            case "Nov":
                month = 11;
                break;
            case "Dec":
                month = 12;
                break;
        }

        travelOptions.getItems().addAll(redeemerVar.redeemMiles(Miles,month));
        remainingMiles.setText(Integer.toString(redeemerVar.getRemainingMiles()));
    }
}

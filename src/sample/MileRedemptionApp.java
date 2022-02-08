/************************************************************
 *  CSCI 470/502        Assignment 6        Summer 2020     *
 *                                                          *
 *  Developer(s): Jesus Lua                                 *
 *                                                          *
 *  Section:  1                                             *
 *                                                          *
 *  Due Date/Time:  7/30/2021   11:59 p.m                   *
 *                                                          *
 * This Application first opens a window allowing the user  *
 * to choose a file from their computer and will be open    *
 * that contains the                                        *
 * list of destinations with the miles of normal miles,     *
 * season miles, miles for upgrade to first class, and      *
 * starting month and ending month of seasons. Second the   *
 * GUI will open and display the list as destinations are   *
 * located the information will be displayed. Also customer *
 * miles will be asked and month they wish to travel and    *
 * remaining miles and flight options will be calculated.   *
 ***********************************************************/


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;


import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

/************************************************************
 *                                                          *
 * MileRedemptionApp class will open the files and then it  *
 * will open the user interface as it exetends Application  *
 * allow user interface.                                    *
 *                                                          *
 ***********************************************************/
public class MileRedemptionApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //creates a file chooser
        FileChooser f = new FileChooser();

        //set the title
        f.setTitle("Opening the location..");

        //open the dialog box

        File selectedFile = f.showOpenDialog(primaryStage);
        MileRedeemer obj = new MileRedeemer();
        InputStream stream = new FileInputStream(selectedFile.getAbsolutePath());
        Scanner scInput = new Scanner(stream);
        obj.readDestinations(scInput);

        scInput.close();

        HBox r = new HBox();
        r.setSpacing(20);

        //create scene
        Scene sc = new Scene(r, 350, 100);

        //set the scene
        primaryStage.setScene(sc);
        //set the title
        primaryStage.setTitle("Sample file chooser");
        //display the result
        primaryStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();


        //controller.getMileRedeemerObject(obj);

        primaryStage.setTitle("Mile Redemption App");
        primaryStage.setScene(new Scene(root, 508, 553));
        primaryStage.show();

        Controller controller = loader.getController();
        controller.initializeArray(obj.getCityNames());

        controller.copyDestinationArray(obj.getDestinationArr());
        controller.setMileRedeemerObject(obj);



    }


    public static void main(String[] args) {
        launch(args);
    }
}

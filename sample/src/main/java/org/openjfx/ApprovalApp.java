package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class ApprovalApp{
	//Used to get dependent and immigrant's info
    private DependentAddition selectedDependent;

    public void setDependent(DependentAddition dependent) {
        this.selectedDependent = dependent;
    }

    public void showApproval(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 600, 720);
        primaryStage.setScene(scene);
        primaryStage.show();

        Text scenetitle = new Text("Form Approval");
        scenetitle.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        GridPane.setConstraints(scenetitle, 0, 5);
        grid.getChildren().add(scenetitle);

        displayImmigrantInfo(grid);
        displayDependentInfo(grid);

        addButton(grid, "Accept Form", 60, this::acceptForm);
        addButton(grid, "Return Form", 56, this::returnForm);
    }

    private void displayImmigrantInfo(GridPane grid) {
        Label immigrantLabel = new Label("Immigrant Information:");
        immigrantLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        GridPane.setConstraints(immigrantLabel, 0, 10);
        grid.getChildren().add(immigrantLabel);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 15);
        grid.getChildren().add(nameLabel);

        Label alienNumLabel = new Label("Alien Number:");
        GridPane.setConstraints(alienNumLabel, 0, 20);
        grid.getChildren().add(alienNumLabel);

        /* Dependents DB not implemented yet
        Label nameValueLabel = new Label(selectedDependent.getApplicantName());
        GridPane.setConstraints(nameValueLabel, 1, 15);
        grid.getChildren().add(nameValueLabel);

        Label alienNumValueLabel = new Label(selectedDependent.getApplicantAlienNum());
        GridPane.setConstraints(alienNumValueLabel, 1, 20);
        grid.getChildren().add(alienNumValueLabel);*/
    }

    private void displayDependentInfo(GridPane grid) {
        Label dependentLabel = new Label("Dependent Information:");
        dependentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        GridPane.setConstraints(dependentLabel, 0, 25);
        grid.getChildren().add(dependentLabel);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 30);
        grid.getChildren().add(nameLabel);

        Label dobLabel = new Label("Date of Birth:");
        GridPane.setConstraints(dobLabel, 0, 35);
        grid.getChildren().add(dobLabel);

        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 40);
        grid.getChildren().add(addressLabel);

        Label alienNumLabel = new Label("Alien Number:");
        GridPane.setConstraints(alienNumLabel, 0, 45);
        grid.getChildren().add(alienNumLabel);

        /* Dependents DB not implemented yet
        Label nameValueLabel = new Label(selectedDependent.getName());
        GridPane.setConstraints(nameValueLabel, 1, 30);
        grid.getChildren().add(nameValueLabel);

        Label dobValueLabel = new Label(selectedDependent.getDateOfBirth());
        GridPane.setConstraints(dobValueLabel, 1, 35);
        grid.getChildren().add(dobValueLabel);

        Label addressValueLabel = new Label(selectedDependent.getAddress());
        GridPane.setConstraints(addressValueLabel, 1, 40);
        grid.getChildren().add(addressValueLabel);

        Label alienNumValueLabel = new Label(selectedDependent.getAlienNum());
        GridPane.setConstraints(alienNumValueLabel, 1, 45);
        grid.getChildren().add(alienNumValueLabel);
        */
    }

    private void addButton(GridPane grid, String buttonText, int row, EventHandler<ActionEvent> eventHandler) {
        Button button = new Button(buttonText);
        button.setOnAction(eventHandler);
        GridPane.setConstraints(button, 0, row);
        grid.getChildren().add(button);
    }

    private void acceptForm(ActionEvent event) {
        //send email to applicant
    }

    private void returnForm(ActionEvent event) {
        // send form to the reviewer screen
        
    }

   
}

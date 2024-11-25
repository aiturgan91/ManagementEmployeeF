package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class HelloController {

    @FXML
    private ToggleGroup employee;

    @FXML
    private RadioButton rbPermanent;

    @FXML
    private RadioButton rbPartTime;

    @FXML
    private RadioButton rbContractor;

    @FXML
    private TextField textName;
    @FXML
    private TextField textSurname;
    @FXML
    private TextField textPhonenumber;
    @FXML
    private TextField textPosition;

    @FXML
    private ListView<Employee> listView;

    DataBase database = new DataBase();

    ObservableList<Employee> emp = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(emp);
    }

    @FXML
   void buttonClick(){
        try{
            DataBase.connect();
            System.out.println("Connected..");
        }
        catch(SQLException e){
            System.out.println(e.toString());
        }
   }

    @FXML
    void onAddClick(ActionEvent event) {

        Employee newEmployee = null;
        if (rbPermanent.isSelected()) {
            newEmployee = new Permanent();
            newEmployee.setType(Employeetype.PERMANENT);
        } else if (rbPartTime.isSelected()) {
            newEmployee = new PartTime();
            newEmployee.setType(Employeetype.PARTTIME);
        } else if (rbContractor.isSelected()) {
            newEmployee = new Contractor();
            newEmployee.setType(Employeetype.CONTRACTOR);
        }

        if (newEmployee != null) {
            newEmployee.setName(textName.getText());
            newEmployee.setSurname(textSurname.getText());
            newEmployee.setPhonenumber(textPhonenumber.getText());
            newEmployee.setPosition(textPosition.getText());
            emp.add(newEmployee);

            try {
                DataBase.addEmployee(newEmployee);
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

            textName.clear();
            textSurname.clear();
            textPhonenumber.clear();
            textPosition.clear();



        } else {
            System.out.println("Please select an employee type.");
        }
    }

    @FXML
    protected void onListClicked(MouseEvent event, java.awt.Label label) {
        int id = listView.getSelectionModel().getSelectedIndex();
        if (id >= 0) {
            label.setText(emp.get(id).toString());
        }
    }

    @FXML
    private void onRemoveClick() {
        int id = listView.getSelectionModel().getSelectedIndex();
        if (id >= 0) {
            emp.remove(id);
        }
    }
}
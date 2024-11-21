package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    ObservableList<Employee> emp = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(emp);
    }

    @FXML
    void onAddClick(ActionEvent event) {
        Employee newEmployee = null;
        if (rbPermanent.isSelected()) {
            newEmployee = new Permanent();
        } else if (rbPartTime.isSelected()) {
            newEmployee = new PartTime();
        } else if (rbContractor.isSelected()) {
            newEmployee = new Contractor();
        }

        if (newEmployee != null) {
            newEmployee.setName(textName.getText());
            newEmployee.setSurname(textSurname.getText());
            newEmployee.setPhonenumber(Integer.parseInt(textPhonenumber.getText()));
            newEmployee.setPosition(textPosition.getText());
            emp.add(newEmployee);

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
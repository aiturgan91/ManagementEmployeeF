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
    private TextField textId;
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
        if (rbPermanent.isSelected()) {
            Permanent permanent = new Permanent();
            permanent.setName(textName.getText());
            permanent.setSurname(textSurname.getText());
            permanent.setPhonenumber(Integer.parseInt(textPhonenumber.getText()));
            permanent.setPosition(textPosition.getText());
            permanent.setType(Employeetype.PERMANENT);
            emp.add(permanent);
        }
        else if (rbPartTime.isSelected()) {
            PartTime partTime = new PartTime();
            partTime.setName(textName.getText());
            partTime.setSurname(textSurname.getText());
            partTime.setPhonenumber(Integer.parseInt(textPhonenumber.getText()));
            partTime.setPosition(textPosition.getText());
            partTime.setType(Employeetype.PARTTIME);
            emp.add(partTime);
        }
        else if (rbContractor.isSelected()) {
            Contractor contractor = new Contractor();
            contractor.setName(textName.getText());
            contractor.setSurname(textSurname.getText());
            contractor.setPhonenumber(Integer.parseInt(textPhonenumber.getText()));
            contractor.setPosition(textPosition.getText());
            contractor.setType(Employeetype.CONTRACTOR);
            emp.add(contractor);
        }
    }

    @FXML
    private Label label;

    @FXML
    protected void onListClicked() {
        int id = listView.getSelectionModel().getSelectedIndex();
        label.setText(emp.get(id).toString());
    }

    @FXML
    private void onRemoveClick() {
        int id = listView.getSelectionModel().getSelectedIndex();
        emp.remove(id);
    }
}

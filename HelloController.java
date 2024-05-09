package task.lab12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField contactNumberField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField deleteContactNumberField;
    @FXML
    private TableView<Contact> contactTable;
    @FXML
    private TableColumn<Contact, String> nameColumn;
    @FXML
    private TableColumn<Contact, String> contactNumberColumn;
    @FXML
    private TableColumn<Contact, String> emailColumn;
    @FXML
    private TextField EditNameField;
    @FXML
    private TextField EditContactNumberField;
    @FXML
    private TextField EditEmailField;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;

    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        contactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        contactTable.setItems(contacts);
    }

    @FXML
    protected void handleAddButtonAction() {
        String name = nameField.getText();
        String contactNumber = contactNumberField.getText();
        String email = emailField.getText();
        contacts.add(new Contact(name, contactNumber, email));
        nameField.clear();
        contactNumberField.clear();
        emailField.clear();
    }

    @FXML
    protected void handleDeleteButtonAction() {
        String contactNumber = deleteContactNumberField.getText();
        contacts.removeIf(contact -> contact.getPhone().equals(contactNumber));
        deleteContactNumberField.clear();
    }

    @FXML
    protected void handleEditButtonAction() {
        String contactNumber = EditContactNumberField.getText();
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(contactNumber)) {
                contact.setName(EditNameField.getText());
                contact.setEmail(EditEmailField.getText());
                break;
            }
        }
        EditNameField.clear();
        EditContactNumberField.clear();
        EditEmailField.clear();
    }

    @FXML
    protected void handleContactNumberEntered() {
        String contactNumber = EditContactNumberField.getText();
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(contactNumber)) {
                EditNameField.setText(contact.getName());
                EditEmailField.setText(contact.getEmail());
                break;
            }
        }
    }
}

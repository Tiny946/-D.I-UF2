package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
    }
}

/*
 * Este c�digo necesita cierta explicaci�n:

Los campos y m�todos donde el archivo fxml necesita acceso deben ser anotados con @FXML. En realidad, s�lo si son privados, pero es mejor tenerlos privados y marcarlos con la anotaci�n.
El m�todo initialize() es invocado autom�ticamente tras cargar el fxml. En ese momento, todos los atributos FXML deber�an ya haber sido inicializados..
El m�todo setCellValueFactory(...) que aplicamos sobre las columnas de la tabla se usa para determinar qu� atributos de la clase Person deben ser usados para cada columna particular. La flecha -> indica que estamos usando una caracter�stica de Java 8 denominada Lambdas. Otra opci�n ser�a utilizar un PropertyValueFactory, pero entonces no ofrecer�a seguridad de tipo (type-safe).
 
*/
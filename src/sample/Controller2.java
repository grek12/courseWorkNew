package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

import java.util.LinkedList;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;


public class Controller2 {
    @FXML
    private TableView<Realtor> tableRealtors;

    @FXML
    private TableColumn<Realtor, String> surname;

    @FXML
    private TableColumn<Realtor, String> phoneNumber;

    @FXML
    private TableColumn<Realtor, Float> sumPrice;

    @FXML
    private TableView<Client> tableClients;

    @FXML
    private TableColumn<Client, String> surnameClient;

    @FXML
    private TableColumn<Client, Float> price;

    @FXML
    private TextField txtRealtorName;

    @FXML
    private TextField txtRealtorPhone;

    @FXML
    private TextField txtClientName;

    @FXML
    private Label sumAgentstvo;

    @FXML
    private TextField txtClientPrice;
    private ObservableList<Realtor> data = FXCollections.observableArrayList();
    private ObservableList<Client> data2 = FXCollections.observableArrayList();
    Agency agency = new Agency();

    @FXML
    public void addTable1() {
        sumAgentstvo.setText("Сумма сделок агенства: " + agency.getSumAgency());
        initData();
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("numberPhone"));
        sumPrice.setCellValueFactory(new PropertyValueFactory<>("priceSum"));
        tableRealtors.setItems(data);
    }

    private void initData() {
        data.setAll(agency.getRealtor());
    }

    @FXML
    public void addTable2() {
        initData2();
        surnameClient.setCellValueFactory(new PropertyValueFactory<>("surnameClient"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableClients.setItems(data2);
        addTable1();
    }

    private void initData2() {
        data2.setAll(agency.getRealtorr(getvalue()).getClient());
    }

    public void exitBut() {//метод выхода из программы(кнопка выход)
        System.exit(1);
    }

    public void nullProblem() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Не заполнены поля!");
        alert.setContentText("Поля не заполнены, заполните необходимые поля и повторите попытку!");
        alert.showAndWait();
    }

    public void showProblem2() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Не выбран риелтор!");
        alert.setContentText("Риелтор не выбран, выберите риелтора в таблице и повторите попытку!");
        alert.showAndWait();
    }

    public void showProblem3() {//метод вывода ошибки
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Ошибка!");
        alert.setHeaderText("Не выбран клиент!");
        alert.setContentText("Клиент не выбран, выберите клиента в таблице и повторите попытку!");
        alert.showAndWait();
    }
    public int getvalue() {//метод получения данных выбранной строки
        if (agency.getRealtorCount() != 0) {
            int row = tableRealtors.getSelectionModel().getSelectedIndex();
            if (row == -1) {
                showProblem2();
            } else {
                String a = tableRealtors.getColumns().get(0).getCellObservableValue(row).getValue().toString();
                int pos = tableRealtors.getSelectionModel().getSelectedIndex();
                return pos;
            }
        }
        return (-1);
    }

    public int getvalue2() {//метод получения данных выбранной строки
        if (agency.getRealtorr(getvalue()).getClientCount() != 0) {
            int row = tableClients.getSelectionModel().getSelectedIndex();
            if (row == -1) {
                showProblem3();
            } else {
                String a = tableClients.getColumns().get(0).getCellObservableValue(row).getValue().toString();
                int pos = tableRealtors.getSelectionModel().getSelectedIndex();
                return pos;
            }
        }
        return (-1);
    }

    public void addRealtor() {//метод добавления риелтора до(кнопка добавить(до) клиента)
        if ((txtRealtorName.getText().trim().isEmpty()) || (txtRealtorPhone.getText().trim().isEmpty())) {
            nullProblem();
        } else {
            agency.addRealtor(txtRealtorName.getText(), txtRealtorPhone.getText());
        }
        txtRealtorName.clear();
        txtRealtorPhone.clear();
    }

    public void txtSetting() {//метод ограничения ввода символов
        txtRealtorPhone.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isDigit(input) != true) {
                e.consume();
            }
            if (txtRealtorPhone.getText().length() >= 11) {
                e.consume();
            }
        });
    }

    public void txtSetting3() {
        txtClientPrice.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) == true) {
                e.consume();
            }
            if (".0123456789".contains(e.getCharacter()) != true) {
                e.consume();
            }
        });
    }

    public void txtSetting2() {//метод ограничения ввода символов
        txtRealtorName.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) != true) {
                e.consume();
            }
        });
        txtClientName.setOnKeyTyped(e -> {
            char input = e.getCharacter().charAt(0);
            if (isLetter(input) != true) {
                e.consume();
            }
        });
    }

    public void showClient() {//метод вывода клиентов выбранного риелтора
        LinkedList<Client> temp = agency.getRealtorr(getvalue()).getClient();
        if (temp == null) {
            tableClients.getItems().clear();
        } else {
            addTable2();
        }
    }

    @FXML
    public void clickItem() {//метод выбора риелтора
        if(agency.getRealtorCount()!=0) {
            tableRealtors.setOnMouseClicked(event -> {
                showClient();
            });
        }
    }

    public void removeRealtor() {
        if(getvalue()!=(-1)) {


            agency.removeRealtor(getvalue());
            addTable1();
            tableClients.getItems().clear();
        }
    }

    public void cleanTable() {//метод очистки таблиц(удаления риелторов и его клиентов)
        agency.removeAll();
        sumAgentstvo.setText("Сумма сделок агентства: "+agency.getSumAgency());
        tableRealtors.getItems().clear();
        tableClients.getItems().clear();

    }

    public void removeClient() {//метод удаления клиента(кнопка удалить клиента)
        if(getvalue2()!=-1){
        agency.getRealtorr(getvalue()).removeClient(getvalue2());
        addTable2();}

    }

    public void addClient() {
        if ((txtClientName.getText().trim().isEmpty()) || (txtClientPrice.getText().trim().isEmpty())) {
            nullProblem();
        } else {
            agency.getRealtorr(getvalue()).addClient(txtClientName.getText(), Float.parseFloat(txtClientPrice.getText()));
        }
        txtClientName.clear();
        txtClientPrice.clear();
    }

    public void saveFile(){

    }

}
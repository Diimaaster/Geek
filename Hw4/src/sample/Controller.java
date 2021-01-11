package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private ListView listView;

    //private final ObservableList<String> wordList = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
    // listView.setItems(wordList);
    }

    public boolean flag = true;

    @FXML
    public void addWordToList(){
        String word = inputField.getText();
        if(word.isBlank()){
            show();
        }else {
            if (flag) {
                listView.getItems().add("Я: " + word);
                flag=!flag;
            }else{
                listView.getItems().add("Кто-то : " + word);
                flag=!flag;
            }
        }
        inputField.clear();
    }

    @FXML
    public void show(){
        Alert alert =new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Внимание!");
        alert.setHeaderText("Ошибка ввода");
        alert.setContentText("Нельзя вводить пустое сообщение");
        alert.showAndWait();
        return;
    }
}

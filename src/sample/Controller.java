package sample;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Controller {
    public void openNewWin() throws Exception{
        Windows2 windows2 = new Windows2();
    }
    public void helpBut(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Информация");
        alert.setHeaderText("Справка о программе");
        alert.setContentText("\nОбъектная-программа «Риелторское агентство».\n" +
                "Данная программа хранит и обрабатывает данные о договорах купли/продажи недвижимости в риелторском агентстве. Учет организуется за счет ведения списка риэлторов с указанием фамилии и номера мобильного телефона. Для каждого риелтора создается отдельный список договоров с указанием фамилии клиента и суммы сделки.\n" +
                "Выполнил: Долгов Александр Сергеевич.");

        alert.showAndWait();
    }
    public void exitBut (){
        System.exit(1);
    }
}

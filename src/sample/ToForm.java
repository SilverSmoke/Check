package sample;

import javafx.scene.control.TextArea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by belikov.a on 07.02.2017.
 */
public class ToForm {

    /*@FXML
    private static TextArea screen;*/


    public static void groupFree(ResultSet resultSet, TextArea screen){

        Double sum = .0;

        try {

            while(resultSet.next()){

                sum += Double.parseDouble(resultSet.getString(5));

                screen.appendText(outString(resultSet) + "\n");

            }

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tОбщий итог:\t" + sum + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void groupByDay(ResultSet resultSet, TextArea screen){

        Double sumDay = .0;
        Double sum = .0;

        try {

            resultSet.next();

            int day = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear();

            resultSet.beforeFirst();


            while(resultSet.next()){

                if(LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear() != day){

                    screen.appendText("=============================================================================================" +

                            "\n\t\t\t\t\t\t\t\t\t\tИтог:\t" + sumDay + "\n");

                    screen.appendText("=============================================================================================" + "\n");

                    sum += sumDay;

                    sumDay = .0;

                    day = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear();
                }

                sumDay += Double.parseDouble(resultSet.getString(5));

                screen.appendText(outString(resultSet) + "\n");

            }

            sum += sumDay;

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tИтог:\t" + sumDay + "\n");

            screen.appendText("=============================================================================================" + "\n");

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tОбщий итог:\t" + sum + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void groupByMont(ResultSet resultSet, TextArea screen){

        Double sumMonth = .0;
        Double sum = .0;

        try {

            resultSet.next();

            Month month = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getMonth();

            resultSet.beforeFirst();


            while(resultSet.next()){

                if(LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getMonth() != month){

                    screen.appendText("=============================================================================================" +

                            "\n\t\t\t\t\t\t\t\t\t\tИтог:\t" + sumMonth + "\n");

                    screen.appendText("=============================================================================================" + "\n");

                    sum += sumMonth;

                    sumMonth = .0;

                    month = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getMonth();
                }

                screen.appendText(outString(resultSet) + "\n");

                sumMonth += Double.parseDouble(resultSet.getString(5));

                //System.out.println(day+":::"+LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear());

            }

            sum += sumMonth;

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tИтог:\t" + sumMonth + "\n");

            screen.appendText("=============================================================================================" + "\n");

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tОбщий итог:\t" + sum + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String outString(ResultSet resultSet){

        String string = "";

        try {
            string = resultSet.getString(1);

            string += addSpace(resultSet.getString(1), 10);

            string += resultSet.getString(2);

            string += addSpace(resultSet.getString(2), 20);

            string += resultSet.getString(3);

            string += addSpace(resultSet.getString(3), 20);

            string += resultSet.getString(4);

            string += addSpace(resultSet.getString(4), 20);

            string += resultSet.getString(5);

            string += "\t\t";

            string += LocalDate.ofEpochDay(resultSet.getLong(6) / 86400);

        }catch (SQLException e){

            e.printStackTrace();

        }

        return string;

    }

    private static String addSpace(String string, int col){

        int colDo = 0;

        if(string.length()%4 > 0)colDo = 1;

        colDo += (col - string.length())/4;

        string = "";

        for(int i = 0; i < colDo; i++){

            string += "\t";

        }

        return string;

    }

}

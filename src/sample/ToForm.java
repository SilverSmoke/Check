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

                //int day = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfMonth();

                String string = resultSet.getString(1);

                string += "\t\t";

                string += resultSet.getString(2);

                string += "\t\t";

                string += resultSet.getString(3);

                string += "\t\t";

                string += resultSet.getString(4);

                string += "\t\t";

                string += resultSet.getString(5);

                string += "\t\t";

                string += LocalDate.ofEpochDay(resultSet.getLong(6) / 86400);

                sumDay += Double.parseDouble(resultSet.getString(5));

                screen.appendText(string + "\n");

                System.out.println(day+":::"+LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear());

            }

            if(sum == 0.0)sum = sumDay;

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

                //int day = LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfMonth();

                String string = resultSet.getString(1);

                string += addSpace(resultSet.getString(1), 10) + "\t\t";

                string += resultSet.getString(2);

                string += addSpace(resultSet.getString(2), 20) + "\t\t";

                string += resultSet.getString(3);

                string += addSpace(resultSet.getString(3), 20) + "\t\t";

                string += resultSet.getString(4);

                string += addSpace(resultSet.getString(4), 20) + "\t\t";

                string += resultSet.getString(5);

                string += "\t\t";

                string += LocalDate.ofEpochDay(resultSet.getLong(6) / 86400);

                sumMonth += Double.parseDouble(resultSet.getString(5));

                screen.appendText(string + "\n");

                //System.out.println(day+":::"+LocalDate.ofEpochDay(resultSet.getLong(6) / 86400).getDayOfYear());

            }

            if(sum == 0.0)sum = sumMonth;

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tИтог:\t" + sumMonth + "\n");

            screen.appendText("=============================================================================================" + "\n");

            screen.appendText("=============================================================================================" +

                    "\n\t\t\t\t\t\t\t\t\t\tОбщий итог:\t" + sum + "\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static String addSpace(String string, int col){



        col = (col - string.length())/4;
        System.out.println(string);
        string = "";

        for(int i = 0; i < col; i++){
            string += "\t";
        }

        return string;

    }

}

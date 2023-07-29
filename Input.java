import java.util.Scanner;

public class Input {
   public String[] inputData(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Введите строку через пробел (Фамилия, Имя, Отчество, дата рождения(dd.mm.yyyy), номер телефона, пол (f/m)): ");
            String data = sc.nextLine();
            String[] arrData = data.split(" ");
            if (arrData.length == 6) return arrData;
            if (arrData.length < 6) System.out.println("Вы ввели мало данных");
            if (arrData.length > 6) System.out.println("Вы ввели много данных");
        }
    }
}
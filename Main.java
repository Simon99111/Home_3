import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Check checkData = new Check(); 
        String newFileName = null; 
        Write writeFile = new Write();

        HashMap<String, Object> data = checkData.checkInputData(); 
        while (data.size() != 6) {
            try {
                throw new ExceptionData();
            } catch (ExceptionData e) {
                data = checkData.checkInputData();
            }
        } 

        newFileName = data.get("Surname") + ".txt"; 
        StringBuilder sb = new StringBuilder();
            sb.append(data.get("Surname"));
            sb.append(" ");
            sb.append(data.get("First name"));
            sb.append(" ");
            sb.append(data.get("Patronymic"));
            sb.append(" ");
            sb.append(data.get("Date"));
            sb.append(" ");
            sb.append(data.get("Number"));
            sb.append(" ");
            sb.append(data.get("Sex"));
            sb.append(" ");


        System.out.println(data);
        String filePath = newFileName;
        System.out.println(filePath);
        writeFile.writeData(String.valueOf(sb), filePath); 

    }
}
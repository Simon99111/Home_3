import java.util.HashMap;

public class Check {

    public HashMap<String, Object> checkInputData() {
        Input inputData = new Input();
        String[] data = inputData.inputData();
        HashMap<String, Object> dataDic = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataDic.put("Sex", i);
                } else{
                    try {
                        throw new ExceptionSex();
                    } catch (ExceptionSex e) {
                        e.exceptionSex(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");
                boolean flag = true;
                if (Integer.parseInt(arrayDate[0]) < 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 2022) {
                    try {
                        throw new ExceptionDate();
                    } catch (ExceptionDate e) {
                        e.exceptionDate(i);
                    }
                } else {
                    if (Integer.parseInt(arrayDate[2]) % 4 == 0) {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 30) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayDate[1]) == 1 ||
                                Integer.parseInt(arrayDate[1]) == 3 ||
                                Integer.parseInt(arrayDate[1]) == 5 ||
                                Integer.parseInt(arrayDate[1]) == 7 ||
                                Integer.parseInt(arrayDate[1]) == 9 ||
                                Integer.parseInt(arrayDate[1]) == 10 ||
                                Integer.parseInt(arrayDate[1]) == 12) {
                            if (Integer.parseInt(arrayDate[0]) < 32) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[2]) == 2) {
                            if (Integer.parseInt(arrayDate[0]) < 29) {
                                flag = false;
                            }
                        } else if (Integer.parseInt(arrayDate[1]) == 4 ||
                                Integer.parseInt(arrayDate[1]) == 6 ||
                                Integer.parseInt(arrayDate[1]) == 8 ||
                                Integer.parseInt(arrayDate[1]) == 11) {
                            if (Integer.parseInt(arrayDate[0]) < 31) {
                                flag = false;
                            }
                        }

                    }
                    if (!flag) {
                        dataDic.put("Date", i);
                    } else try {
                        throw new ExceptionData();
                    } catch (ExceptionData e) {
                        e.exceptionData(i);
                    }
                }

            } else if (i.matches("[0-9]+")) {
                dataDic.put("Number", i);
            } else if (i.matches("[A-Za-z]+")) {
                sb.append(i + " ");
            } else {
                try {
                    throw new ExceptionData();
                } catch (ExceptionData e) {
                    e.exceptionData(i);
                }
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3) {
            dataDic.put("Surname", fullName[0]);
            dataDic.put("First name", fullName[1]);
            dataDic.put("Patronymic", fullName[2]);
        }
        return dataDic;
    }

}
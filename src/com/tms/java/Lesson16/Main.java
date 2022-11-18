package com.tms.java.Lesson16;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Logic logic = new Logic();
        Input input = new Input();
        View view = new View();

        //FIRST TASK
        view.outputStringToConsole("------------------------------First task------------------------------\n");
        String ipAddress = input.inputStringByScanner("Enter IP address: ");
        if(logic.checkIP(ipAddress)){
            view.outputStringToConsole("IP address is valid\n");
        } else {
            view.outputStringToConsole("IP address is invalid\n");
        }

        //SECOND TASK
        view.outputStringToConsole("------------------------------Second task-----------------------------\n");
        String pathToFiles = input.inputStringByScanner("Enter path to the txt files: ");
        int filesToCheckAmount = input.inputIntByScanner("Enter amount of files in folder to check: ");
        File folder = new File(pathToFiles);
        List<String> txtFiles = Arrays.stream(Objects.requireNonNull(folder.list()))
                .filter(fileName -> fileName.endsWith(".txt")).collect(Collectors.toList());
        int invalidFormatDocumentsAmount = (int) (Arrays.stream(Objects.requireNonNull(folder.list())).count() - txtFiles.size());

        if(txtFiles.size() == 0 && invalidFormatDocumentsAmount != 0){
            view.outputStringToConsole("There is no txt files in the folder!");
            filesToCheckAmount = 0;
        } else if(txtFiles.size() == 0 && invalidFormatDocumentsAmount == 0){
            view.outputStringToConsole("There is no files in the folder!");
            filesToCheckAmount = 0;
        }
        filesToCheckAmount = Math.min(filesToCheckAmount,txtFiles.size());

        Map<String, Document> log = new HashMap<>();
        for (int i = 0;i < filesToCheckAmount;i++) {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\TMS\\files\\Lesson16\\" + txtFiles.get(i)));
            String data;
            Document document = new Document();
            while ((data = reader.readLine()) != null) {
                    if(document.getEmail().equals("None")) document.setEmail(logic.checkEmail(data));
                    if(document.getPhoneNumber().equals("None")) document.setPhoneNumber(logic.checkPhoneNumber(data));
                    if(document.getDocumentNumber().equals("None")) document.setDocumentNumber(logic.checkDocumentNumber(data));
            }
            log.put(txtFiles.get(i).substring(0,txtFiles.get(i).length()-4), document);
        }
        for(Map.Entry<String, Document> element : log.entrySet()){
            view.outputStringToConsole("\nFile name: " + element.getKey() + "\n");
            view.outputStringToConsole("Document number: " + element.getValue().getDocumentNumber() + "\n");
            view.outputStringToConsole("Email: " + element.getValue().getEmail() + "\n");
            view.outputStringToConsole("Phone number: " + element.getValue().getPhoneNumber() + "\n");
        }
        view.outputStringToConsole("\nProcessed " + filesToCheckAmount + " files\n");
        view.outputStringToConsole("There are " + invalidFormatDocumentsAmount + " files with wrong format in the folder\n");
        view.outputStringToConsole("Work completed...");
    }
}

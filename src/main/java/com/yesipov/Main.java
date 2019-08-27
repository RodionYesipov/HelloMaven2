package com.yesipov;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Group group = new Group("java");
        group.addPerson(new Person("Alex", 22));
        group.addPerson(new Person("Ben", 33));

        //String json = gson.toJson(group);
        String json = readFromFile("test.txt");

        System.out.println();
        Group readGroup = gson.fromJson(json,Group.class);

        System.out.println(readGroup);

        //writeToFile(json, "test.txt");


    }

    private static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), string, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String fileName){
        try {
            String readFile = FileUtils.readFileToString(new File(fileName),"utf-8");
            return readFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

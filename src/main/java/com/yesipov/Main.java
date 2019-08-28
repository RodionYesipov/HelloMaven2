package com.yesipov;
/**
 1) Создать проект Maven.  В корень проекта положить текстовый файл с таким содержимым:
 {
 "name": "java",
 "persons": [
 {
 "name": "Alex",
 "age": 22
 },
 {
 "name": "Ben",
 "age": 33
 }
 ]
 }

 Распарсить этот JSON и вывести обьекты через println().
* */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Main {
    private static void writeToFile(String string, String fileName) {
        try {
            FileUtils.writeStringToFile(new File(fileName), string, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String fileName) {
        try {
            String readFile = FileUtils.readFileToString(new File(fileName), "utf-8");
            return readFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void serializeToXML(String fileName, Group group) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            //pretty print
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

            String output = xmlMapper.writeValueAsString(group);
            FileUtils.writeStringToFile(new File(fileName), output, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Gson gson = new Gson();

        Group group = new Group("java");
        group.addPerson(new Person("Alex", 22));
        group.addPerson(new Person("Ben", 33));

        //serialize to txt file
        String json = gson.toJson(group);
        writeToFile(json, "test.txt");

        //deserialize to object
        json = readFromFile("test.txt");
        Group readGroup = gson.fromJson(json, Group.class);
        System.out.println(readGroup);

        //serialize to XML file
        serializeToXML("testXML.xml", group);
    }
}

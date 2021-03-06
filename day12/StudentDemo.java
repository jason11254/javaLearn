/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.ocp.day12;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author MB-study
 */
public class StudentDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\java\\com\\lab\\ocp\\day12\\exams.json");
        String json = new Scanner(file).useDelimiter("\\A").next();
        Gson gson = new Gson();
        Student[] students=gson.fromJson(json, Student[].class);
        System.out.println(students);
        // 請求出每人的總分各是多少 ?
        Stream.of(students).forEach(s -> {
            int sum = Stream.of(s.getExams()).mapToInt(e -> e.getScore()).sum();
            System.out.printf("%s %d\n", s.getName(), sum);
        });
        
        // 請求出總分最高的人名 ?
        int max = Stream.of(students)
                .mapToInt(s -> Stream.of(s.getExams()).mapToInt(e -> e.getScore()).sum())
                .summaryStatistics()
                .getMax();
        System.out.println(max);
        Stream.of(students)
                .filter(s -> Stream.of(s.getExams()).mapToInt(e -> e.getScore()).sum() == max)
                .forEach(s -> System.out.println(s.getName()));
    }
}

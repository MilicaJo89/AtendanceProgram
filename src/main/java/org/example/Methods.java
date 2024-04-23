package org.example;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Methods{

    public static void AllStudentsTableCall(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Students");

            while (resultSet.next()){
                String studentId=(resultSet.getString("student_id")+" ");
                String firstName=(resultSet.getString("first_name")+" ");
                String lastName=(resultSet.getString("last_name"));
                System.out.printf("%-3.3s  %-9.9s  %-12.12s%n",studentId , firstName,lastName);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
    }

    public static void AllClassesTableCall(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Classes");

            while (resultSet.next()){
                String classId=(resultSet.getString("class_id")+" ");
                String className=(resultSet.getString("clas_name")+" ");
                String teacherName=(resultSet.getString("teacher_name"));
                System.out.printf("%-3.3s  %-10.10s  %-10.10s%n",classId , className,teacherName);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
    }

    public static void FullAtendanceTableList(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from atendance;");

            while (resultSet.next()){
                String attendanceDay=(resultSet.getString("atendance_day")+" ");
                String classId=(resultSet.getString("class_id")+" ");
                String studentId=(resultSet.getString("student_id"));
                String presence=(resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-2.2s  %2.2s  %-7.7s%n",attendanceDay , classId,studentId,presence);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
    }

    public static void SpecificClassAttendanceList(String className){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.prepareCall("{CALL SpecificClassCall(\"" +className+"\")}");
            ResultSet resultSet = statement.executeQuery("{CALL SpecificClassCall(\"" +className+"\")}");

            while (resultSet.next()){
                String firstName=(resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String nameOfClass=(resultSet.getString("class"));
                String dateOfAttendance=(resultSet.getString("date"));
                String presence=(resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName,lastName, nameOfClass, dateOfAttendance, presence);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
    }

    public static void callFullAttendanceList(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.prepareCall("{call CompleteAtendanceList()}");
            ResultSet resultSet = statement.executeQuery("{call CompleteAtendanceList()}");

            while (resultSet.next()){
                String nameOfClass=(resultSet.getString("class"));
                String studentId =(resultSet.getString("student id"));
                String firstName=(resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String dateOfAttendance=(resultSet.getString("date"));
                String presence=(resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-3.3s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n",nameOfClass,studentId, firstName,lastName, dateOfAttendance, presence);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());
        }
    }

    public static void specificStudentAttendanceListByFirstName(String studentFirstName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{CALL specificStudentFirstNameAttendanceSearch(\"" + studentFirstName + "\")}");
            ResultSet resultSet = statement.executeQuery("{call specificStudentFirstNameAttendanceSearch(\"" + studentFirstName + "\")}");

            while (resultSet.next()) {
                String firstName = (resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String nameOfClass = (resultSet.getString("class"));
                String dateOfAttendance = (resultSet.getString("date"));
                String presence = (resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName, lastName, nameOfClass, dateOfAttendance, presence);
            }
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println(s.getMessage());
        }
    }

    public static void specificStudentAttendanceListByLastName(String studentLastName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{CALL specificStudentLastNameAttendanceSearch(\"" + studentLastName + "\")}");
            ResultSet resultSet = statement.executeQuery("{call specificStudentLastNameAttendanceSearch(\"" + studentLastName + "\")}");

            while (resultSet.next()) {
                String firstName = (resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String nameOfClass = (resultSet.getString("class"));
                String dateOfAttendance = (resultSet.getString("date"));
                String presence = (resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName, lastName, nameOfClass, dateOfAttendance, presence);
            }
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println(s.getMessage());
        }
    }

    public static void specificStudentAttendanceListByFullName(String studentFirstName,String studentLastName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{call specificStudentFullNameAttendanceSearch(\""+studentFirstName+"\",\""+studentLastName+"\")}");
            ResultSet resultSet = statement.executeQuery("{call specificStudentFullNameAttendanceSearch(\""+studentFirstName+"\",\""+studentLastName+"\")}");

            while (resultSet.next()) {
                String firstName = (resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String nameOfClass = (resultSet.getString("class"));
                String dateOfAttendance = (resultSet.getString("date"));
                String presence = (resultSet.getString("presence"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName, lastName, nameOfClass, dateOfAttendance, presence);
            }
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println(s.getMessage());
        }
    }

    public  static void attendanceListInput(){
        Scanner scanner = new Scanner(System.in);
        String classdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.print("Input class name: ");
        String classId= scanner.nextLine();
        if (classId.equals("math")) {
            classId="1";
        }
        if (classId.equals("writing")) {
            classId="2";
        }
        if (classId.equals("history")) {
            classId="3";
        }
        if (classId.equals("music")) {
            classId="4";
        }
        if (classId.equals("dancing")) {
            classId="5";
        }
        if (classId.equals("fencing")) {
            classId="6";
        }
        if (classId.equals("literature")) {
            classId="7";
        }
        if (classId.equals("painting")) {
            classId="8";
        }
        System.out.println("Attendance is marked as: 1-present or 2-absent and 3-justified absence.");
        for (int i=1; i<=18; i++){
            System.out.print("Is the student with ID "+ i +" present:");
            String attendance=scanner.nextLine();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
                Statement statement = connection.prepareCall("{call UpdateAtendanceList(\""+classdate+"\",\""+classId+"\",\""+i+"\",\""+attendance+"\")}");
                ResultSet resultSet = statement.executeQuery("{call UpdateAtendanceList(\""+classdate+"\",\""+classId+"\",\""+i+"\",\""+attendance+"\")}");
                System.out.println("The data has been entered!");
            }
            catch (SQLException | ClassNotFoundException s){
                System.out.println("Data has NOT been entered");
            }
        }
    }
    public static void updateAttendance() throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Input date: ");
        String classdate= scanner.nextLine();
        String TodayDate = new Date().toString();
        try {
            if (classdate!=TodayDate){
                throw new Exception();
            }else {
                System.out.print("Input class name: ");
                String classId = scanner.nextLine();
                if (classId.equals("math")) {
                    classId = "1";
                }
                if (classId.equals("writing")) {
                    classId = "2";
                }
                if (classId.equals("history")) {
                    classId = "3";
                }
                if (classId.equals("music")) {
                    classId = "4";
                }
                if (classId.equals("dancing")) {
                    classId = "5";
                }
                if (classId.equals("fencing")) {
                    classId = "6";
                }
                if (classId.equals("literature")) {
                    classId = "7";
                }
                if (classId.equals("painting")) {
                    classId = "8";
                }
                System.out.println("Enter student ID: ");
                String studentId = scanner.nextLine();
                System.out.println("Attendance is marked as: 1-present, 2-absent, 3-justified absence");
                System.out.print("Enter absence type: ");
                String attendance = scanner.nextLine();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
                Statement statement = connection.prepareCall("{call updateListOfAttendance(\""+classdate+"\",\""+classId+"\",\""+studentId+"\",\""+attendance+"\")}");
                ResultSet resultSet = statement.executeQuery("{call updateListOfAttendance(\""+classdate+"\",\""+classId+"\",\""+studentId+"\",\""+attendance+"\")}");
                System.out.println("The data has been entered!");
            }
        }
        catch (SQLException | ClassNotFoundException s){
            System.out.println("Data not entered");
        }catch (Exception e){
            System.out.println("Dates do not match! Update not possible!");
        }
    }
}
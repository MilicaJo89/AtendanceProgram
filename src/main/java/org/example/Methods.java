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
                String status=(resultSet.getString("status"));
                System.out.printf("%-3.3s  %-9.9s  %-12.12s  %-10.10s%n",studentId , firstName,lastName, status);
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

    public static void FullAttendanceTableList(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from atendance;");

            while (resultSet.next()){
                String attendanceDay=(resultSet.getString("atendance_day")+" ");
                String classId=(resultSet.getString("class_id")+" ");
                String studentId=(resultSet.getString("student_id"));
                String presence=(resultSet.getString("absence_type"));
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
                String absence_type=(resultSet.getString("absence type"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName,lastName, nameOfClass, dateOfAttendance, absence_type);
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
                String presence=(resultSet.getString("absence type"));
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
                String presence = (resultSet.getString("attendance type"));
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
                String presence = (resultSet.getString("attendance type"));
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
                String presence = (resultSet.getString("attendance type"));
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
        System.out.println("Attendance is marked as: 1-present or 2-absent and 3-justified absence.");
        for (int i=1; i<=18; i++){
            System.out.print("Is the student with ID "+ i +" present:");
            String attendance=scanner.nextLine();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
                Statement statement = connection.prepareCall("{call UpdateAtendanceList(\""+classdate+"\",\""+classId+"\",\""+i+"\",\""+attendance+"\")}");
                statement.executeQuery("{call UpdateAtendanceList(\""+classdate+"\",\""+classId+"\",\""+i+"\",\""+attendance+"\")}");
                System.out.println("The data has been entered!");
            }
            catch (SQLException | ClassNotFoundException s){
                System.out.println("Data has NOT been entered");
            }
        }
    }
        
    public static void updateAttendance(){
        Scanner scanner=new Scanner(System.in);
        try {
            String datetoday= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            System.out.print("Input date: ");
            String classdate = scanner.next();
            if (!classdate.equals(datetoday)){
                throw new Exception();
            }else {
                scanner.nextLine();
                System.out.println("Input class name: ");
                String className = scanner.nextLine();
                System.out.println("Enter student ID: ");
                String studentId = scanner.nextLine();
                System.out.println("Attendance is marked as: 1-present, 2-absent, 3-justified absence");
                System.out.print("Enter absence type: ");
                String absenceType = scanner.nextLine();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
                Statement statement = connection.prepareCall("{call updateListOfAttendance(\""+classdate+"\",\""+className+"\",\""+studentId+"\",\""+absenceType+"\")}");
                statement.executeQuery("{call updateListOfAttendance(\""+classdate+"\",\""+className+"\",\""+studentId+"\",\""+absenceType+"\")}");
                System.out.println("The data has been entered!");
            }
        }
        catch (SQLException | ClassNotFoundException s){
            System.out.println("Data not entered");
        }catch (Exception e){
            System.out.println("Dates do not match! Update not possible!");
        }
    }

    public static void fullAttendanceListForSpecificClassOnSpecificDate(){
        try {
            //returns a full list of attendance for a specific class on a specific date
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input the name of class: ");
            String className = scanner.nextLine();
            System.out.println("Input date class was held: ");
            String classdate= scanner.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance","root","1234");
            Statement statement = connection.prepareCall("{CALL SpecificClassAttendanceListSearch(\"" +className+"\",\""+classdate+"\")}");
            ResultSet resultSet = statement.executeQuery("{CALL SpecificClassAttendanceListSearch(\"" +className+"\",\""+classdate+"\")}");

            while (resultSet.next()){
                String firstName=(resultSet.getString("first name"));
                String lastName = (resultSet.getString("last name"));
                String nameOfClass=(resultSet.getString("class"));
                String dateOfAttendance=(resultSet.getString("date"));
                String absence_type=(resultSet.getString("absence type"));
                System.out.printf("%-10.10s  %-12.12s  %-10.10s  %-10.10s  %-7.7s%n", firstName,lastName, nameOfClass, dateOfAttendance, absence_type);
            }
        }catch (SQLException | ClassNotFoundException s){
            System.out.println(s.getMessage());

        }
    }

    public static void PercentageCalculation() {
        try {
            //returns a full list of attendance for a specific class on a specific date
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input class ID: ");
            String classiD = scanner.nextLine();
            System.out.println("Input student ID: ");
            String studentId = scanner.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{CALL attendancePercentage(\"" + classiD + "\",\"" + studentId + "\")}");
            ResultSet resultSet = statement.executeQuery("{CALL attendancePercentage(\"" + classiD + "\",\"" + studentId + "\")}");
            System.out.println("presence percentage for the student with the id: "+studentId+" for the class with the id: "+classiD);
            while (resultSet.next()) {
                String absence_type = (resultSet.getString("absence_type"));
                String result= (resultSet.getString("percentage"));
                System.out.printf("%-10.10s  %-12.12s%n", absence_type, result);
            }
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println(s.getMessage());

        }
    }

    public static void inputNewStudent() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inputting new student");
            System.out.print("Input first name of student: ");
            String firstName = scanner.nextLine();
            System.out.print("Input last name of student: ");
            String lastName = scanner.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{call inputNewStudent('"+firstName+"', '"+lastName+"')}");
            statement.executeQuery("{call inputNewStudent('"+firstName+"', '"+lastName+"')}");
            System.out.println("The data has been entered!");
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println("Data has not been entered");
        }
    }

    public static void changeOfStudentStatus() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Change of student status");
            System.out.print("Input student id: ");
            String studentId = scanner.nextLine();
            System.out.println("Status can be active(attending) -or- inactive(no longer attending)");
            System.out.print("Input the new student status: ");
            String newStatus = scanner.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Atendance", "root", "1234");
            Statement statement = connection.prepareCall("{CALL changOfStudentStatus("+studentId+",\""+newStatus+"\")}");
            statement.executeQuery("{CALL changOfStudentStatus("+studentId+",\""+newStatus+"\")}");
            System.out.println("The data has been entered!");
        } catch (SQLException | ClassNotFoundException s) {
            System.out.println("Data has not been entered");
        }
    }
}
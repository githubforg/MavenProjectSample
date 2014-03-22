package com.MessageBoardServer;
import com.MessageBoardServer.Sample.SamplerRecord;
import org.postgresql.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by DELL on 14-3-8.
 */
public class dbHandler {
//TODO

    Connection connection = null;

    public void inti(){
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");


        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/mydb", "DELL",
                    "123123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        try {
            ResultSet rsTable=connection.getMetaData().getTables(null,null,"student",null);
            if(rsTable.next()){
                System.out.println("The Table STUDENT exsits.");
            }else{
                String STUDENT="create table student (name varchar(80),id int,birthDay int,location varchar(80));";
                Statement stmt=connection.createStatement();
                stmt.executeUpdate(STUDENT);
                System.out.println("The Table STUDENT is created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public boolean writeRecord(SamplerRecord record){
        try {
            Statement stmt=connection.createStatement();
            String name=record.getName();
            int id=record.getId();
            int birthDay=record.getBirthDay();
            String location=record.getLocation();

            String insert="INSERT INTO student VALUES ('"+name+"',"+id+","+birthDay+",'"+location+"')";
            stmt.executeUpdate(insert);
            System.out.println("Insert successfully");

        } catch (SQLException e) {
            System.out.println("Failed to insert");
            e.printStackTrace();
        }

        return true;
    }


    public ArrayList read(String sql){
        ArrayList list=new ArrayList();
        Statement stmt= null;
        try {
            stmt = connection.createStatement();

            ResultSet rs=stmt.executeQuery(sql);
            ResultSetMetaData rsm=rs.getMetaData();
            int count = rsm.getColumnCount();

            while (rs.next()){
                for(int i=0;i<count;i++){
                    String ColumnName=rsm.getColumnName(i+1);
                    Object sqlView=rs.getString(ColumnName);
                    list.add(ColumnName);
                    list.add(sqlView.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }


    public void des(){
        try {
            Statement stmt=connection.createStatement();
            stmt.executeUpdate("delete from student");
            System.out.println("Empty the form successfully");
        } catch (SQLException e) {
            System.out.println("Failed to empty the form");
            e.printStackTrace();

        }


    }

}



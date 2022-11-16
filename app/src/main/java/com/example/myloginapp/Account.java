package com.example.myloginapp;

import java.util.Hashtable;

public class Account {
    public static Hashtable<String, String> Hash  = new Hashtable<String, String>();

    public Account() {
    }

    public void Set(String User,String Pass){
        Hash.put(User,Pass);
    }
    public Hashtable<String, String> Get(){
        return  Hash;
    }
}

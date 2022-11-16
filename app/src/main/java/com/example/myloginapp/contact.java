package com.example.myloginapp;

public class contact {
    private String contactname;
    private String phone;
    private int image;

    public  contact(String name,String phone,int img){
        this.contactname = name;
        this.image = img;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

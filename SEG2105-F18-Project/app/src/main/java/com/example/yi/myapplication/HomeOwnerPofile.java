package com.example.yi.myapplication;

import java.util.ArrayList;

public class HomeOwnerPofile {
    public String userName;
    public String password;
    public String name;
    public String lastName;
    public String address;
    public String phoneNumber;

    public ArrayList<Service> haveServiceArrayList = new ArrayList<>();
    public ArrayList<ServiceProviderProfile> haveServiceProviderArrayList = new ArrayList<>();
    public ArrayList<String> bookedAvailabilityMatrix = new ArrayList<>();


    public ArrayList<String> getBookedAvailabilityMatrix() {
        return bookedAvailabilityMatrix;
    }

    public void setBookedAvailabilityMatrix(ArrayList<String> bookedAvailabilityMatrix) {
        this.bookedAvailabilityMatrix = bookedAvailabilityMatrix;
    }



    public HomeOwnerPofile () {

    }

    public HomeOwnerPofile (String userName, String password, String name,
                            String lastName, String address, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Service> getHaveServiceArrayList() {
        return haveServiceArrayList;
    }

    public void setHaveServiceArrayList(ArrayList<Service> haveServiceArrayList) {
        this.haveServiceArrayList = haveServiceArrayList;
    }

    public ArrayList<ServiceProviderProfile> getHaveServiceProviderArrayList() {
        return haveServiceProviderArrayList;
    }

    public void setHaveServiceProviderArrayList(ArrayList<ServiceProviderProfile> haveServiceProviderArrayList) {
        this.haveServiceProviderArrayList = haveServiceProviderArrayList;
    }


    public void encryptPassword() {
        StringBuilder sb = new StringBuilder();
        char[] ch = password.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            sb.append(Integer.valueOf(ch[i] + 5).intValue()).append(",");

        }
        password = sb.toString();
    }

//    public void decryptPassword() {
//        StringBuffer sbu = new StringBuffer();
//        String[] chars = password.split(",");
//        for (int i = 0; i < chars.length; i++) {
//            sbu.append((char) (Integer.parseInt(chars[i]) - 5));
//        }
//        password = sbu.toString();
//    }


}

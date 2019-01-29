package com.example.yi.myapplication;

import java.util.ArrayList;

public class ServiceProviderProfile {
    //    public String id;
    public String userName;
    public String password;
    public String name;
    public String lastName;
    public String phoneNumber;
    public String address;

    public String company;
    public String description;
    public String licened;
    public ArrayList<Service> sl = new ArrayList<>();
    public ArrayList<String> comments = new ArrayList<>();
    public String availabilityMatrix;
    public String availabilityMatrixSelected; //The matrix including the information of selected time slot

    public double currentRate;
    public int rateNumber;

//    public int˜[][] availabilityMatrix = new int[9][5];
//    public int[][] availabilityMatrix;


    public void setSl(ArrayList<Service> sl) {
        this.sl = sl;
    }

    public ArrayList<Service> getSl() {
        return sl;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLicened(String licened) {
        this.licened = licened;
    }

    public String getCompany() {

        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getLicened() {
        return licened;
    }

    public ServiceProviderProfile () {
    }

    public ServiceProviderProfile (String name, String lastName, String phoneNumber,
                                   String userName, String password, String address) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public ServiceProviderProfile (String name, String lastName, String phoneNumber,
                                   String userName, String password, String address,
                                   int[][] mavail) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.availabilityMatrix = matrixToString(mavail);
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

//    public int[][] getAvailabilityMatrix() {
//        return availabilityMatrix;
//    }
//
//    public void setAvailabilityMatrix(int[][] availabilityMatrix) {
//        this.availabilityMatrix = availabilityMatrix;
//    }

    public String getAvailabilityMatrix() {
        return availabilityMatrix;
    }

    public void setAvailabilityMatrix(String availabilityMatrix) {
        this.availabilityMatrix = availabilityMatrix;
    }

    public String getAvailabilityMatrixSelected() {
        return availabilityMatrixSelected;
    }

    public void setAvailabilityMatrixSelected(String availabilityMatrixSelected) {
        this.availabilityMatrixSelected = availabilityMatrixSelected;
    }


    public String matrixToString(int[][] mavail) {
        String str = "";
        String tempStr = null;
        for (int i = 0; i < mavail.length; i++) {
            for (int j = 0; j < mavail[i].length; j++) {
                tempStr = String.valueOf(mavail[i][j]);
                str = str + tempStr + ",";
            }
        }
        return str;
    }

    public int[][] stringToMatrix(String str){
        int[][] result = new int[9][5];
        int count = 0;
        String[] strArray = str.split(",");
        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                result[i][j] = Integer.parseInt(strArray[count]);
                ++ count ;
            }
        }
        return result;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public int getRateNumber() {
        return rateNumber;
    }

    public void setRateNumber(int rateNumber) {
        this.rateNumber = rateNumber;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
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

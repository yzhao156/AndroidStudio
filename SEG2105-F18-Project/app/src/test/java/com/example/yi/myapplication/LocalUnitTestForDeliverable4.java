package com.example.yi.myapplication;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LocalUnitTestForDeliverable4 {
    HomeOwnerPofile homeOwnerPofile =
            new HomeOwnerPofile(
                    "HOUserName",
                    "HOPassword",
                    "HOName",
                    "HOLastName",
                    "HOAddress",
                    "76543210");

    ServiceProviderProfile serviceProviderProfile =
            new ServiceProviderProfile(
                    "SPName",
                    "SPLastName",
                    "123456789",
                    "SPUserName",
                    "SPPassword",
                    "SPAddress");

    Service service1 = new Service("Cleaning", 12);
    Service service2 = new Service("Washing", 8.99);


    public String decryptPassword(String str) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = str.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) (Integer.parseInt(chars[i]) - 5));
        }
        return sbu.toString();
    }


    //Local Unit test case 1 for deliverable 4
    @Test
    public void checkHOUserName() {
        assertEquals("Check the user name of the home owner", "HOUserName", homeOwnerPofile.getUserName());
    }

    //Local Unit test case 2 for deliverable 4
    @Test
    public void checkHOPassword() {
        assertEquals("Check the password of the home owner", "HOPassword", homeOwnerPofile.getPassword());
    }

    //Local Unit test case 3 for deliverable 4
    @Test
    public void checkHOName() {
        assertEquals("Check the name of the home owner", "HOName", homeOwnerPofile.getName());
    }

    //Local Unit test case 4 for deliverable 4
    @Test
    public void checkHOLastName() {
        assertEquals("Check the last name of the home owner", "HOLastName", homeOwnerPofile.getLastName());
    }

    //Local Unit test case 5 for deliverable 4
    @Test
    public void checkHOAddress() {
        assertEquals("Check the address of the home owner", "HOAddress", homeOwnerPofile.getAddress());
    }

    //Local Unit test case 6 for deliverable 4
    @Test
    public void checkHOPhoneNumber() {
        assertEquals("Check the phone number of the home owner", "76543210", homeOwnerPofile.getPhoneNumber());
    }


    //Local Unit test case 7 for deliverable 4
    @Test
    public void checkHOEncryptPassword() {
        homeOwnerPofile.encryptPassword();

        assertEquals("Check the function of encrypting password of the home owner class",
                "HOPassword",
                decryptPassword(homeOwnerPofile.getPassword()));
    }

    //Local Unit test case 8 for deliverable 4
    @Test
    public void checkHOHaveServiceArrayList() {
        ArrayList<Service> serviceList= new ArrayList<>();
        serviceList.add(service1);
        serviceList.add(service2);
        homeOwnerPofile.setHaveServiceArrayList(serviceList);

        assertEquals("Check the function of specifying service of the home owner class",
                "Washing",
                homeOwnerPofile.getHaveServiceArrayList().get(1).name);

    }

    //Local Unit test case 9 for deliverable 4
    @Test
    public void checkHOHaveServiceProviderArrayList() {
        ArrayList<ServiceProviderProfile> serviceProviderProfileList = new ArrayList<>();
        serviceProviderProfileList.add(serviceProviderProfile);
        homeOwnerPofile.setHaveServiceProviderArrayList(serviceProviderProfileList);

        assertEquals("Check the function of specifying service provider of the home owner class",
                "SPLastName",
                homeOwnerPofile.getHaveServiceProviderArrayList().get(0).lastName);

    }

    //Local Unit test case 10 for deliverable 4
    @Test
    public void checkHOBookedAvailabilityMatrix() {
        ArrayList<String> bookedAvailabilityMatrix = new ArrayList<>();
        bookedAvailabilityMatrix.add("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,");
        homeOwnerPofile.setBookedAvailabilityMatrix(bookedAvailabilityMatrix);

        assertEquals("Check the function of specifying the time slots of booked service of the home owner class",
                "1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,",
                homeOwnerPofile.getBookedAvailabilityMatrix().get(0));
    }

}

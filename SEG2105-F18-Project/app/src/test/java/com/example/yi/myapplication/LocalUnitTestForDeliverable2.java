package com.example.yi.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;


public class LocalUnitTestForDeliverable2 {

    ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile("SPName", "SPLastName", "123456789", "SPUserName", "SPPassword", "SPAddress");

    //Local Unit test case 1 for deliverable 2
    @Test
    public void checkServiceName_D2() {
        Service service = new Service("Cleaning", 12);
        assertEquals("Check the name of the service", "Cleaning", service.getName());
    }

    //Local Unit test case 2 for deliverable 2
    @Test
    public void checkServiceRate_D2() {
        Service service = new Service("Cleaning", 12);
        assertEquals("Check the hourly rate of the service", "12.0", String.valueOf(service.getRate()));
    }

    //Local Unit test case 3 for deliverable 2
    @Test
    public void checkServiceProviderName_D2() {
        //ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile("SPName", "SPLastName", "123456789", "SPUserName", "SPPassword", "SPAvailability");
        assertEquals("Check the name of the service provider", "SPName", serviceProviderProfile.getName());
    }

    //Local Unit test case 4 for deliverable 2
    @Test
    public void checkServiceProviderPhoneNumber_D2() {
       // ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile("SPName", "SPLastName", "123456789", "SPUserName", "SPPassword", "SPAvailability");
        assertEquals("Check the phone number of the service provider", "123456789", serviceProviderProfile.getPhoneNumber());
    }

    //Local Unit test case 5 for deliverable 2
    @Test
    public void checkServiceProviderPassword_D2() {
        assertEquals("Check the phone number of the service provider", "SPPassword", serviceProviderProfile.getPassword());
    }


}

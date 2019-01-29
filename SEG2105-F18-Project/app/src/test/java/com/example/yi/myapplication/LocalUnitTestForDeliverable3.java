package com.example.yi.myapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocalUnitTestForDeliverable3 {


    ServiceProviderProfile serviceProviderProfile =
            new ServiceProviderProfile(
                    "SPName",
                    "SPLastName",
                    "123456789",
                    "SPUserName",
                    "SPPassword",
                    "SPAddress");

    //Local Unit test case 1 for deliverable 3
    @Test
    public void checkServiceProviderPhoneNumber_D3() {
        assertEquals("Check the phone number of the service provider", "123456789", serviceProviderProfile.getPhoneNumber());
    }

    //Local Unit test case 2 for deliverable 3
    @Test
    public void checkServiceProviderPassword_D3() {
        assertEquals("Check the phone number of the service provider", "SPPassword", serviceProviderProfile.getPassword());
    }
}

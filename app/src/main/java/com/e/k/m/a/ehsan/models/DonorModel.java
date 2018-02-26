package com.e.k.m.a.ehsan.models;

/**
 * Created by ahmedelmoselhy on 2/20/2018.
 */

public class DonorModel {

    private String donorName = "";
    private String donorEmail = "";
    private String donorPhoneNumber = "";
    private String donorAddress = "";
    private String donorProfileImage = "";
    private String userType = "donor";
    private int numberOfDonations = 0;


    public DonorModel() {
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }


    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorProfileImage()
    {
        return donorProfileImage;
    }

    public void setDonorProfileImage(String donorProfileImage) {
        this.donorProfileImage = donorProfileImage;
    }

    public String getDonorPhoneNumber() {
        return donorPhoneNumber;
    }

    public void setDonorPhoneNumber(String donorPhoneNumber) {
        this.donorPhoneNumber = donorPhoneNumber;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public int getNumberOfDonations() {
        return numberOfDonations;
    }

    public void setNumberOfDonations(int numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
    }

    public String getUserType() {return userType;}

}

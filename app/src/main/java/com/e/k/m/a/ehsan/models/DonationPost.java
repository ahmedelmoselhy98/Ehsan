package com.e.k.m.a.ehsan.models;

/**
 * Created by ahmedelmoselhy on 2/26/2018.
 */

public class DonationPost {

    private String donarName;
    private String donarAddress;
    private String donarPhoneNumber;
    private String donarImage;
    private String description;

    public DonationPost() {
    }

    public String getDonarName() {
        return donarName;
    }

    public void setDonarName(String donarName) {
        this.donarName = donarName;
    }

    public String getDonarAddress() {
        return donarAddress;
    }

    public void setDonarAddress(String donarAddress) {
        this.donarAddress = donarAddress;
    }

    public String getDonarPhoneNumber() {
        return donarPhoneNumber;
    }

    public void setDonarPhoneNumber(String donarPhoneNumber) {
        this.donarPhoneNumber = donarPhoneNumber;
    }

    public String getDonarImage() {
        return donarImage;
    }

    public void setDonarImage(String donarImage) {
        this.donarImage = donarImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

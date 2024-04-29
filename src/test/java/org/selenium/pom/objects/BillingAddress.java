package org.selenium.pom.objects;

public class BillingAddress {

    private String firstName;
    private String lastName;
    private String companyName;
    private String countryName;
    private String billingAddress1;
    private String billingAddress2;
    private String billingCity;
    private String stateName;
    private String billingPostCode;
    private String phone;
    private String email;
    private String comments;

    public BillingAddress(){}

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryDropDown) {
        this.countryName = countryDropDown;
    }

    public String getStateName() {
        return stateName ;
    }

    public void setStateName(String stateDropDown) {
        this.stateName  = stateDropDown;
    }

    public BillingAddress(String firstName, String lastName, String companyName, String billingAddress1, String billingAddress2, String billingCity, String billingPostCode, String phone, String email, String comments){
        this.firstName=firstName;
        this.lastName=lastName;
        this.companyName=companyName;
        this.billingAddress1=billingAddress1;
        this.billingAddress2=billingAddress2;
        this.billingCity=billingCity;
        this.billingPostCode=billingPostCode;
        this.phone=phone;
        this.email=email;
        this.comments=comments;
    }


    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BillingAddress setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public BillingAddress setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
        return this;
    }

    public String getBillingAddress2() {
        return billingAddress2;
    }

    public BillingAddress setBillingAddress2(String billingAddress2) {
        this.billingAddress2 = billingAddress2;
        return this;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public BillingAddress setBillingCity(String billingCity) {
        this.billingCity = billingCity;
        return this;
    }

    public String getBillingPostCode() {
        return billingPostCode;
    }

    public BillingAddress setBillingPostCode(String billingPostCode) {
        this.billingPostCode = billingPostCode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public BillingAddress setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BillingAddress setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public BillingAddress setComments(String comments) {
        this.comments = comments;
        return this;
    }



}

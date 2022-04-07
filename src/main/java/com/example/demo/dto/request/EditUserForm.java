package com.example.demo.dto.request;

public class EditUserForm {
   private String fullName;
   private String personalEmail;
   private String phoneNumber;
   private String typeContract;
   private String code;
   private String gender;
   private String cmnd;
   private String town;
   private String country;
   private String religion;
   private String year;
   private String birthplace;
   private String marital_status;
   private String academic_standard;
   private String education_level;
   private String ethnic;
   private boolean status;

    public EditUserForm(String fullName, String personalEmail, String phoneNumber, String typeContract, String code, String gender, String cmnd, String town, String country, String religion, String year, String birthplace, String marital_status, String academic_standard, String education_level, String ethnic, boolean status) {
        this.fullName = fullName;
        this.personalEmail = personalEmail;
        this.phoneNumber = phoneNumber;
        this.typeContract = typeContract;
        this.code = code;
        this.gender = gender;
        this.cmnd = cmnd;
        this.town = town;
        this.country = country;
        this.religion = religion;
        this.year = year;
        this.birthplace = birthplace;
        this.marital_status = marital_status;
        this.academic_standard = academic_standard;
        this.education_level = education_level;
        this.ethnic = ethnic;
        this.status = status;
    }

    public EditUserForm() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getAcademic_standard() {
        return academic_standard;
    }

    public void setAcademic_standard(String academic_standard) {
        this.academic_standard = academic_standard;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

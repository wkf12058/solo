package com.solo.body.user.model;

import java.util.Date;
import java.util.Map;

public class PersonInfo {
    private String id;

    private String name;

    private String sex;

    private String identityNum;

    private String nation;

    private String birthday;

    private String isMarry;

    private String politicalIdentity;

    private String speciality;

    private String householdAddress;

    private String householdType;

    private String applyJob;

    private String job;

    private String major;

    private String phoneNum;

    private String email;

    private String address;

    private String height;

    private String weight;

    private String emergencyContact;

    private String emergencyPhone;

    private Date inputTime;

    private String img;

    private String arrivalTime;

    private String isAgree;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum == null ? null : identityNum.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getIsMarry() {
        return isMarry;
    }

    public void setIsMarry(String isMarry) {
        this.isMarry = isMarry == null ? null : isMarry.trim();
    }

    public String getPoliticalIdentity() {
        return politicalIdentity;
    }

    public void setPoliticalIdentity(String politicalIdentity) {
        this.politicalIdentity = politicalIdentity == null ? null : politicalIdentity.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress == null ? null : householdAddress.trim();
    }

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType == null ? null : householdType.trim();
    }

    public String getApplyJob() {
        return applyJob;
    }

    public void setApplyJob(String applyJob) {
        this.applyJob = applyJob == null ? null : applyJob.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact == null ? null : emergencyContact.trim();
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone == null ? null : emergencyPhone.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree == null ? null : isAgree.trim();
    }
    
    public void getPropertyThroughMap(Map params){
		this.setName(params.get("name").toString());
		this.setSex(params.get("sex").toString());
		this.setIdentityNum(params.get("identityNum").toString());
		this.setNation(params.get("nation").toString());
		this.setBirthday(params.get("birthday").toString());
		this.setIsMarry(params.get("isMarry").toString());
		this.setPoliticalIdentity(params.get("politicalIdentity").toString());
		this.setSpeciality(params.get("speciality").toString());
		this.setHouseholdAddress(params.get("householdAddress").toString());
		this.setHouseholdType(params.get("householdType").toString());
		this.setApplyJob(params.get("applyJob").toString());
		this.setJob(params.get("job").toString());
		this.setMajor(params.get("major").toString());
		this.setPhoneNum(params.get("phoneNum").toString());
		this.setEmail(params.get("email").toString());
		this.setAddress(params.get("address").toString());
		this.setHeight(params.get("height").toString());
		this.setWeight(params.get("weight").toString());
		this.setEmergencyContact(params.get("emergencyContact").toString());
		this.setEmergencyPhone(params.get("emergencyPhone").toString());
		this.setImg(params.get("img").toString());
		this.setArrivalTime(params.get("arrivalTime").toString());
		this.setIsAgree(params.get("isAgree").toString());
    }
    
}
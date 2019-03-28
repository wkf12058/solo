package com.solo.body.user.model;

public class PersonWorkExperience {
    private Integer id;

    private String personId;

    private String workCompany;

    private String job;

    private String consultantName;

    private String consultantNum;

    private String pay;

    private String reasons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany == null ? null : workCompany.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName == null ? null : consultantName.trim();
    }

    public String getConsultantNum() {
        return consultantNum;
    }

    public void setConsultantNum(String consultantNum) {
        this.consultantNum = consultantNum == null ? null : consultantNum.trim();
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay == null ? null : pay.trim();
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons == null ? null : reasons.trim();
    }
}
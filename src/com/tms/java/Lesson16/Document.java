package com.tms.java.Lesson16;

public class Document {
    private String phoneNumber;
    private String email;
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Document(){
        phoneNumber = "None";
        email = "None";
        documentNumber = "None";
    }
}

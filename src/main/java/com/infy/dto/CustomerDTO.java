package com.infy.dto;

import java.time.LocalDate;

// Create Operation
public class CustomerDTO {
    private Integer customerId;
    private String emailId;
    private String name;
    private LocalDate dateOfBirth;

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", emailId='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

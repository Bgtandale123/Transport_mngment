package com.edi.a.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Line_Details")
public class LineDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique  = true)
    private String code;

    private String lineName;

    private String contactDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public LineDetails(int id, String code, String lineName, String contactDetails) {
        this.id = id;
        this.code = code;
        this.lineName = lineName;
        this.contactDetails = contactDetails;
    }

    public LineDetails() {
    }

    @Override
    public String toString() {
        return "LineDetails{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", lineName='" + lineName + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }
}

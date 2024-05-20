package com.edi.a.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Container_Details")
public class ContainerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique  = true)
    private String containerNumber;

    private String containerSize;

    private String containerType;

    private String tareWeight;

    private String maxPayload;

    private String Owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(String tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(String maxPayload) {
        this.maxPayload = maxPayload;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public ContainerDetails(int id, String containerNumber, String containerSize, String containerType, String tareWeight, String maxPayload, String owner) {
        this.id = id;
        this.containerNumber = containerNumber;
        this.containerSize = containerSize;
        this.containerType = containerType;
        this.tareWeight = tareWeight;
        this.maxPayload = maxPayload;
        Owner = owner;
    }

    public ContainerDetails() {
    }

    @Override
    public String toString() {
        return "ContainerDetails{" +
                "id=" + id +
                ", containerNumber='" + containerNumber + '\'' +
                ", containerSize='" + containerSize + '\'' +
                ", containerType='" + containerType + '\'' +
                ", tareWeight='" + tareWeight + '\'' +
                ", maxPayload='" + maxPayload + '\'' +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}

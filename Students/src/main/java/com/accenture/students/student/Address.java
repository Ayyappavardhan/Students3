package com.accenture.students.student;

import java.util.Objects;

public class Address {
    private String doorNumber;
    private String streetName;
    private String villageName;
    private String mandalName;
    private String districtName;
    private Integer pinCode;

    public Address(String doorNumber, String streetName, String villageName, String mandalName, String districtName, Integer pinCode) {
        this.doorNumber = doorNumber;
        this.streetName = streetName;
        this.villageName = villageName;
        this.mandalName = mandalName;
        this.districtName = districtName;
        this.pinCode = pinCode;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(doorNumber, address.doorNumber) && Objects.equals(streetName, address.streetName) && Objects.equals(villageName, address.villageName) && Objects.equals(mandalName, address.mandalName) && Objects.equals(districtName, address.districtName) && Objects.equals(pinCode, address.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doorNumber, streetName, villageName, mandalName, districtName, pinCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNumber='" + doorNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", villageName='" + villageName + '\'' +
                ", mandalName='" + mandalName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}

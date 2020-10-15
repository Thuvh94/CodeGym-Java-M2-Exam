package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class DirectoryBook implements Serializable {
    private String name;
    private long phoneNumber;
    private String group;
    private boolean isMale;
    private String address;
    private LocalDate birthday;
    private String email;
//    private String facebook;

    public DirectoryBook() {
    }

    public DirectoryBook(String name, long phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
//        this.facebook = facebook;
    }

    public DirectoryBook(String name, long phoneNumber, String group, boolean isMale, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.isMale = isMale;
        this.address = address;
        this.email = email;
//        this.facebook = facebook;
    }

    public DirectoryBook(String name, long phoneNumber, String group, boolean isMale, String address, LocalDate birthday, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.isMale = isMale;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getFacebook() {
//        return facebook;
//    }
//
//    public void setFacebook(String facebook) {
//        this.facebook = facebook;
//    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString() {
        return "DirectoryBook{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", group='" + group + '\'' +
                ", isMale=" + isMale +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
//                ", facebook='" + facebook + '\'' +
                '}';
    }
}

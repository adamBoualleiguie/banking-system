package classes;

import helpers.*;
import java.sql.*;

public class client {

    // attributes
    private String firstName, lastName, adress, birthday, city;
    private int cin, phoneNumber;
    private int balance ; 
    private String hashPw ; 
    

    public client() {
    }

    public client(String firstName, String lastName, String adress, String birthday, String city, int cin,
            int phoneNumber, String pw ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.birthday = birthday;
        this.city = city;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.hashPw= md5Crypt.md5Encryption(pw); 
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCin() {
        return this.cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public client firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public client lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public client adress(String adress) {
        setAdress(adress);
        return this;
    }

    public client birthday(String birthday) {
        setBirthday(birthday);
        return this;
    }

    public client city(String city) {
        setCity(city);
        return this;
    }

    public client cin(int cin) {
        setCin(cin);
        return this;
    }

    public client phoneNumber(int phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }


// hash getter
    public String gethashPw(){
        return hashPw ; 
    }
    @Override
    public String toString() {
        return "{" + " firstName='" + getFirstName() + "'" + ", lastName='" + getLastName() + "'" + ", adress='"
                + getAdress() + "'" + ", birthday='" + getBirthday() + "'" + ", city='" + getCity() + "'" + ", cin='"
                + getCin() + "'" + ", phoneNumber='" + getPhoneNumber() + "'" + "}";
    }

    // methodes
    // creat methodes to store to db
    // we can make constructor directly log in db and submit data

    public void addClientToDb(client c) {
        final String INSERT_SQL_QUERY = "INSERT INTO clientdata(firstName,lastName,adress,birthday,city,cin,phoneNumber,hashPw) VALUES(?,?,?,?,?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = sqlhelper.getConnection();
            if (con == null) {
                System.out.println("Error getting the connection. Please check if the DB server is running");
                return;
            }
            con.setAutoCommit(false);
            ps = con.prepareStatement(INSERT_SQL_QUERY);
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getAdress());
            ps.setString(4, c.getBirthday());
            ps.setString(5, c.getCity());
            ps.setInt(6, c.getCin());
            ps.setInt(7, c.getPhoneNumber());
            ps.setString(8,c.gethashPw()); 

            ps.execute();
            con.commit();

        } catch (SQLException e) {
        }

    }

    // balance getter 
    public int checkBalance(){
        return balance ; 

    }

    
    
    
  
}

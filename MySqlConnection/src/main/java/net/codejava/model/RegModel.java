package net.codejava.model;

public class RegModel {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private int mobileNumber;
    private int registrationNumber;
    private String address;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username)
        {
            this.username = username;
        }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;

    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(int mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }
    public String getAddress() {
        return address;
    }
    public void address(String address)
    {
        this.address = address;
    }


}

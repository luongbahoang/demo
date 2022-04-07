package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "personalemail"
        }),

        @UniqueConstraint(columnNames = {
                "code"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String fullname;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    @JsonIgnore
    @NotBlank
    @Size(min = 3, max = 5000)

    private String password;

    @Size(max = 50)
    @Email
    private String personalemail;
    @Size(min = 3, max = 50)
    private String phoneNumber;
    @Size(min = 3, max = 50)
    private String typeContract;
    @NotBlank
    @Size(min = 3, max = 50)
    private String code;
    @Size(min = 1, max = 50)
    private String gender;
    @Size(min = 3, max = 50)
    private String address;
    @Size(min = 3, max = 50)
    private String cmnd;
    @Size(min = 3, max = 50)
    private String town;
    @Size(min = 3, max = 50)
    private String hireDate;
    @Size(min = 3, max = 50)
    private String country;
    @Size(min = 3, max = 50)
    private String religion;
    @Size(min = 3, max = 50)
    private String year;
    @Size(min = 3, max = 50)
    private String birthplace;
    @Size(min = 3, max = 50)
    private String marital_status;
    @Size(min = 3, max = 50)
    private String academic_standard;
    @Size(min = 3, max = 50)
    private String education_level;
    @Size(min = 3, max = 50)
    private String ethnic;
    @Size(min = 3, max = 50)
    private String department;
    @Lob
    private String comment;
    @Size(min = 3, max = 50)
    private String position;

    private boolean status;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();
//    public User(String fullname,String username,String password, String gender,String code,String position,
//                String typeContract,String hireDate,String , Set<Role> roles){
//
//    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalemail() {
        return personalemail;
    }

    public void setPersonalemail(String personalemail) {
        this.personalemail = personalemail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getAcademic_standard() {
        return academic_standard;
    }

    public void setAcademic_standard(String academic_standard) {
        this.academic_standard = academic_standard;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(long id, String fullname, String username, String password, String personalemail, String phoneNumber, String typeContract, String code, String gender, String address, String cmnd, String town, String hireDate, String country, String religion, String year, String birthplace, String marital_status, String academic_standard, String education_level, String ethnic, String department, String comment, String position, boolean status, Set<Role> roles) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.personalemail = personalemail;
        this.phoneNumber = phoneNumber;
        this.typeContract = typeContract;
        this.code = code;
        this.gender = gender;
        this.address = address;
        this.cmnd = cmnd;
        this.town = town;
        this.hireDate = hireDate;
        this.country = country;
        this.religion = religion;
        this.year = year;
        this.birthplace = birthplace;
        this.marital_status = marital_status;
        this.academic_standard = academic_standard;
        this.education_level = education_level;
        this.ethnic = ethnic;
        this.department = department;
        this.comment = comment;
        this.position = position;
        this.status = status;
        this.roles = roles;
    }

    public User(String fullname, String username, String password,
                String typeContract, String code, String gender, String hireDate,
                String position, Set<Role> roles) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.typeContract = typeContract;
        this.code = code;
        this.gender = gender;
        this.hireDate = hireDate;
        this.position = position;
        this.roles = roles;
    }

    public User(@NotBlank @Size(min = 3, max = 50) String fullname,
                @NotBlank @Size(min = 3, max = 50) String username,
                @NotBlank  @Size(min = 3, max = 5000) String encode,
                @Size(min = 3, max = 50) String gender,
                @Size(min = 3, max = 50) String code,
                @Size(min = 3, max = 50) String position,
                @Size(min = 3, max = 50) String typeContract,
                @Size(min = 3, max = 50) String hireDate, String comment
    ) {
        this.fullname = fullname;
        this.username = username;
        this.password = encode;
        this.gender = gender;
        this.code = code;
        this.position = position;
        this.typeContract = typeContract;
        this.hireDate = hireDate;
        this.comment = comment;
    }
}

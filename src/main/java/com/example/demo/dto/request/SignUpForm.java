package com.example.demo.dto.request;


import java.util.Set;


public class SignUpForm {
   private String code;
   private String fullname;
   private String gender;
   private String username;
   private String password;
   private String position;
   private String type;
   private String hireDate;
   private String comment;
   private Set<String> roles;

   public SignUpForm() {
   }

   public SignUpForm(String code, String fullname, String gender, String username, String password, String position, String type, String hireDate, String comment, Set<String> roles) {
      this.code = code;
      this.fullname = fullname;
      this.gender = gender;
      this.username = username;
      this.password = password;
      this.position = position;
      this.type = type;
      this.hireDate = hireDate;
      this.comment = comment;
      this.roles = roles;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getFullname() {
      return fullname;
   }

   public void setFullname(String fullname) {
      this.fullname = fullname;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
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

   public String getPosition() {
      return position;
   }

   public void setPosition(String position) {
      this.position = position;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getHireDate() {
      return hireDate;
   }

   public void setHireDate(String hireDate) {
      this.hireDate = hireDate;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

   public Set<String> getRoles() {
      return roles;
   }

   public void setRoles(Set<String> roles) {
      this.roles = roles;
   }
}

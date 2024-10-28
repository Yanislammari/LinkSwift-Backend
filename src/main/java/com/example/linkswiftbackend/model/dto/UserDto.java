package com.example.linkswiftbackend.model.dto;

import com.example.linkswiftbackend.model.enums.UserGrade;
import com.example.linkswiftbackend.model.enums.UserType;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserType type;
    private String job;
    private boolean searchJob;
    private UserGrade grade;
    private String course;
    private byte[] profilePicture;
    private UUID companyId;
    private UUID schoolId;

    public UserDto(UUID id, String firstName, String lastName, String email, String password, UserType type, String job, boolean searchJob, UserGrade grade, String course, byte[] profilePicture, UUID companyId, UUID schoolId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.job = job;
        this.searchJob = searchJob;
        this.grade = grade;
        this.course = course;
        this.profilePicture = profilePicture;
        this.companyId = companyId;
        this.schoolId = schoolId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return this.type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isSearchJob() {
        return this.searchJob;
    }

    public void setSearchJob(boolean searchJob) {
        this.searchJob = searchJob;
    }

    public UserGrade getGrade() {
        return this.grade;
    }

    public void setGrade(UserGrade grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public UUID getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(UUID schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + this.id +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                ", type=" + this.type +
                ", job='" + this.job + '\'' +
                ", searchJob=" + this.searchJob +
                ", grade=" + this.grade +
                ", course='" + this.course + '\'' +
                ", profilePicture=" + Arrays.toString(this.profilePicture) +
                ", companyId=" + this.companyId +
                ", schoolId=" + this.schoolId +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof UserDto userDto)) {
            return false;
        }
        return this.searchJob == userDto.isSearchJob() && Objects.equals(this.id, userDto.getId()) && Objects.equals(this.firstName, userDto.getFirstName()) && Objects.equals(this.lastName, userDto.getLastName()) && Objects.equals(this.email, userDto.getEmail()) && Objects.equals(this.password, userDto.getPassword()) && this.type == userDto.getType() && Objects.equals(this.job, userDto.getJob()) && this.grade == userDto.getGrade() && Objects.equals(this.course, userDto.getCourse()) && Arrays.equals(this.profilePicture, userDto.getProfilePicture()) && Objects.equals(this.companyId, userDto.getCompanyId()) && Objects.equals(this.schoolId, userDto.getSchoolId());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.firstName, this.lastName, this.email, this.password, this.type, this.job, this.searchJob, this.grade, this.course, this.companyId, this.schoolId);
        result = 31 * result + Arrays.hashCode(this.profilePicture);
        return result;
    }
}

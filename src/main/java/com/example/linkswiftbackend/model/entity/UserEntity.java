package com.example.linkswiftbackend.model.entity;

import com.example.linkswiftbackend.model.enums.UserGrade;
import com.example.linkswiftbackend.model.enums.UserType;
import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private UserType type;
    @Column(name = "job")
    private String job;
    @Column(name = "search_job", nullable = false)
    private boolean searchJob;
    @Enumerated(EnumType.STRING)
    @Column(name = "grade")
    private UserGrade grade;
    @Column(name = "course")
    private String course;
    @Lob
    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    private byte[] profilePicture;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    public UserEntity() {
        this.id = UUID.randomUUID();
    }

    public UserEntity(UUID id, String firstName, String lastName, String email, String password, UserType type, String job, boolean searchJob, UserGrade grade, String course, byte[] profilePicture, CompanyEntity company, SchoolEntity school) {
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
        this.company = company;
        this.school = school;
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

    public CompanyEntity getCompany() {
        return this.company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public SchoolEntity getSchool() {
        return this.school;
    }

    public void setSchool(SchoolEntity school) {
        this.school = school;
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
                ", companyId=" + this.company +
                ", schoolId=" + this.school +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof UserEntity userEntity)) {
            return false;
        }
        return this.searchJob == userEntity.isSearchJob() && Objects.equals(this.id, userEntity.getId()) && Objects.equals(this.firstName, userEntity.getFirstName()) && Objects.equals(this.lastName, userEntity.getLastName()) && Objects.equals(this.email, userEntity.getEmail()) && Objects.equals(this.password, userEntity.getPassword()) && this.type == userEntity.getType() && Objects.equals(this.job, userEntity.getJob()) && this.grade == userEntity.getGrade() && Objects.equals(this.course, userEntity.getCourse()) && Arrays.equals(this.profilePicture, userEntity.getProfilePicture()) && Objects.equals(this.company, userEntity.getCompany()) && Objects.equals(this.school, userEntity.getSchool());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.firstName, this.lastName, this.email, this.password, this.type, this.job, this.searchJob, this.grade, this.course, this.company, this.school);
        result = 31 * result + Arrays.hashCode(this.profilePicture);
        return result;
    }
}

package com.example.linkswiftbackend.model.dto;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private String name;
    private String description;
    private int salary;
    private String gradeRequired;
    private boolean remotePossible;
    private boolean internshipPossible;
    private boolean alternationPossible;
    private Date publicationDate;
    private UUID companyId;

    public OfferDto(UUID id, String name, String description, int salary, String gradeRequired, boolean remotePossible, boolean internshipPossible, boolean alternationPossible, Date publicationDate, UUID companyId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.gradeRequired = gradeRequired;
        this.remotePossible = remotePossible;
        this.internshipPossible = internshipPossible;
        this.alternationPossible = alternationPossible;
        this.publicationDate = publicationDate;
        this.companyId = companyId;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGradeRequired() {
        return this.gradeRequired;
    }

    public void setGradeRequired(String gradeRequired) {
        this.gradeRequired = gradeRequired;
    }

    public boolean isRemotePossible() {
        return this.remotePossible;
    }

    public void setRemotePossible(boolean remotePossible) {
        this.remotePossible = remotePossible;
    }

    public boolean isInternshipPossible() {
        return this.internshipPossible;
    }

    public void setInternshipPossible(boolean internshipPossible) {
        this.internshipPossible = internshipPossible;
    }

    public boolean isAlternationPossible() {
        return this.alternationPossible;
    }

    public void setAlternationPossible(boolean alternationPossible) {
        this.alternationPossible = alternationPossible;
    }

    public Date getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public UUID getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "OfferDto{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", salary=" + this.salary +
                ", gradeRequired='" + this.gradeRequired + '\'' +
                ", remotePossible=" + this.remotePossible +
                ", internshipPossible=" + this.internshipPossible +
                ", alternationPossible=" + this.alternationPossible +
                ", publicationDate=" + this.publicationDate +
                ", companyId=" + this.companyId +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof OfferDto offerDto)) {
            return false;
        }
        return this.salary == offerDto.getSalary() && this.remotePossible == offerDto.isRemotePossible() && this.internshipPossible == offerDto.isInternshipPossible() && this.alternationPossible == offerDto.isAlternationPossible() && Objects.equals(this.id, offerDto.getId()) && Objects.equals(this.name, offerDto.getName()) && Objects.equals(this.description, offerDto.getDescription()) && Objects.equals(this.gradeRequired, offerDto.getGradeRequired()) && Objects.equals(this.publicationDate, offerDto.getPublicationDate()) && Objects.equals(this.companyId, offerDto.getCompanyId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.salary, this.gradeRequired, this.remotePossible, this.internshipPossible, this.alternationPossible, this.publicationDate, this.companyId);
    }
}

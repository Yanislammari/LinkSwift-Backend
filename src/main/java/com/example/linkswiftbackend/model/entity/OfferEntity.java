package com.example.linkswiftbackend.model.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "salary", nullable = false)
    private int salary;
    @Column(name = "grade_required", nullable = false)
    private String gradeRequired;
    @Column(name = "remote_possible", nullable = false)
    private boolean remotePossible;
    @Column(name = "internship_possible", nullable = false)
    private boolean internshipPossible;
    @Column(name = "alternation_possible", nullable = false)
    private boolean alternationPossible;
    @Column(name = "publication_date", nullable = false)
    private Date publicationDate;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    public OfferEntity(){
        this.id = UUID.randomUUID();
    }

    public OfferEntity(UUID id, String name, String description, int salary, String gradeRequired, boolean remotePossible, boolean internshipPossible, boolean alternationPossible, Date publicationDate, CompanyEntity company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.gradeRequired = gradeRequired;
        this.remotePossible = remotePossible;
        this.internshipPossible = internshipPossible;
        this.alternationPossible = alternationPossible;
        this.publicationDate = publicationDate;
        this.company = company;
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

    public CompanyEntity getCompany() {
        return this.company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", salary=" + this.salary +
                ", gradeRequired='" + this.gradeRequired + '\'' +
                ", remotePossible=" + this.remotePossible +
                ", internshipPossible=" + this.internshipPossible +
                ", alternationPossible=" + this.alternationPossible +
                ", publicationDate=" + this.publicationDate +
                ", company=" + this.company +
                '}';
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof OfferEntity offerEntity)){
            return false;
        }
        return this.salary == offerEntity.salary && this.remotePossible == offerEntity.remotePossible && this.internshipPossible == offerEntity.internshipPossible && this.alternationPossible == offerEntity.alternationPossible && Objects.equals(this.id, offerEntity.id) && Objects.equals(this.name, offerEntity.name) && Objects.equals(this.description, offerEntity.description) && Objects.equals(this.gradeRequired, offerEntity.gradeRequired) && Objects.equals(this.publicationDate, offerEntity.publicationDate) && Objects.equals(this.company, offerEntity.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.salary, this.gradeRequired, this.remotePossible, this.internshipPossible, this.alternationPossible, this.publicationDate, this.company);
    }
}

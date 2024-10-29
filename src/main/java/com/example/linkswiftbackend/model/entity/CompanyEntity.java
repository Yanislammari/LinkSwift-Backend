package com.example.linkswiftbackend.model.entity;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "descripton")
    private String description;
    @Column(name = "expertise_area")
    private String expertiseArea;
    @Column(name = "website")
    private String website;
    @Lob
    @Column(name = "picture", columnDefinition = "LONGBLOB")
    private byte[] picture;

    public CompanyEntity() {
        this.id = UUID.randomUUID();
    }

    public CompanyEntity(UUID id, String name, String description, String expertiseArea, String website, byte[] picture) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expertiseArea = expertiseArea;
        this.website = website;
        this.picture = picture;
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

    public String getExpertiseArea() {
        return this.expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", expertiseArea='" + this.expertiseArea + '\'' +
                ", website='" + this.website + '\'' +
                ", picture='" + Arrays.toString(this.picture) + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof CompanyEntity companyEntity)) {
            return false;
        }
        return Objects.equals(this.id, companyEntity.getId()) && Objects.equals(this.name, companyEntity.getName()) && Objects.equals(this.description, companyEntity.getDescription()) && Objects.equals(this.expertiseArea, companyEntity.getExpertiseArea()) && Objects.equals(this.website, companyEntity.getWebsite()) && Arrays.equals(this.picture, companyEntity.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.name, this.description, this.expertiseArea, this.website);
        result = 31 * result + Arrays.hashCode(this.picture);
        return result;
    }
}

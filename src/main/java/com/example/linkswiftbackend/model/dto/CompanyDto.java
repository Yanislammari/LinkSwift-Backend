package com.example.linkswiftbackend.model.dto;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class CompanyDto {
    private UUID id;
    private String name;
    private String description;
    private String expertiseArea;
    private String website;
    private byte[] picture;

    public CompanyDto(UUID id, String name, String description, String expertiseArea, String website, byte[] picture) {
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
        return "CompanyDto{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", expertiseArea='" + this.expertiseArea + '\'' +
                ", website='" + this.website + '\'' +
                ", picture=" + Arrays.toString(this.picture) +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof CompanyDto companyDto)) {
            return false;
        }
        return Objects.equals(this.id, companyDto.getId()) && Objects.equals(this.name, companyDto.getName()) && Objects.equals(this.description, companyDto.getDescription()) && Objects.equals(this.expertiseArea, companyDto.getExpertiseArea()) && Objects.equals(this.website, companyDto.getWebsite()) && Arrays.equals(this.picture, companyDto.getPicture());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.name, this.description, this.expertiseArea, this.website);
        result = 31 * result + Arrays.hashCode(this.picture);
        return result;
    }
}

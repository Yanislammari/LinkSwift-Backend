package com.example.linkswiftbackend.model.dto;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class SchoolDto {
    private UUID id;
    private String name;
    private String description;
    private String website;
    private byte[] picture;

    public SchoolDto(UUID id, String name, String description, String website, byte[] picture) {
        this.id = id;
        this.name = name;
        this.description = description;
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
        return "SchoolDto{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", website='" + this.website + '\'' +
                ", picture=" + Arrays.toString(this.picture) +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof SchoolDto schoolDto)) {
            return false;
        }
        return Objects.equals(this.id, schoolDto.getId()) && Objects.equals(this.name, schoolDto.getName()) && Objects.equals(this.description, schoolDto.getDescription()) && Objects.equals(this.website, schoolDto.getWebsite()) && Arrays.equals(this.picture, schoolDto.getPicture());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.name, this.description, this.website);
        result = 31 * result + Arrays.hashCode(this.picture);
        return result;
    }
}

package com.example.linkswiftbackend.model.entity;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "schools")
public class SchoolEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "website")
    private String website;
    @Lob
    @Column(name = "picture", columnDefinition = "LONGBLOB")
    private byte[] picture;

    public SchoolEntity() {
        this.id = UUID.randomUUID();
    }

    public SchoolEntity(UUID id, String name, String description, String website, byte[] picture) {
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
        return "SchoolEntity{" +
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
        if(!(object instanceof SchoolEntity schoolEntity)) {
            return false;
        }
        return Objects.equals(this.id, schoolEntity.getId()) && Objects.equals(this.name, schoolEntity.getName()) && Objects.equals(this.description, schoolEntity.getDescription()) && Objects.equals(this.website, schoolEntity.getWebsite()) && Arrays.equals(this.picture, schoolEntity.getPicture());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.name, this.description, this.website);
        result = 31 * result + Arrays.hashCode(this.picture);
        return result;
    }
}

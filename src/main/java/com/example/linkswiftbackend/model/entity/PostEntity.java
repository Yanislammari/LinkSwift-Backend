package com.example.linkswiftbackend.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "content", nullable = false)
    private String content;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "categories", columnDefinition = "json")
    private List<String> categories;
    @Lob
    @Column(name = "media", columnDefinition = "LONGBLOB")
    private byte[] media;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public PostEntity() {
        this.id = UUID.randomUUID();
    }

    public PostEntity(UUID id, String content, List<String> categories, byte[] media, UserEntity user) {
        this.id = id;
        this.content = content;
        this.categories = categories;
        this.media = media;
        this.user = user;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public byte[] getMedia() {
        return this.media;
    }

    public void setMedia(byte[] media) {
        this.media = media;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + this.id +
                ", content='" + this.content + '\'' +
                ", categories=" + this.categories +
                ", media=" + Arrays.toString(this.media) +
                ", user=" + this.user +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PostEntity postEntity)) {
            return false;
        }
        return Objects.equals(this.id, postEntity.id) &&
                Objects.equals(this.content, postEntity.content) &&
                Objects.equals(this.categories, postEntity.categories) &&
                Arrays.equals(this.media, postEntity.media) &&
                Objects.equals(this.user, postEntity.user);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.content, this.categories, this.user);
        result = 31 * result + Arrays.hashCode(this.media);
        return result;
    }
}

package com.example.linkswiftbackend.model.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PostDto {
    private UUID id;
    private String content;
    private List<String> categories;
    private byte[] media;
    private UUID userId;

    public PostDto(UUID id, String content, List<String> categories, byte[] media, UUID userId) {
        this.id = id;
        this.content = content;
        this.categories = categories;
        this.media = media;
        this.userId = userId;
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

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + this.id +
                ", content='" + this.content + '\'' +
                ", categories=" + this.categories +
                ", media=" + Arrays.toString(this.media) +
                ", userId=" + this.userId +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) {
            return true;
        }
        if(!(object instanceof PostDto postDto)) {
            return false;
        }
        return Objects.equals(this.id, postDto.id) && Objects.equals(this.content, postDto.content) && Objects.equals(this.categories, postDto.categories) && Arrays.equals(this.media, postDto.media) && Objects.equals(this.userId, postDto.userId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.id, this.content, this.categories, this.userId);
        result = 31 * result + Arrays.hashCode(media);
        return result;
    }
}

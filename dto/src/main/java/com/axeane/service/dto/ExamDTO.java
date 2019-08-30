package com.axeane.service.dto;

import javax.validation.constraints.NotNull;

public class ExamDTO {

    private Long id;

    @NotNull(message = "you need to insert a title")
    private String title;
    @NotNull(message = "you need to insert a description")
    private String description;


    @NotNull(message = "published is null")
    private Boolean published;

    public ExamDTO(Long id, @NotNull(message = "you need to insert a title") String title, @NotNull(message = "you need to insert a description") String description, @NotNull(message = "published is null") Boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public ExamDTO() {
    }

    public ExamDTO(@NotNull String title, @NotNull String description, @NotNull Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}

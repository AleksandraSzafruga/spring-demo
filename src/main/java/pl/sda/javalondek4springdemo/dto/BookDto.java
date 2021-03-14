package pl.sda.javalondek4springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//DTO - data transfer object
public class BookDto {

    private Long id;

    @JsonProperty("autor")
    private String author;

    @JsonProperty("tytuł")
    private String title;

    public BookDto(Long id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

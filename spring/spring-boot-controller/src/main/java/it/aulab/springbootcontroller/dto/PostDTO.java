package it.aulab.springbootcontroller.dto;

public class PostDTO {
    private Long id;

    private String title;
    private String body;
    private Integer bodyLenght;
    private String publishDate;

    private String authorFirstName; // author.firstName
    private String authorLastName;  // author.lastName
    private String authorEmail;     // author.email

    public PostDTO() {
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getAuthorFirstName() {
        return authorFirstName;
    }
    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }
    public String getAuthorLastName() {
        return authorLastName;
    }
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }
    public String getAuthorEmail() {
        return authorEmail;
    }
    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
    
    public Integer getBodyLenght() {
        return bodyLenght;
    }
    public void setBodyLenght(Integer bodyLenght) {
        this.bodyLenght = bodyLenght;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}

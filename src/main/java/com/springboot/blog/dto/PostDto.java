package com.springboot.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Set;

@Data
public class PostDto {
    private long id;

    @NotEmpty(message = "title should not be empty")
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @NotEmpty(message = "message should not be empty")
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;

    @NotEmpty(message = "content should not be empty")
    @Size(min = 15, message = "Post content should have at least 15 characters")
    private String content;

    private Set<CommentDto> comments;
}

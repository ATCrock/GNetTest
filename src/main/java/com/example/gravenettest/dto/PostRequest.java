package com.example.gravenettest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty
    private String content;
    @JsonProperty("post_id")
    private Integer postId;
    private String title;
}

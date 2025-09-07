package com.example.gravenettest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteRequest {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("user_id")
    private Integer userId;
}

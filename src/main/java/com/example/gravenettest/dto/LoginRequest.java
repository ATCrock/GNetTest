package com.example.gravenettest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginRequest {
    @JsonProperty
    private String username;
    private String name;
    private String password;
    @JsonProperty("user_id")
    private Integer id;
    private Integer user_type;
}

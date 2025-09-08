package com.example.gravenettest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestLite {
    @JsonProperty
    @Size(min=8, max = 16)
    private String username;
    @Size(min=8, max = 16)
    private String password;
}

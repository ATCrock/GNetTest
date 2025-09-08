package com.example.gravenettest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @JsonProperty
    private Integer id;
    private String username;
    private String name;
    private String password;
    private Integer user_type;

    public RegisterRequest(Integer Id, Integer user_type){
        this.id = Id;
        this.user_type = user_type;
    }
}

package com.example.gravenettest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {
    @JsonProperty
    private Integer user_id;
    private Integer user_type;

    public LoginResponse(Integer user_id){
        this.user_id = user_id;
    }


}

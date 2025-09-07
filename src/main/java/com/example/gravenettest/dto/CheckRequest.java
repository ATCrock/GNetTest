package com.example.gravenettest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckRequest {
    @JsonProperty("user_id")
    private Integer userId;

    /**
     *
     */
    @JsonProperty("report_id")
    private Integer reportId;

    private Integer approval;
}

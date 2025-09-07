package com.example.gravenettest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Checkdata {
    @JsonProperty("user_id")
    private Integer userId;

    /**
     *
     */
    @JsonProperty("report_id")
    private Integer reportId;

    private Integer approval;
}

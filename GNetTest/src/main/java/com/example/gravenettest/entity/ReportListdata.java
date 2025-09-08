package com.example.gravenettest.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportListdata {
    /**
     *
     */
    @JsonProperty("user_id")
    private Integer userId;

    /**
     *
     */
    @JsonProperty("post_id")
    private Integer postId;

    /**
     *
     */
    private String reason;

    /**
     *
     */
    private Integer status=0;

}

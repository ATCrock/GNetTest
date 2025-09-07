package com.example.gravenettest.result;

import com.example.gravenettest.entity.Postdata;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor // 任意参数构造器
@NoArgsConstructor
public class AjaxResult <T>{
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final String FAILED_MESSAGE = "FAIL";
    public static final String SUCCESS_CONSERVE = "SUCCESS_CONSERVE";
    public static final String SUCCESS_DELETE = "SUCCESS_DELETE";
    public static final String SUCCESS_POST =  "SUCCESS_POST";
    //    @JsonProperty("username")
//    private Integer username;
//    @JsonProperty("name")
//    private String name;
//    @Size(min=8, max = 16)
//    @JsonProperty("password")
//    private String password;
    private Integer code;
    private String message;
    private T user_data;
    //private T data;
    //private T user_type;


    public static <N> AjaxResult<N> success(){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MESSAGE, null);}

    public static <N> AjaxResult<N> success(N user_data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MESSAGE, user_data);}

    public static <N> AjaxResult<N> successConserve(){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_CONSERVE, null);}

    public static <N> AjaxResult<N> successConserve(N user_data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_CONSERVE, user_data);}
    public static <N> AjaxResult<N> successDelete(){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_DELETE, null);}

    public static <N> AjaxResult<N> successDelete(N user_data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_DELETE, user_data);}
    public static <N> AjaxResult<N> successPost(){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_POST, null);}

    public static <N> AjaxResult<N> successPost(N user_data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_POST, user_data);}
    // 懒得改了就这样吧,新建一个result就能返回一个换名字的data
    //public static <N> AjaxResult<N> success(N data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MESSAGE, data);}
    //public static List<Postdata> AjaxResult ;Object success(List<Postdata> post_data){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MESSAGE, post_data);}
    //public static <N> AjaxResult<N> success(N user_data, N user_type){return new AjaxResult<>(HttpStatus.OK.value(), SUCCESS_MESSAGE, user_data, user_type);}

    public static <N> AjaxResult<N> fail(){return new AjaxResult<>(HttpStatus.OK.value(), FAILED_MESSAGE, null);}
    public static <N> AjaxResult<N> fail(N user_data){return new AjaxResult<>(HttpStatus.OK.value(), FAILED_MESSAGE, user_data);}
}

package com.risk.provider.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/26.
 */
@Data
public class UserDto implements Serializable {
    private String name                ;
    private String cardName           ;
    private String cardNumber         ;
    private String sex                 ;
    private Date birthday            ;
    private String mobile              ;
    private String phone               ;
    private String qq                  ;
    private String email               ;
    private String address             ;
    private String status              ;
}

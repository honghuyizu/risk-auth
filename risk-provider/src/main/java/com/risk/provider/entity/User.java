package com.risk.provider.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/1.
 */
@Data
public class User extends BaseEntity<User> {
    private static final long serialVersionUID = 1L;

    private Integer id                  ;
    private String name                ;
    private String firstName          ;
    private String lastName           ;
    private String nickname            ;
    private String account             ;
    private String password            ;
    private String cardName           ;
    private String cardNumber         ;
    private String sex                 ;
    private Date birthday            ;
    private String mobile              ;
    private String phone               ;
    private String qq                  ;
    private String email               ;
    private String duty                ;
    private String address             ;
    private String zipcode             ;
    private String avatarPathName    ;
    private String status              ;
    private String roleIds            ;
}

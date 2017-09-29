package com.risk.api.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 注册DTO
 *
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ZhuCeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户名称
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 8, max = 16, message = "用户名长度在6-18位字符")
    private String yname;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(max = 32, message = "密码长度不能大于32位字符")
    private String miMa;

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String getMiMa() {
        return miMa;
    }

    public void setMiMa(String miMa) {
        this.miMa = miMa;
    }
}

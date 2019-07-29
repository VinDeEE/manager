package com.vd.common.data.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Desc: 测试实体类
 * Author: VinDe
 * Date: Create in 2019/7/26
 */
@Table(name = "Stu")
@Data
public class Stu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sNo;//主键
    private String sName;//
    private String sSex;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sAge;
}

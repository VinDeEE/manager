package com.vd.common.data.model.dto;


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
@Table(name = "Student")
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sID;//主键
    private String sName;//
    private String sSex;
    private Date sAge;
}

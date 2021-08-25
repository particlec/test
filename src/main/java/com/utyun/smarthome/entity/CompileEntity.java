package com.utyun.smarthome.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "pm_compileEntity")
public class CompileEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private String projectName;

    private String ulcName;

    private String input;

    private String compileLog;

    private Date compileDate;

}

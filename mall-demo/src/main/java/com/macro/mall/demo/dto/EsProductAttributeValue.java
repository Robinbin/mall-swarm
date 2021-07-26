package com.macro.mall.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EsProductAttributeValue implements Serializable {

    private static final long serialVersionUID = 5389314996024717942L;
    private Long id;
    private Long productAttributeId;
    private String value;
    private Integer type;
    private String name;
}

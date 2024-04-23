package com.xzit.practice.tree.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 该类用于：类别实体类
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 13:12
 */
@Data
public class ProductType implements Serializable {

    private Integer typeId;

    private Integer parentId;

    private String typeCode;

    private String typeName;

    private String typeDesc;

    private List<ProductType> childrenProductTypes;
}

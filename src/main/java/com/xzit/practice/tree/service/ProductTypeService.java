package com.xzit.practice.tree.service;

import com.xzit.practice.tree.domain.ProductType;
import com.xzit.practice.tree.mapper.ProductTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 14:07
 */
@Service
public class ProductTypeService {

    @Resource
    private ProductTypeMapper productTypeMapper;

    public List<ProductType> getProductTypesTree() {
        List<ProductType> allProductTypes = productTypeMapper.getAllProductTypes();
        return listToTree(allProductTypes, 0);
    }

    private List<ProductType> listToTree(List<ProductType> list, Integer parentId) {
//        return list;
        List<ProductType> typeList = new ArrayList<>();

        for (ProductType productType : list) {
            if (productType.getParentId().equals(parentId)) {
                typeList.add(productType);
            }
        }

        for (ProductType productType : typeList) {
            productType.setChildrenProductTypes(
                    listToTree(list, productType.getTypeId())
            );
        }

        return typeList;
    }
}

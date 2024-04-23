package com.xzit;

import com.xzit.practice.tree.domain.ProductType;
import com.xzit.practice.tree.mapper.ProductTypeMapper;
import com.xzit.practice.tree.service.ProductTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 该类用于：将链表转为链表树
 * </p>
 *
 * @author leizf
 * @since 2024-04-23 13:10
 */
@SpringBootTest
public class ProductTypeMapperTest {

    @Resource
    private ProductTypeService productTypeService;

    @Test
    void test0() {
        List<ProductType> list = productTypeService.getProductTypesTree();
        for (ProductType productType : list) {
            System.out.println(productType);
        }
    }
}

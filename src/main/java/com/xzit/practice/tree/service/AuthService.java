package com.xzit.practice.tree.service;

import com.xzit.practice.tree.domain.Auth;
import com.xzit.practice.tree.domain.ProductType;
import com.xzit.practice.tree.mapper.AuthMapper;
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
 * @since 2024-04-23 17:12
 */
@Service
public class AuthService {

    @Resource
    private AuthMapper authMapper;

    public List<Auth> getAuthTree() {
        List<Auth> allAuth = authMapper.getAllAuth();
        return listToTree(allAuth, 0);
    }

    private List<Auth> listToTree(List<Auth> list, Integer parentId) {
//        return list;
        List<Auth> treeList = new ArrayList<>();

        for (Auth auth : list) {
            if (auth.getParentId().equals(parentId)) {
                treeList.add(auth);
            }
        }

        for (Auth auth : treeList) {
            auth.setChildAuth(
                    listToTree(list, auth.getAuthId())
            );
        }

        return treeList;
    }
}

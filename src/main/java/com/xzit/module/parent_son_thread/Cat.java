package com.xzit.module.parent_son_thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 该类用于：模拟单个任务
 * </p>
 *
 * @author leizf
 * @since 2024-05-08 20:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Cat {

    private String catName;
}

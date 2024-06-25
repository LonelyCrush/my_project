package com.xzit.module.upload_io;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 该类用于：文件上传
 * </p>
 *
 * @author leizf
 * @since 2024-05-15 22:42
 */
@Data
@Component
@ConfigurationProperties(value = "store")
public class FIleProp {

    /**
     * 上传路径
     */
    private String uploadPath;

    /**
     * 文件类型
     */
    private String[] fileTypeArray;

    /**
     * 文件大小
     */
    private int maxFileSize;
}

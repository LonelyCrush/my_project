package com.xzit.module.upload_multi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-20 11:06
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public String upload(MultipartFile file) throws IOException {
        // 文件校验
        if (file.isEmpty()) return "上传失败！";

        // 获取原文件的信息
        System.out.println("========= 文件信息 =========");
        System.out.println("原始名：" + file.getOriginalFilename());
        System.out.println("原始类型：" + file.getContentType());
        System.out.println("===========================");

        // 处理存储路径
        String rawPath = "F:\\studying\\studying_project\\my_project\\src\\main\\resources\\upload\\";
        String username = "jack\\";
        String path = rawPath + username;

        // 保存文件
        boolean result = saveFile(file, path);

        // 返回结果
        return result ? "上传成功！" : "上传失败！";
    }

    private boolean saveFile(MultipartFile file, String path) throws IOException {
        // 处理存储路径
        File uploadPath = new File(path);
        if (!uploadPath.exists()) {
            boolean b = uploadPath.mkdirs();
            if (!b) {
                System.out.println("创建存储路径错误！");
                return false;
            }
        }

        // 处理存储文件
        File saveFile = new File(path + file.getOriginalFilename());

        // 保存
        file.transferTo(saveFile);

        // 返回
        return true;
    }
}

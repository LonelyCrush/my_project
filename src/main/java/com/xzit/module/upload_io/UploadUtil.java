package com.xzit.module.upload_io;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-05-15 22:45
 */
@Slf4j
public class UploadUtil {

    public static boolean upload(MultipartFile multipartFile, String uploadPath, String fileName) {
        // 1、构建文件对象
        File file = new File(uploadPath);

        // 2、目录不存在递归创建目录
        if (!file.exists()) {
            boolean b = file.mkdirs();
            if (!b) {
                log.error("创建目标文件夹错误！");
                return false;
            }
        }

        // 3、读出写入
        try(FileOutputStream fio = new FileOutputStream(uploadPath + fileName);
            InputStream is = multipartFile.getInputStream()) {
            // 原生
//            int len;
//            byte[] bytes = new byte[4 * 1024];
//            while ((len = is.read(bytes)) != -1) {
//                fio.write(bytes, 0, len);
//            }
            // 工具类
            int copy = FileCopyUtils.copy(is, fio);
            log.info("上传成功，文件大小：{}", copy);
            log.info("上传成功：{}", uploadPath + fileName);
            return true;
        } catch (IOException e) {
            log.error("文件上传错误！");
            e.printStackTrace();
        }

        return false;
    }
}

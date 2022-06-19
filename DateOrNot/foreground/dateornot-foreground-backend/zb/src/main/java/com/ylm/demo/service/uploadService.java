package com.ylm.demo.service;

import com.ylm.demo.pojo.UploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 数据上传接口
 */
public interface uploadService {
    /**
     * 上传方法，返回上传结果实体类
     * @Param 文件，类型（头像，消息，动态）
     */
    UploadResult upload(MultipartFile uploadFile, String type);

    /**
     * 获取上传目的地路径，返回路径字符串
     * @Param 文件名，类型（头像，消息，动态）
     */
    String getFilePath(String sourceFileName, String type);
}

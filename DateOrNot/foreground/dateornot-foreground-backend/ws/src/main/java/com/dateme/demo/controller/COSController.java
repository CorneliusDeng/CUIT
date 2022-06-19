package com.dateme.demo.controller;

import com.dateme.demo.TencentCOS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class COSController {

    /**
     * 把文件上传到腾讯云存储服务器
     * @param mulq
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    public ArrayList<String> upload(MultipartHttpServletRequest mulq)throws Exception{
        Map<String, MultipartFile> map = mulq.getFileMap();
        ArrayList<String> imgCosUrls = new ArrayList<>();
        for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
            String name = entry.getKey();
            MultipartFile multfile = entry.getValue();
            // 获取文件名
            String fileName = multfile.getOriginalFilename();
            // 获取文件后缀
            String prefix=fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            final File excelFile = File.createTempFile("imagesFile-"+System.currentTimeMillis(), prefix);
            // 将MultipartFile转为File
            multfile.transferTo(excelFile);
            //调用腾讯云工具上传文件
            String imgName = TencentCOS.uploadfile(excelFile);
            //程序结束时，删除临时文件
            deleteFile(excelFile);
            String domain = "https://dateme-1305813112.cos.ap-chengdu.myqcloud.com/";
            String cosFilename  = domain + imgName;
            imgCosUrls.add(cosFilename);
        }
        return imgCosUrls;
    }

    /**
     * 删除临时文件
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}

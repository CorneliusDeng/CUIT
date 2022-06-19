package com.ylm.demo.service;

import com.qcloud.cos.COSClient;
import com.ylm.demo.pojo.TcCosConfig;
import com.ylm.demo.pojo.UploadResult;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.Random;

/**
 * 文件上传
 */
@Service
public class UploadFileService implements uploadService {
    @Autowired
    private COSClient cosClient;

    @Autowired
    private TcCosConfig tcCosConfig;

    @Override
    public UploadResult upload(MultipartFile uploadFile, String filePath) {
        // 封装Result对象
        UploadResult fileUploadResult = new UploadResult();

        //上传文件
        try {
            // 指定要上传到的存储桶
            String bucketName = tcCosConfig.getBucketName();
            // 指定要上传到 COS 上对象键
            String key = filePath;
            //key是查找文件的依据
            cosClient.putObject(bucketName,key,new ByteArrayInputStream(uploadFile.getBytes()),null);
            //设置输出信息
            fileUploadResult.setStatus("done");
            fileUploadResult.setName(filePath);
            fileUploadResult.setResponse(this.tcCosConfig.getPath()+filePath);
            System.out.println("文件上传成功，路径："+this.tcCosConfig.getPath()+filePath);
            fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
            return fileUploadResult;
        }
        catch (Exception e){
            e.printStackTrace();
            fileUploadResult.setStatus("error: uploadFail");
            return fileUploadResult;
        }
    }

    /**
     * 生成文件路径
     * @param sourceFileName
     * @param type
     * @return
     */
    @Override
    public String getFilePath(String sourceFileName, String type) {
        DateTime dateTime = new DateTime();

        if (type.equals("audio")){ //音频
            return "audio/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + dateTime.toString("dd")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "$"
                    + sourceFileName;
        }else if (type.equals("video")){  //视频
            return "video/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "."
                    + StringUtils.substringAfterLast(sourceFileName, ".");
        }else if (type.equals("file")){   //文件
            return "file/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "$"
                    + sourceFileName;
        }
        return null;
    }
}

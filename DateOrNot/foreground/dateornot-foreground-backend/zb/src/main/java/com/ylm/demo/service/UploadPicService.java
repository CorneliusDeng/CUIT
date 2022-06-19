package com.ylm.demo.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.exception.CosClientException;
import com.ylm.demo.pojo.UploadResult;
import com.ylm.demo.pojo.TcCosConfig;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;
import java.io.ByteArrayInputStream;
import java.util.Random;

/**
 * 图片上传服务
 * 上传至腾讯云COS(对象存储中心)
 */
@Service
public class UploadPicService implements uploadService{

    @Autowired
    private COSClient cosClient;

    @Autowired
    private TcCosConfig tcCosConfig;

    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};

    @Override
    public UploadResult upload(MultipartFile uploadFile, String type){
        // 校验图片格式
        boolean isLegal = false;
        for(String typeL : IMAGE_TYPE){
            if(StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),typeL)){
                isLegal = true;
                break;
            }
        }
        // 封装Result对象
        UploadResult fileUploadResult = new UploadResult();
        if(!isLegal){
            fileUploadResult.setStatus("error:illegal file");
            return fileUploadResult;
        }

        // 設定文件存儲路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName,type);

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
            System.out.println("图片上传成功，访问路径："+this.tcCosConfig.getPath()+filePath);
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
     * 删除某个图片
     * @param key
     */
    public boolean deletePic(String key){
        try {
            // 指定对象所在的存储桶
            String bucketName = this.tcCosConfig.getBucketName();
            cosClient.deleteObject(bucketName, key);
            return true;
        } catch (CosClientException serverException) {
            serverException.printStackTrace();
            return false;
        }
    }

    /**
     * 根据时间和图片类型，生成文件存储路径
     * @param sourceFileName
     * @return
     */
    @Override
    public String getFilePath(String sourceFileName, String type) {
        DateTime dateTime = new DateTime();
        if (type.equals("msgPicture")){ //消息
            return "images/msgPicture/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + dateTime.toString("dd")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "."
                    + StringUtils.substringAfterLast(sourceFileName, ".");
        }else if (type.equals("headPicture")){  //头像
            return "images/headPicture/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "."
                    + StringUtils.substringAfterLast(sourceFileName, ".");
        }else if (type.equals("dynamicPicture")){   //动态
            return "images/dynamicPicture/"
                    + dateTime.toString("yyyy") + "/" + dateTime.toString("MM")
                    + "/" + System.currentTimeMillis()
                    + new Random().nextInt( 9999) + "."
                    + StringUtils.substringAfterLast(sourceFileName, ".");
        }
        return null;
    }
}
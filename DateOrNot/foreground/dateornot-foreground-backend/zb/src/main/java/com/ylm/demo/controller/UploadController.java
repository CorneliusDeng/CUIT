package com.ylm.demo.controller;

import com.ylm.demo.pojo.UploadResult;
import com.ylm.demo.service.UploadFileService;
import com.ylm.demo.service.UploadPicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Api
@CrossOrigin    //跨域处理
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    UploadPicService picUploadService;
    @Autowired
    UploadFileService uploadFileService;


    @PostMapping("/msgPicture")
    @ResponseBody
    @ApiOperation(value = "上传消息图片",notes = "POST")
    public UploadResult uploadMP(@RequestParam("picture") MultipartFile multipartFile) throws Exception{
        return this.picUploadService.upload(multipartFile,"msgPicture");
    }


    @PostMapping("/headPicture")
    @ResponseBody
    @ApiOperation(value = "上传头像",notes = "POST")
    public UploadResult uploadHP(@RequestParam("picture") MultipartFile multipartFile) throws Exception{
        return this.picUploadService.upload(multipartFile,"headPicture");
    }


    @PostMapping("/dynamicPicture")
    @ResponseBody
    @ApiOperation(value = "上传动态内容图片",notes = "POST")
    public UploadResult uploadDP(@RequestParam("picture") MultipartFile multipartFile) throws Exception{
        return this.picUploadService.upload(multipartFile,"dynamicPicture");
    }


    @PostMapping("/audio")
    @ResponseBody
    @ApiOperation(value = "上传音频文件",notes = "POST")
    public UploadResult uploadAD(@RequestParam("audio") MultipartFile multipartFile, @RequestParam("audioTime") String audioTime) throws Exception{

        String newFileName = audioTime+'$'+multipartFile.getOriginalFilename();
        System.out.println(newFileName);
        String filePath = this.uploadFileService.getFilePath(newFileName,"audio");
        return this.uploadFileService.upload(multipartFile,filePath);
    }


    @PostMapping("/video")
    @ResponseBody
    @ApiOperation(value = "上传视频文件",notes = "POST")
    public UploadResult uploadVD(@RequestParam("video") MultipartFile multipartFile) throws Exception{
        String filePath = this.uploadFileService.getFilePath(multipartFile.getOriginalFilename(),"video");
        return this.uploadFileService.upload(multipartFile,filePath);
    }


    @PostMapping("/file")
    @ResponseBody
    @ApiOperation(value = "上传文件",notes = "POST")
    public UploadResult uploadF(@RequestParam("file") MultipartFile multipartFile) throws Exception{
        String filePath = this.uploadFileService.getFilePath(multipartFile.getOriginalFilename(),"file");
        return this.uploadFileService.upload(multipartFile,filePath);
    }
}

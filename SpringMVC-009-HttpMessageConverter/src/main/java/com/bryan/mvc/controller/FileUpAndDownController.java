package com.bryan.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDownload")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取Servlet上下文对象
        ServletContext servletContext = session.getServletContext();

        // 获取静态资源的真实地址
        String realPath = servletContext.getRealPath("/static/image/test.jpg");
        System.out.println(realPath);

        // 创建输入流
        FileInputStream fis = new FileInputStream(realPath);

        // 创建字节数组，其大小为输入流指向的文件的大小
        byte[] bytes = new byte[fis.available()];

        // 将输入流写到字节数组中
        int read = fis.read(bytes);

        // 创建HttpHeaders对象并设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载方式和下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=test.jpg");

        // 设置HTTP响应状态码
        HttpStatus statusCode = HttpStatus.OK;

        // 创建ResponseEntity对象
        // ResponseEntity(响应体, 响应头, 状态码)
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);

        fis.close();
        return responseEntity;
    }

    // MultipartFile封装了上传文件的类型
    @PostMapping("/testFileUpload")
    public String testFileUpload(MultipartFile picture,
                                 HttpSession session) throws IOException {
        // 获取文件名
        String fileName = picture.getOriginalFilename();

        // 获取文件后缀名
        String suffixName = null;
        if (fileName != null) {
            suffixName = fileName.substring(fileName.lastIndexOf('.'));
        }

        // 用UUID当作文件名
        String finalFileName = UUID.randomUUID() + suffixName;

        // 获取ServletContext获取服务器中picture文件夹的路径
        ServletContext context = session.getServletContext();
        String picturePath = context.getRealPath("picture");

        File file = new File(picturePath);
        // 判断photoPath对应的文件夹是否存在
        if (!file.exists()) {
            // 如果不存在则创建文件夹
            boolean ret = file.mkdir();
        }

        // 确定上传文件的最终路径
        String finalPath = picturePath + "/" + finalFileName;
        picture.transferTo(new File(finalPath));
        return "success";
    }
}

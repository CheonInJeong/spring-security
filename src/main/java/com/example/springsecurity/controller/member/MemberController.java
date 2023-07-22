package com.example.springsecurity.controller.member;

import com.example.springsecurity.error.type.CustomException;
import com.example.springsecurity.utils.SFTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@Slf4j
public class MemberController {
    @Value("${sftp.host}")
    private String host;

    @Value("${sftp.port}")
    private int port;

    @Value("${sftp.username}")
    private String username;

    @Value("${sftp.password}")
    private String password;

    @Value("${sftp.key}")
    private String key;

    @GetMapping("/login")
    public String memberLogin() {
        return "member/login";
    }

    @GetMapping("/register")
    public String memberRegister() {
        return "member/register";
    }

    @GetMapping("/ftp")
    public void ftp() {
        //SFTPUtils.connectSFTP(host,port,username, password);
       // throw new NoSuchElementException();
        throw new CustomException("test exception");
       // SFTPUtils.connectSFTP_key(host, port, username , key);
        //SFTPUtils.uploadFile("/Users/chenchen/Desktop/test/test.png","/home/injeong");
    }
}

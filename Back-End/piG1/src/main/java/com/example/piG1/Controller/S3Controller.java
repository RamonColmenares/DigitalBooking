package com.example.piG1.Controller;

import com.example.piG1.Service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping(value = "upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestPart(value = "files") MultipartFile[] files) {

        Map<String, String> response = new LinkedHashMap<>();

        for (MultipartFile file: files) {
            String key = s3Service.uploadFile(file);

            response.put("Key", key);
            response.put("Url", s3Service.getObjectUrl(key));
        }

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<String>> listFiles() {
        return new ResponseEntity<List<String>>(s3Service.getObjectFromS3(), HttpStatus.OK);
    }
}

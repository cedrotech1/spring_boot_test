package com.camel.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.camel.demo.service.FileUploadService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "destination", defaultValue = "D://dest") String destination) {
        Map<String, Object> response = new HashMap<>();
        try {
            fileUploadService.uploadFile(file, destination);
            response.put("status", 200);
            response.put("message", "File uploaded successfully to: " + destination);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", 400);
            response.put("message", "Failed to upload file: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/get/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            Resource file = fileUploadService.loadFileAsResource(filename);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", 404);
            response.put("message", "File not found: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> listFiles() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<String> files = fileUploadService.listFiles();
            response.put("status", 200);
            response.put("message", "Files listed successfully.");
            response.put("files", files);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", 500);
            response.put("message", "Failed to list files: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

package com.camel.demo.service;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    @Value("${file.upload.directory:D://dest}")
    private String uploadDirectory;

    @Autowired
    private ProducerTemplate producerTemplate;

    public void uploadFile(MultipartFile file, String destination) {
        try {
            // Create destination directory if it doesn't exist
            Path destinationPath = Paths.get(destination);
            if (!Files.exists(destinationPath)) {
                Files.createDirectories(destinationPath);
            }

            Map<String, Object> headers = new HashMap<>();
            headers.put("CamelFileName", file.getOriginalFilename());
            
            producerTemplate.sendBodyAndHeaders(
                String.format("file:%s?fileName=${header.CamelFileName}", destination),
                file.getBytes(),
                headers
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file: " + e.getMessage(), e);
        }
    }

    public Resource loadFileAsResource(String filename) {
        try {
            Path filePath = Paths.get(uploadDirectory).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            
            if(resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found: " + filename);
            }
        } catch (Exception e) {
            throw new RuntimeException("File not found: " + filename);
        }
    }

    public List<String> listFiles() {
        try {
            Path root = Paths.get(uploadDirectory);
            if (!Files.exists(root)) {
                Files.createDirectories(root);
                return List.of();
            }
            return Files.walk(root, 1)
                .filter(path -> !path.equals(root))
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to list files", e);
        }
    }
}

package com.example.demo.controller;

import com.example.demo.model.Doc;
import com.example.demo.service.DocStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "/")
public class DocController {

    @Autowired
    private DocStorageService docStorageService;

    @GetMapping("/")
    public List get(Doc doc) {
        List<Doc> docs = docStorageService.getFiles();
        return docs;
    }

    @PostMapping(value = "/uploadFile")
    public String uploadMultipleFiles(@RequestParam("files")MultipartFile[] files) {
        for (MultipartFile file: files) {
            docStorageService.saveFile(file);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable long fileId) {
        Doc doc = docStorageService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getDocName() + "\"")
                .body(new ByteArrayResource(doc.getData()));
    }


}

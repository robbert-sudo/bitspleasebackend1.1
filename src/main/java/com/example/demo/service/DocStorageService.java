package com.example.demo.service;

import com.example.demo.model.Doc;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface DocStorageService {


    List<Doc> getFiles();

    Doc saveFile(MultipartFile file);

    Optional<Doc> getFile(Long fileId);
}

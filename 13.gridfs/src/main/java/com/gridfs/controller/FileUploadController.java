package com.gridfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gridfs.service.FileUploadService;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping
	public void fileUpload(@RequestParam MultipartFile file) throws Exception{
		fileUploadService.fileUpload(file);
	}
}

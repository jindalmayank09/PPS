package com.pps.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pps.excel.helper.PdfHelper;
import com.pps.model.DBFile;
import com.pps.model.Tutorial;
import com.pps.payload.UploadFileResponse;
import com.pps.service.DBFileStorageService;

@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private DBFileStorageService dbFileStorageService;

	@GetMapping("/uploadExcelFile")
	public ModelAndView uploadExcelFile() {
		logger.info("FileController having uploadExcelFile()");
		return new ModelAndView("uploadExcel", "childSize", dbFileStorageService.getTotalChilds());
	}

	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		logger.info("FileController having uploadFile()");
		DBFile dbFile = dbFileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/viewChildData")
				.toUriString();
		logger.info("FileController having uploadFile() having file name:::" + file.getOriginalFilename());
		return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
		// Load file from database
		DBFile dbFile = dbFileStorageService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));
	}

	@GetMapping("/viewChildData")
	public ModelAndView viewChildData() {
		List<Tutorial> childData2 = dbFileStorageService.getChildData();
		return new ModelAndView("viewExcelData", "childObj", childData2);
		
	}

	@PostMapping("/printCard")
	public String printCard(@RequestBody Tutorial tutorial) {
		 PdfHelper.createPdf(tutorial);
		 return "Your Card is saved in C:\\Users\\Your PC Name\\exported\\pdf ";
	}

	@PostMapping("/searchUserData")
	public ModelAndView searchUserData(@RequestParam("searchUserBox") String searchVal) {
		List<Tutorial> childData = dbFileStorageService.searchChildData(searchVal);
		ModelAndView modelView = new ModelAndView("searchExcelData");
		modelView.addObject("childObj", childData);
		modelView.addObject("searchParam", searchVal);
		return modelView;
	}
}

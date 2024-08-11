package com.pps.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pps.excel.helper.ExcelHelper;
import com.pps.exception.FileStorageException;
import com.pps.exception.MyFileNotFoundException;
import com.pps.model.DBFile;
import com.pps.model.Tutorial;
import com.pps.repository.DBFileRepository;
import com.pps.repository.TutorialRepository;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    @Autowired
    private TutorialRepository tutorialRepository;

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            tutorials.forEach(c->c.setExcelMaster(dbFile));
            dbFile.setExcelChild(tutorials);
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

	public List<Tutorial> getChildData() {
		return tutorialRepository.findAll();
	}

	public List<Tutorial> searchChildData(String searchVal) {
		return tutorialRepository.searchByUserInput(searchVal);
	}
	public long getTotalChilds() {
		return tutorialRepository.count();
	}

    public Tutorial storeTutorialData(Tutorial tutorial) {
    	DBFile dbFile = new DBFile();
        prepareMasterBean(dbFile);
        tutorial.setCreationDate(new Date());
        List<Tutorial> list = new ArrayList<Tutorial>();
        tutorial.setExcelMaster(dbFile);
        list.add(tutorial);
        dbFile.setExcelChild(list);
		return dbFileRepository.save(dbFile).getExcelChild().get(0);
    }
    public void prepareMasterBean(DBFile dbFile) {
    	dbFile.setData(null);
    	dbFile.setFileName("Book1.xlsx");
    	dbFile.setFileType("xlsx");
    	
    } 
}

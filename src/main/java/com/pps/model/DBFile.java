package com.pps.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "excel_master")
public class DBFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "master_id")
    private long excelMasterId;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    
	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "excelMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Tutorial> excelChild = new ArrayList<>();


    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public long getExcelMasterId() {
        return excelMasterId;
    }

    public void setExcelMasterId(long id) {
        this.excelMasterId = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

	public List<Tutorial> getExcelChild() {
		return excelChild;
	}

	public void setExcelChild(List<Tutorial> excelChild) {
		this.excelChild = excelChild;
	}
}

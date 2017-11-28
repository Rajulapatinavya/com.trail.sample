package com.trail.sample.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtility {

	
	public void createDir(String path){
		try{
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String multiPartFileValidateAndDeleteRewrite(String path,MultipartFile multipartFile,String filePath,String existFilePath,String absolutePath){
		try{
			if(multipartFile!=null){
				if(multipartFile.getSize()>0){
					deleteFile(path+existFilePath);
					String returnPath = writeMultiPartFile(filePath,multipartFile);
					return absolutePath+returnPath;
				}else{
					return existFilePath;
				}
			}else{
				return existFilePath;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String writeMultiPartFile(String filePath, MultipartFile multipartFile) {
		if(multipartFile!=null){
			if(multipartFile.getSize()>0){
				String fileName = System.currentTimeMillis() + "-" + multipartFile.getOriginalFilename();
				try{
					createDir(filePath);
					filePath+=fileName;
					fileName = writeToDisk(filePath,multipartFile);
					return fileName;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public String writeToDisk(String path, MultipartFile multipartFile) {
		try {
			if (multipartFile != null) {
				File file = new File(path);
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(multipartFile.getBytes());
				fos.close();
				return file.getName();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return path;
	}
	
	public void deleteFile(String path){
		try{
			File file = new File(path);
			if (file.exists()) {
				file.delete();
				System.out.println("Deleted Succes");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

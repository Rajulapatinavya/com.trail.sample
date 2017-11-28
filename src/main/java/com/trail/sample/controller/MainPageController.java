package com.trail.sample.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trail.sample.pojo.ProfileInfo;
import com.trail.sample.repo.ProfileInfoRepo;
import com.trail.sample.util.FileUtility;

@Controller
public class MainPageController {
	
	
	@Autowired
	private ProfileInfoRepo profileInfoRepo;
	
	@Autowired
	private FileUtility fileUtility;
	
	@PostConstruct
	public void init(){
		System.out.println("Intialization for Main Page Controller");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openIndePage(ModelMap model){
		model.put("profileInfo", new ProfileInfo());
		addStaticModelAttributes(model);
		return "index";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postInfoEdit(@ModelAttribute ProfileInfo profileInfo,ModelMap model){
		if(profileInfo.getProfileId()!=null){
			ProfileInfo profileDB = profileInfoRepo.findOne(profileInfo.getProfileId());
			model.put("profileInfo",profileDB);
		}
		addStaticModelAttributes(model);
		return "index";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postInfoDelete(@ModelAttribute ProfileInfo profileInfo,ModelMap model){
		if(profileInfo.getProfileId()!=null){
			String filePath = System.getProperty("user.home");
			ProfileInfo profileDB = profileInfoRepo.findOne(profileInfo.getProfileId());
			fileUtility.deleteFile(filePath+"/"+profileDB.getProfileFilePath());
			profileInfoRepo.delete(profileDB);
		}
		addStaticModelAttributes(model);
		return "index";
	}
	
	@RequestMapping(value = "/postInfo", method = RequestMethod.POST)
	public String postInfo(@ModelAttribute ProfileInfo profileInfo,ModelMap model){
		
		String filePath = System.getProperty("user.home") + "/Profiles/";
		String shortImagePath = System.getProperty("user.home") + "/";
		String existPath = "";
		if(profileInfo.getProfileId()!=null){
			ProfileInfo profileDB = profileInfoRepo.findOne(profileInfo.getProfileId());
			if(profileDB!=null){
				existPath = profileDB.getProfileFilePath();
			}
		}
		if(profileInfo.getProfileFile()!=null && profileInfo.getProfileFile().getSize()>0){
			String path = fileUtility.multiPartFileValidateAndDeleteRewrite(shortImagePath,
					profileInfo.getProfileFile(), filePath,
					existPath, "Profiles/");
			profileInfo.setProfileFilePath(path);
		}
		profileInfoRepo.save(profileInfo);
		model.put("profileInfo", new ProfileInfo());
		addStaticModelAttributes(model);
		return "index";
	}
	
	@RequestMapping(value = "/allProfileInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<ProfileInfo> getAllProfileInfo(){
		return profileInfoRepo.findAll();
	}
	
	public void addStaticModelAttributes(ModelMap model){
		List<ProfileInfo> profileInfoList = profileInfoRepo.findAll();
		model.put("profileInfoList", profileInfoList);
	}
}

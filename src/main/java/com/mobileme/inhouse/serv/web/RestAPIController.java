package com.mobileme.inhouse.serv.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobileme.inhouse.serv.api.HSArticleInfo;
import com.mobileme.inhouse.serv.api.HSFullArticleInfo;
import com.mobileme.inhouse.serv.api.HSRequestAuth;
import com.mobileme.inhouse.serv.api.HSRequestProfile;
import com.mobileme.inhouse.serv.api.HSRequestRegister;
import com.mobileme.inhouse.serv.api.HSRequestRequest;
import com.mobileme.inhouse.serv.api.HSRespNewsList;
import com.mobileme.inhouse.serv.api.HSRespPrefs;
import com.mobileme.inhouse.serv.api.HSRespProfile;
import com.mobileme.inhouse.serv.api.HSRespRequestsList;
import com.mobileme.inhouse.serv.api.HSRespSuccess;
import com.mobileme.inhouse.serv.api.IRestApi;
import com.mobileme.inhouse.serv.model.HSPhoto;
import com.mobileme.inhouse.serv.service.Service;

@Controller
@RequestMapping(value = "restapi")
public class RestAPIController implements IRestApi {
	@Autowired
	Service service;
	@Autowired
	private ObjectMapper jacksonMapper;	
	
	@Override
	@RequestMapping(value = "/getprefs", method = RequestMethod.GET)
	public @ResponseBody HSRespPrefs getPrefs()  {
		return service.getPrefs();
	}

	@RequestMapping(value = "/getphotoslistwoimage", method = RequestMethod.GET)
	public @ResponseBody List<HSPhoto> getPhotosWoImage()  {
		return service.getPhotosWoImage();
	}

	@RequestMapping(value = "/getphotomini", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}, method = RequestMethod.GET)
	public @ResponseBody byte[] getPhotoMini(@RequestParam Long idx)  {
		return service.getPhotoMini(idx).getImagemini();
	}
	@RequestMapping(value = "/getphoto", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}, method = RequestMethod.GET)
	public @ResponseBody byte[] getPhoto(@RequestParam Long idx)  {
		return service.getPhoto(idx).getImage();
	}
	
	@RequestMapping(value = "/addphoto", method = RequestMethod.POST)
	public @ResponseBody HSRespSuccess addPhoto(@RequestBody HSPhoto photo)  {		
		return service.addPhoto(photo);
	}

	@Override
	public HSRespSuccess register(HSRequestRegister requestRegister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespSuccess login(HSRequestAuth requestAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespProfile getProfile(HSRequestAuth requestAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespSuccess updateProfile(HSRequestProfile requestProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespSuccess addRequest(HSRequestRequest requestRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespSuccess updateRequest(HSRequestRequest requestRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespSuccess deleteRequest(HSRequestRequest requestRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespRequestsList getRequestsList(HSRequestAuth requestAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSRespNewsList getNewsList(HSRequestAuth requestAuth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HSFullArticleInfo getArticle(HSArticleInfo requestArticleInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.mobileme.inhouse.serv.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mobileme.inhouse.serv.api.HSRespPrefs;
import com.mobileme.inhouse.serv.api.HSRespSuccess;
import com.mobileme.inhouse.serv.dao.Dao;
import com.mobileme.inhouse.serv.dao.DaoHB;
import com.mobileme.inhouse.serv.model.HSPhoto;
import com.mobileme.inhouse.serv.utils.Utils;

@Component
public class Service {

	@Autowired
	Dao dao;
	@Autowired
	DaoHB daoHB;
	
	public HSRespPrefs getPrefs() {
		// TODO Auto-generated method stub
		return dao.getPrefs();
	}
	
	public List<HSPhoto> getPhotos() {
		return daoHB.getPhotos();
	}
	
	public HSRespSuccess addPhoto(HSPhoto photo) {
		HSRespSuccess res = new HSRespSuccess();
		res.setSuccess(false);
		System.out.println("try addPhoto="+photo);
		try {  
			if (photo.getImage() != null) {
				// add mini-picture
				ByteArrayInputStream picture = new ByteArrayInputStream(photo.getImage());
				ByteArrayOutputStream miniPicture = new ByteArrayOutputStream();
	            Utils.rescale( picture, miniPicture, 127, 110);			
	            photo.setImagemini( miniPicture.toByteArray());
			}
			daoHB.addPhoto(photo);
			System.out.println("success addPhoto");
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
		}
		return res;
	}

	public List<HSPhoto> getPhotosWoImage() {
		return daoHB.getPhotosWoImage();
	}
	
	public HSPhoto getPhotoMini(Long idx) {
		return daoHB.getPhotoMini(idx);
	}
	
	public HSPhoto getPhoto(Long idx) {
		return daoHB.getPhoto(idx);
	}
	
}

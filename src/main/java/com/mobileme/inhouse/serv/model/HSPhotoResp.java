package com.mobileme.inhouse.serv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HSPhotoResp implements Serializable {
	public List<HSPhoto> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<HSPhoto> photoList) {
		this.photoList = photoList;
	}

	private List<HSPhoto> photoList = new ArrayList<HSPhoto>();
	
	
}

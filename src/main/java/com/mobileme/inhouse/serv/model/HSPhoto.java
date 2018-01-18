package com.mobileme.inhouse.serv.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HSPhoto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idx;

	private String name;
	private long createdate;
	private byte[] image;
	private byte[] imagemini;
	private double latitude;
	private double longitude;
    private int status;
	private long statusdate;
	private String statusMsg;

	
	public HSPhoto() {
		super();
	}

	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCreatedate() {
		return createdate;
	}
	public void setCreatedate(long createdate) {
		this.createdate = createdate;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getImagemini() {
		return imagemini;
	}
	public void setImagemini(byte[] imagemini) {
		this.imagemini = imagemini;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(long statusdate) {
		this.statusdate = statusdate;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	@Override
	public String toString() {
		return "HSPhoto [idx=" + idx + ", name=" + name + ", createdate=" + createdate + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", status=" + status + ", statusdate=" + statusdate + ", statusMsg="
				+ statusMsg + "]";
	}

	
}

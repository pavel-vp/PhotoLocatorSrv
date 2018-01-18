package com.mobileme.inhouse.serv.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mobileme.inhouse.serv.model.HSPhoto;

@Repository
public class DaoHB {
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	}
	
	@Transactional  
	public List<HSPhoto> getPhotos() {
		
		return getCurrentSession().createCriteria(HSPhoto.class).list();
		
	}

	@Transactional  
	public void addPhoto(HSPhoto photo) {		
		getCurrentSession().save(photo);
	}

	@Transactional  
	public List<HSPhoto> getPhotosWoImage() {
		
		Criteria cr = getCurrentSession()
				.createCriteria(HSPhoto.class)
			    .setProjection(Projections.projectionList()
				    .add(Projections.property("idx"), "idx")
				    .add(Projections.property("name"), "name")
				    .add(Projections.property("latitude"), "latitude")
					.add(Projections.property("longitude"), "longitude")
					.add(Projections.property("createdate"), "createdate"))
			    .setResultTransformer(Transformers.aliasToBean(HSPhoto.class));

		List<HSPhoto> list = cr.list();		
		return list;
	}
	
	@Transactional  
	public HSPhoto getPhotoMini(Long idx) {
		Criteria cr = getCurrentSession()
				.createCriteria(HSPhoto.class)
				.add(Restrictions.eq("idx",idx))
			    .setProjection(Projections.projectionList()
				    .add(Projections.property("idx"), "idx")
				    .add(Projections.property("name"), "name")
				    .add(Projections.property("imagemini"), "imagemini")
				    .add(Projections.property("latitude"), "latitude")
					.add(Projections.property("longitude"), "longitude")
					.add(Projections.property("createdate"), "createdate"))
			    .setResultTransformer(Transformers.aliasToBean(HSPhoto.class));
		List<HSPhoto> list = cr.list();		
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	
	@Transactional  
	public HSPhoto getPhoto(Long idx) {
		return (HSPhoto) (getCurrentSession().get(HSPhoto.class, idx));
	}
	
}

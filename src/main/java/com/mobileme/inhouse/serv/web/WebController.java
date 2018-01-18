package com.mobileme.inhouse.serv.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.mobileme.inhouse.serv.model.HSPhotoResp;
import com.mobileme.inhouse.serv.service.Service;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "web")
public class WebController  {
	private final static String CURRENT_API_VERSION = "0.2";

	@Autowired
	Service service;
	@Autowired
	private ObjectMapper jacksonMapper;	
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map(Model uimodel)  {
		return "map";
	}


}

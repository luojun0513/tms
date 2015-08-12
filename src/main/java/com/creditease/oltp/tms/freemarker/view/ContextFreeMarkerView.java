package com.creditease.oltp.tms.freemarker.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class ContextFreeMarkerView extends FreeMarkerView {
	private static final Logger logger = LoggerFactory.getLogger(ContextFreeMarkerView.class);
	@Override
	protected void exposeHelpers(Map<String, Object> model,HttpServletRequest request) throws Exception {
		model.put("basePath", request.getContextPath());
		model.put("staticPath", request.getContextPath());
		model.put("serviceAddr", request.getLocalAddr());
		model.put("servicePort", request.getLocalPort());
		if(logger.isDebugEnabled()) {
			logger.debug("缓存数据：" + model);
		}
		super.exposeHelpers(model, request);
		
	}
}

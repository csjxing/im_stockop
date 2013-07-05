package com.doucome.stockop.web.inter.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.constant.Constant;
import com.doucome.stockop.web.common.action.BasicAction;
import com.doucome.stockop.web.inter.authz.InterAuthz;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @author langben 2013-7-4
 *
 */
@SuppressWarnings("serial")
public class AuthzInterceptor extends AbstractInterceptor {

	@Autowired
	private InterAuthz interAuthz ;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		if (!interAuthz.isLogin()) {
			HttpServletRequest request = ServletActionContext.getRequest() ;
			String toUrl = request.getRequestURL().toString();
			String requestQueryString = request.getQueryString();
			if (StringUtils.isNotBlank(requestQueryString)) {
				toUrl += "?" + requestQueryString;
			}
			toUrl = URLEncoder.encode(toUrl, Constant.CHARSET_UTF8);
			
			invocation.getStack().set("redirectURL", toUrl) ;
			
            return BasicAction.STOCKOP_LOGIN ;
        }
		return invocation.invoke();
	}

}

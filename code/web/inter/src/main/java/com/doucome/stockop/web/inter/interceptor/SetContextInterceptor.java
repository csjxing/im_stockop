package com.doucome.stockop.web.inter.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.biz.core.encrypt.EncryptBean;
import com.doucome.stockop.web.inter.authz.InterAuthz;
import com.doucome.stockop.web.inter.authz.InterSessionOperator;
import com.doucome.stockop.web.inter.constant.RequestConstant;
import com.doucome.stockop.web.inter.context.AuthzContext;
import com.doucome.stockop.web.inter.context.AuthzContextHolder;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class SetContextInterceptor extends AbstractInterceptor{

private static final Log log = LogFactory.getLog(SetContextInterceptor.class);
    
    @Autowired
    private EncryptBean      cookieEncryptBean;
   
    @Autowired   
    private InterAuthz         interAuthz;
    
    @Autowired
    protected InterSessionOperator        interSessionOperator;
    
    private String           domain;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            prepare();
        } catch (Exception e) {
            log.error("prepare authz fail.", e);
        }
        try {
            invocation.addPreResultListener(new PreResultListener() {

                @Override
                public void beforeResult(ActionInvocation invocation, String resultCode) {
                    try {
                        change(ServletActionContext.getResponse());
                    } catch (Exception e) {
                        log.error("change cookie fail.", e);
                    }
                }
            });
            return invocation.invoke();
        } finally {
            try {
                clean();
            } catch (Exception e) {
                log.error("clean context fail.", e);
            }
        }
    }

    public void prepare() {
        //Cookie[] cookies = ServletActionContext.getRequest().getCookies();
    	
        AuthzContext authzContext = AuthzContextHolder.getContext();
        String authToken = ServletActionContext.getRequest().getParameter(RequestConstant.AUTH_TOKEN)  ;
        String accountId = ServletActionContext.getRequest().getParameter(RequestConstant.ACCOUNT_ID)  ;
        
        if (StringUtils.isNotBlank(authToken)) {
            authzContext.setAuthToken(authToken) ;
        }
        
        if(StringUtils.isNotBlank(accountId)) {
        	authzContext.setAccountId(accountId) ;
        }
        
    }

    /**
     * 更新cookie
     * 
     * @param response
     */
    public void change(HttpServletResponse response) {
        
    }

    /**
     * 线程数据清理
     */
    public void clean() {
        AuthzContextHolder.setContext(null);
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}

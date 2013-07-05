package com.doucome.stockop.web.inter;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.stockop.web.common.action.BasicAction;
import com.doucome.stockop.web.inter.authz.InterAuthz;

@SuppressWarnings("serial")
public class InterBasicAction extends BasicAction {

	@Autowired
	protected InterAuthz chaoAuthz ;
	
}

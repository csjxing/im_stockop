package com.doucome.stockop.biz.core.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.doucome.stockop.biz.common.unittest.AbstractBaseJUnit4Test;
import com.doucome.stockop.biz.core.enums.CommandEnums;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;

@ContextConfiguration(locations = { "classpath:biz-core-test.xml" })
public class CommandLogServiceImplTest extends AbstractBaseJUnit4Test {

	@Autowired
	private CommandLogService commandLogService ;
	
	@Test
	public void testCreate() {
		
		CommandLogDO log = new CommandLogDO() ;
		log.setAccountId("account") ;
		log.setAmount(1000) ;
		log.setCommand(CommandEnums.CANCELLATION.getValue()) ;
		log.setCommiBatch("10001") ;
		log.setLogDetail("detail") ;
		log.setOperator("02") ;
		log.setPrice(new BigDecimal("9.9")) ;
		log.setStockCode("10032444") ;
		commandLogService.createCommandLog(log) ;
	}
}

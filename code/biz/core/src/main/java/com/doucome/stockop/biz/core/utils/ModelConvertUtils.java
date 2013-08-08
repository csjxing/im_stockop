package com.doucome.stockop.biz.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.doucome.stockop.biz.core.model.CommandLogDTO;
import com.doucome.stockop.biz.dal.dataobject.CommandLogDO;

/**
 * 
 * @author langben 2013-8-8
 *
 */
public class ModelConvertUtils {

	public static List<CommandLogDTO> convertCommandLog(List<CommandLogDO> itemList) {
		List<CommandLogDTO> dtoList = new ArrayList<CommandLogDTO>() ;
		if(CollectionUtils.isNotEmpty(itemList)) {
			for(CommandLogDO c : itemList) {
				dtoList.add(new CommandLogDTO(c)) ;
			}
		}
		return dtoList ;
	}
	
}

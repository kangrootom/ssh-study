package com.atguigu.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateTypeConverter extends StrutsTypeConverter {
	private SimpleDateFormat sdf[] = {new SimpleDateFormat("yyyyMMdd"),new SimpleDateFormat("yyyy-MM-dd"),new SimpleDateFormat("yyyy/MM/dd"),new SimpleDateFormat("yyyy年MM月dd日")};

	@Override
	public Date convertFromString(Map map, String[] strs, Class clazz) {
		// TODO Auto-generated method stub
		Date date= null;
		if(clazz==Date.class){
				
				for(int i=0;i<sdf.length;i++){
					try {
						date= (Date) sdf[i].parse(strs[0]);
						if(date != null){
							return date;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						continue;
					}
					
				}
				
		}
		return date;
	}

	@Override
	public String convertToString(Map map, Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Date){
			return sdf[1].format(obj);
		}
		return null;
	}

}

package com.space.bookshelf.system;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BeanUtil 
{
	public static String getJSon(Object obj)
	{
		String _tmp = "";
		
		try
		{
			ObjectMapper mapperObj = new ObjectMapper();
			_tmp = mapperObj.writeValueAsString(obj);
			System.out.println("JSON String >>>>" + _tmp);
	        
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return _tmp;
	}

}

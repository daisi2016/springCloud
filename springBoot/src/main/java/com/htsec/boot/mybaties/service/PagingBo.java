package com.htsec.boot.mybaties.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.mockito.internal.util.collections.ArrayUtils;

/**
 * 分页传递的Bo
 * 
 * @author si.dai
 * 
 */
public class PagingBo implements Serializable {

	private static final long serialVersionUID = 5145469619604603794L;
	private Map<String, Object> paramMap = new HashMap<String, Object>();
	private Map<String, Object> attriMap = new HashMap<String, Object>();
	private int start;
	private int pagesize;

	public void setAttribute(String name, Object value) {
		attriMap.put(name, value);
	}
	
	public void setParameter(String name, Object value) {
		paramMap.put(name, value);
	}

	public String getParameter(String name) {
		if (paramMap.containsKey(name)) {
			if (paramMap.get(name) instanceof String[]) {
				return Arrays.toString((String[]) paramMap.get(name));
				
			} else {
				return (String) paramMap.get(name);
			}
		} else {
			Object obj = getAttribute(name);
			if(obj!=null){
			if (obj instanceof String[]) {
				return Arrays.toString((String[]) obj);
			} else {
				return (String) obj;
			}
			}else{
				return null;
			}
			 
		}
	}

	public String[] getParameterValues(String name) {
		if (paramMap.containsKey(name)) {
			if (paramMap.get(name) instanceof String[]) {
				return (String[]) paramMap.get(name);
			} else {
				return new String[] { (String) paramMap.get(name) };
			}
		} else {
			Object obj = getAttribute(name);
			if(obj!=null){
			if (obj instanceof String[]) {
				return(String[]) obj;
			} else {
				return  new String[] { (String) obj };
			}
			}else{
				return null;
			}
			 
		
		}
	}

	public Object getAttribute(String name) {
		if (attriMap.containsKey(name)) {
			return attriMap.get(name);
		} else {
			return null;
		}
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}
	public Map<String, Object> getAttriMap() {
		return attriMap;
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public static void main(String[] args) {
		String[] str = new String[] { "1", "2", "3" };
		System.out.print(Arrays.toString(str));
	}

}

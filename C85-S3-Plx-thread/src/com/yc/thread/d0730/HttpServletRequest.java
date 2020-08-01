package com.yc.thread.d0730;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpServletRequest {
	private String method;
	private String requestUri;
	private String protocol;
	
	private Map<String,String> headerMap = new HashMap<>();
	
	private Map<String,String> paramsMap = new HashMap<>();
	
	public HttpServletRequest(String requestText) {
		  String[] lines = requestText.split("\\n");
		  String[] items = lines[0].split("\\s");
		  method = items[0];
		  requestUri = items[1];
		  protocol = items[2];
		  
		  int index = items[1].indexOf("?");
		  if(index != -1) {
			  requestUri = items[1].substring(0,index);
			  String paramStrinng = items[1].substring(index+1);
			  String[] params = paramStrinng.split("&");
			  for(int i=0;i<params.length;i++ ) {
				  String[ ] nv = params[i].split("=");
				  if(nv.length==1) {
					  paramsMap.put(nv[0], "");
				  }else if(nv.length>1) {
					  paramsMap.put(nv[0], nv[1]);
				  }
			  }
		  }
		  
		  for(int i=1;i<lines.length;i++) {
			  lines[i] = lines[i].trim();
			  if(lines[i].isEmpty() ) {
				  break;
			  }
			  items = lines[i].split(":");
			  headerMap.put(items[0],items[1].trim() );
		  }
	}

	public String getMethod() {
		return method;
	}

	public String getRequestURI() {
		return requestUri;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getHeader(String name) {
		return headerMap.get(name);
	}
	
	public String getParameter(String name) {
		return paramsMap.get(name);
	}
	
	public Cookie[ ] getCookies( ) {
		String cookieString = headerMap.get("Cookie");
		if(cookieString == null) {
			return null;
		}else {
			List<Cookie> cookieList = new ArrayList<>();
			String[] sCookies = cookieString.split(";\\s*");
			for(int i=0;i<sCookies.length;i++) {
				String[ ] nv = sCookies[i].split("=");
				cookieList.add(new Cookie(nv[0],nv[1]));
			}
			return cookieList.toArray(new Cookie[0]);
		}
		
	}

	
}

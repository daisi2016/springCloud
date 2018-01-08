package com.spring.cloud.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**自定义过滤器
 * @author dais
 *
 */
public class AccessFilter extends ZuulFilter{

	@Override
	public Object run() {//需要执行的过滤逻辑
		 RequestContext ctx = RequestContext.getCurrentContext();
	        HttpServletRequest request = ctx.getRequest();
	        Object certNo = request.getParameter("certNo");
	        if(certNo==null) {
	            ctx.setSendZuulResponse(false);
	            ctx.setResponseBody("request url not complete!");
	            ctx.setResponseStatusCode(401);
	            return null;
	        }
	        return null;
	}

	@Override
	public boolean shouldFilter() {//返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
		return true;
	}

	@Override
	public int filterOrder() {//通过int值来定义过滤器的执行顺序
		return 1;
	}

	@Override
	public String filterType() {
		/*pre：可以在请求被路由之前调用
		routing：在路由请求时候被调用
		post：在routing和error过滤器之后被调用
		error：处理请求时发生错误时被调用*/
		return "pre";
	}

}

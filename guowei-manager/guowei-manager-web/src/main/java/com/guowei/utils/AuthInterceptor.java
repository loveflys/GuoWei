package com.guowei.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.guowei.common.utils.Constants;
import com.guowei.pojo.GwManager;

public class AuthInterceptor implements HandlerInterceptor {
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StringBuffer url = request.getRequestURL();
		Map<String, String[]> map = request.getParameterMap();
		StringBuffer params = new StringBuffer();
		int index = 0;
		// 遍历
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();
			if (index == 0) {
				params.append("params===>>>");
			}
			params.append(strKey.toString() + "=");
			for (int i = 0; i < value.length; i++) {
				params.append(value[i] + ",");
			}
			index++;
		}
		log.debug("发起请求==>" + url + "||" + request.getMethod() + "||" + params.toString());
		System.out.println("发起请求==>" + url + "||" + request.getMethod() + "||" + params.toString());
//		GwManager manager = (GwManager) request.getSession().getAttribute(Constants.CURRENT_USER);
//		System.out.println(request.getSession().getAttribute(Constants.CURRENT_USER));
//		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
//			AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
//
//			// 没有声明需要权限
//			if (authPassport == null)
//				return true;
//			else {
//				// 在这里实现自己的权限验证逻辑
//				if (request.getSession().getAttribute(Constants.CURRENT_USER) != null) {// 如果验证成功返回true（这里直接写false来模拟验证失败的处理）
//					boolean res;
//					switch(authPassport.level()) {
//						case 1: 
//							res = true;
//							break;
//						case 2: 
//							res = Arrays.asList(2, 3, 4).contains(manager.getLevel().intValue());
//							break;
//						case 3: 
//							res = Arrays.asList(3, 4).contains(manager.getLevel().intValue());
//							break;
//						case 4: 
//							res = manager.getLevel().intValue() == 4;
//							break;
//						case 5: 
//							res = Arrays.asList(4, 5).contains(manager.getLevel().intValue());
//							break;
//						case 6: 
//							res = Arrays.asList(4, 5, 6).contains(manager.getLevel().intValue());
//							res = true;
//							break;
//						default: 
//							res = true;
//							break;
//					}
//					return res;
//				} else { // 如果验证失败
//					// 返回到登录界面
//					response.sendRedirect("login");
//					return false;
//				}
//			}
//		} else
//			return true;
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

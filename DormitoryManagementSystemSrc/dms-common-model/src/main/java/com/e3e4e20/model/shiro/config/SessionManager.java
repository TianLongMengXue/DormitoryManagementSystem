package com.e3e4e20.model.shiro.config;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/*
 * Description:
 * Created: 2020-04-05 18:19 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
public class SessionManager extends DefaultWebSessionManager {
    /**
     * 前端向后端发送请求时,在请求头中回携带一个
     *      token : 参数 <==> sessionId
     * @param request
     * @param response
     * @return SessionId
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String sessionId = WebUtils.toHttp(request).getHeader("Authorization");
        if (StringUtils.isEmpty(sessionId)) {
            // 若果没有携带sessionId就生成一个
            return super.getSessionId(request, response);
        } else {
             sessionId = sessionId.replaceAll("Bearer", "");
            // 返回sessionId
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }
    }
}

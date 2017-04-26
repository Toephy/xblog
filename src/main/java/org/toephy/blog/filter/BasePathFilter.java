package org.toephy.blog.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.toephy.blog.bean.dto.SessionInfo;
import org.toephy.blog.util.SessionUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;

/**
 * Created by Toephy on 2017.4.1 17:27
 */
public class BasePathFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path + "/";
        request.setAttribute("basePath", basePath);

        Object session_uid = request.getSession().getAttribute("session_uid");
        if (session_uid == null) {
            Cookie[] cookies = request.getCookies();
            String sessionId = "";
            String userAvatar = "";
            String nickname = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("sessionId")) {
                        sessionId = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                    if (cookie.getName().equals("userAvatar")) {
                        userAvatar = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                    if (cookie.getName().equals("nickname")) {
                        nickname = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                }
            }

            if (StringUtils.isNotBlank(sessionId)) {
                SessionInfo sessionInfo = SessionUtil.getSessionById(sessionId);
                if (sessionInfo != null && sessionInfo.isValid() && !sessionInfo.isExpired()
                        && StringUtils.isNotBlank(userAvatar)
                        && StringUtils.isNotEmpty(nickname)) {
                    request.getSession().setAttribute("session_uid", sessionInfo.getUid());
                    request.getSession().setAttribute("userAvatar", userAvatar);
                    request.getSession().setAttribute("nickname", nickname);
                }
            }
        }

        return true;
    }
}

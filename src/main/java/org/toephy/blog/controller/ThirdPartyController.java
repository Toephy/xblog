package org.toephy.blog.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.toephy.blog.bean.dto.SessionInfo;
import org.toephy.blog.bean.entity.User;
import org.toephy.blog.service.IUserService;
import org.toephy.blog.util.CookieUtil;
import org.toephy.blog.util.SessionUtil;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Toephy on 2017.4.7 11:29
 * 第三方登录插件
 */
@Controller
public class ThirdPartyController {

    @Autowired
    private IUserService userService;

    /**
     * 微博授权回调地址
     * https://api.weibo.com/oauth2/authorize?client_id=1705470590&response_type=code&redirect_uri=http://www.toephy.com/weiboauthorize/callbak
     * @param request
     * @return
     */
    @RequestMapping(value = "/weiboauthorize/callbak")
    public String weiboauthorize(HttpServletRequest request, HttpServletResponse response, Model map) {
        String code = ServletRequestUtils.getStringParameter(request, "code", "..");
        System.out.println("code = " + code);

        boolean success = false;
        Oauth oauth = new Oauth();
        try {
            AccessToken accessToken = oauth.getAccessTokenByCode(code);
            Users um = new Users(accessToken.getAccessToken());
            weibo4j.model.User weiboUser = um.showUserById(accessToken.getUid());


            if (StringUtils.isNotBlank(weiboUser.getId())) {
                String openid = weiboUser.getId();
                User localUser = userService.getUserByOpenId(openid);
                if (localUser == null) {
                    localUser = new User();
                    localUser.setOpenId(openid);
                    localUser.setNickname(weiboUser.getName());
                    localUser.setAvatarurl(weiboUser.getAvatarLarge());
                    localUser.setRegesterType(3);
                    localUser.setCreateTime(new Date());
                    int id = userService.addUser(localUser);
                    if (id > 0) {
                        localUser.setId(id);
                    }
                }

                if (localUser.getId() > 0) {
                    SessionInfo sessionInfo = SessionUtil.create(localUser.getId(), TimeUnit.DAYS.toMillis(180));
                    if (sessionInfo != null) {
                        String sessionId = sessionInfo.getSessionId();
                        request.getSession().setAttribute("session_uid", localUser.getId());
                        request.getSession().setAttribute("userAvatar", weiboUser.getAvatarLarge());
                        request.getSession().setAttribute("nickname", weiboUser.getName());


                        CookieUtil.addCookie(response, "sessionId", sessionId, (int)TimeUnit.DAYS.toSeconds(150));
                        CookieUtil.addCookie(response, "userAvatar", weiboUser.getAvatarLarge(), (int)TimeUnit.DAYS.toSeconds(150));
                        CookieUtil.addCookie(response, "nickname", weiboUser.getName(), (int)TimeUnit.DAYS.toSeconds(150));

                        success = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.addAttribute("success", success);
        return "blink";
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/exit")
    @ResponseBody
    public boolean exit(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("session_uid");
        request.getSession().removeAttribute("userAvatar");
        request.getSession().removeAttribute("nickname");
        CookieUtil.clearCookie(request, response);
        return true;
    }

}

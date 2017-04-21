package org.toephy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Toephy on 2017.4.7 11:29
 * 第三方登录插件
 */
@Controller
public class ThirdPartyController {

    private static final String CLIENT_ID = "1705470590";
    private static final String CLIENT_SECRET = "f358f07834b7057b516a7e85e3237f39";
    private static final String REDIRECT_URI = "http://www.toephy.com/weiboauthorize/callbak";

    /**
     * 微博授权回调地址
     * https://api.weibo.com/oauth2/authorize?client_id=1705470590&response_type=code&redirect_uri=http://www.toephy.com/weiboauthorize/callbak
     * @param request
     * @return
     */
    @RequestMapping(value = "/weiboauthorize/callbak")
    @ResponseBody
    public String weiboauthorize(HttpServletRequest request) {
        String code = ServletRequestUtils.getStringParameter(request, "code", "..");
        System.out.println("code = " + code);

        Oauth oauth = new Oauth();
        try {
            AccessToken accessToken = oauth.getAccessTokenByCode(code);
            Users um = new Users(accessToken.getAccessToken());
            User user = um.showUserById(accessToken.getUid());
            return user.toString();
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 微博accesstoken回调地址
     *
     * @param request
     * @return
     */
    //@RequestMapping(value = "/weiboaccesstoken/callbak")
    //public String weiboaccesstoken(HttpServletRequest request) {
    //    String code = request.getHeader("code");
    //    System.out.println("code = " + code);
    //    Map<String, String> params = new HashMap<String, String>();
    //    params.put("redirect_uri", "");
    //    params.put("code", code);
    //    params.put("client_id", CLIENT_ID);
    //    params.put("client_secret", CLIENT_SECRET);
    //    params.put("grant_type", "authorization_code");
    //    HttpRequest.sendGet("https://api.weibo.com/oauth2/access_token", params);
    //}
}

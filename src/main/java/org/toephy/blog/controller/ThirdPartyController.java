package org.toephy.blog.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.toephy.blog.util.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Toephy on 2017.4.7 11:29
 * 第三方登录插件
 */
public class ThirdPartyController {

    private static final String appid = "158e701c75c80a";
    private static final String token = "8abb7ab9d47ebec894dd74c4003233bd";

    /**
     * 第三方登录插件回调地址
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/callback")
    public String callback(HttpServletRequest request) {
        String code = ServletRequestUtils.getStringParameter(request, "code", "");  // 回调返回码
        if (StringUtils.isEmpty(code)) {
            return "fail";
        } else {
            String json = HttpRequest.sendPost("http://open.51094.com/user/auth.html", "type=get_user_info&code=" + code + "&appid=" + appid + "&token=" + token + "");
            System.out.println(json);
            //解析结果
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, String>>() {}.getType());

            return "Redirect";
        }
    }

}

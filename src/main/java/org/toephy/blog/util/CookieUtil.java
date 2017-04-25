package org.toephy.blog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Toephy on 2017.4.25 17:44
 */
public class CookieUtil {

    private CookieUtil() {
    }

    public static void addCookie(HttpServletResponse response, String key, String value, int maxAge) {
        try {
            value = URLEncoder.encode(value, "UTF-8");
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(maxAge);
            //设置路径，这个路径即该工程下都可以访问该cookie.
            //如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

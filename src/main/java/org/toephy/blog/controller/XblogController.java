package org.toephy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Toephy on 2017.3.29 16:52
 */
@Controller
public class XblogController {

    @RequestMapping("/homepage")
    public String homepage(HttpServletRequest request, Model map) {
        request.setAttribute("active", "homepage");
        map.addAttribute("content", "<p>下面这个美女如何：</p><p><img style=\"max-width:100%;\" src=\"https://timgsa.baidu.com/timg?image&quality=80&amp;size=b9999_10000&amp;sec=1491125834313&amp;di=9128abd7217b0a5664526235e50db60b&amp;imgtype=0&amp;src=http%3A%2F%2Fimg1d.xgo-img.com.cn%2Fpics%2F157%2F156499.jpg\"><br></p><p>个人感觉还不错！！</p><p><br></p>");
        return "homepage";
    }

    @RequestMapping("/aboutme")
    public String aboutme(HttpServletRequest request) {
        request.setAttribute("active", "aboutme");
        return "aboutme";
    }

    @RequestMapping("/messageBoard")
    public String messageBoard(HttpServletRequest request) {
        request.setAttribute("active", "messageBoard");
        return "messageBoard";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseBody
    public boolean comment(HttpServletRequest request) {
        String comment = ServletRequestUtils.getStringParameter(request, "comment", "");
        System.out.println(comment);
        return true;
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    @ResponseBody
    public boolean blog(HttpServletRequest request) {
        String blog = ServletRequestUtils.getStringParameter(request, "blog", "");
        System.out.println(blog);
        return true;
    }
}

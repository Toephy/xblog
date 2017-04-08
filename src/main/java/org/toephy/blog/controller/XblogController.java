package org.toephy.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.toephy.blog.entity.Blog;
import org.toephy.blog.service.IBlogService;
import org.toephy.blog.util.BlogStringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Toephy on 2017.3.29 16:52
 */
@Controller
public class XblogController {

    @Autowired
    private IBlogService blogService;

    /**
     * 博客列表
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/blog")
    public String blogList(HttpServletRequest request, Model map) {
        request.setAttribute("active", "blog");
        List<Blog> blogs = blogService.blogList();
        map.addAttribute("blogList", blogs);
        return "blog";
    }

    /**
     * 关于博主
     * @param request
     * @return
     */
    @RequestMapping("/aboutme")
    public String aboutme(HttpServletRequest request) {
        request.setAttribute("active", "aboutme");
        return "aboutme";
    }

    /**
     * 留言板
     * @param request
     * @return
     */
    @RequestMapping("/messageBoard")
    public String messageBoard(HttpServletRequest request) {
        request.setAttribute("active", "messageBoard");
        return "messageBoard";
    }

    /**
     * 编辑博客页面
     * @param request
     * @return
     */
    @RequestMapping("/writeblog")
    public String writeblog(HttpServletRequest request) {
        request.setAttribute("active", "writeblog");
        return "writeblog";
    }

    /**
     * 发表博客
     * @param request
     * @return
     */
    @RequestMapping(value = "/addblog", method = RequestMethod.POST)
    @ResponseBody
    public boolean blog(HttpServletRequest request) {
        String title = ServletRequestUtils.getStringParameter(request, "title", "");
        String content = ServletRequestUtils.getStringParameter(request, "content", "");
        //content = BlogStringUtil.beautifyContent(content);
        System.out.println("content = " + content);
        Blog blog = new Blog();
        blog.setBlogTitle(title);
        blog.setBlogDesc(BlogStringUtil.extractDesc(content));
        blog.setBlogContent(content);
        blog.setViewCount(96542);
        blog.setCreateTime(new Date());
        boolean b = blogService.addBlog(blog);
        System.out.println("flag = " + b);
        return true;
    }

    /**
     * 发表评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    @ResponseBody
    public boolean comment(HttpServletRequest request) {
        String comment = ServletRequestUtils.getStringParameter(request, "comment", "");
        System.out.println(comment);
        return true;
    }


}

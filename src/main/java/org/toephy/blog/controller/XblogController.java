package org.toephy.blog.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.toephy.blog.bean.dto.CommentDto;
import org.toephy.blog.bean.dto.Pager;
import org.toephy.blog.bean.entity.Blog;
import org.toephy.blog.bean.entity.Comment;
import org.toephy.blog.constants.AppConstant;
import org.toephy.blog.service.IBlogService;
import org.toephy.blog.service.ICommentService;
import org.toephy.blog.util.BlogStringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Toephy on 2017.3.29 16:52
 */
@Controller
public class XblogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICommentService commentService;

    @RequestMapping("/")
    public String baseforward(HttpServletRequest request) {
        return "forward:/blog/list/1";
    }

    /**
     * 博客列表
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/blog/list/{pageNo}")
    public String blogList(HttpServletRequest request, Model map, @PathVariable("pageNo") int pageNo) {
        request.setAttribute("active", "bloglist");
        int pageSize = 5;
        Map<String, Object> data = blogService.blogList(pageNo, pageSize);
        Pager pager = new Pager(pageNo, Integer.parseInt(data.get("totalPage").toString()), "blog/list/");
        map.addAttribute("pager", pager);
        map.addAttribute("blogList", data.get("blogs"));
        return "bloglist";
    }

    /**
     * 查看博客
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping("/blog/{id}")
    public String getBlog(HttpServletRequest request, Model map, @PathVariable("id") int id) {
        request.setAttribute("active", "bloglist");
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            return "redirect:/blog/list/1";
        }
        List<CommentDto> commentList = commentService.getCommentList(id);
        map.addAttribute("blog", blog);
        map.addAttribute("commentList", commentList);
        return "blogdetail";
    }

    /**
     * 关于博主
     *
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
     *
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
     *
     * @param request
     * @return
     */
    @RequestMapping("/writeblog")
    public String writeblog(HttpServletRequest request) {
        int uidInSession = -1;
        try {
            Object object = request.getSession().getAttribute("session_uid");
            if (object != null) {
                uidInSession = Integer.parseInt(object.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (uidInSession != AppConstant.HOST_UID) {
            return "redirect:/blog/list/1";
        }

        request.setAttribute("active", "writeblog");
        return "writeblog";
    }

    /**
     * 发表博客
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addblog", method = RequestMethod.POST)
    @ResponseBody
    public boolean addblog(HttpServletRequest request) {
        int uid = ServletRequestUtils.getIntParameter(request, "uid", 0);
        String title = ServletRequestUtils.getStringParameter(request, "title", "");
        String content = ServletRequestUtils.getStringParameter(request, "content", "");
        int uidInSession = -1;
        try {
            uidInSession = Integer.parseInt(request.getSession().getAttribute("session_uid").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (uid != uidInSession || uidInSession != AppConstant.HOST_UID) {
            return false;
        }

        //content = BlogStringUtil.beautifyContent(content);
        Blog blog = new Blog();
        blog.setBlogTitle(title);
        blog.setBlogDesc(BlogStringUtil.extractDesc(content));
        blog.setBlogContent(content);
        blog.setViewCount(96542);
        blog.setCreateTime(new Date());
        return blogService.addBlog(blog);
    }

    /**
     * 发表评论
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    @ResponseBody
    public boolean addcomment(HttpServletRequest request) {
        int uid = ServletRequestUtils.getIntParameter(request, "uid", 0);
        int blogId = ServletRequestUtils.getIntParameter(request, "blogId", -1);
        String content = ServletRequestUtils.getStringParameter(request, "comment", "");
        if (uid <= 0 || blogId < 0 || StringUtils.isBlank(content)) {
            return false;
        }
        content = content.replaceAll("<p><br></p>", "");
        Comment comment = new Comment();
        comment.setCommentContent(content);
        comment.setBlogId(blogId);
        comment.setUid(uid);
        comment.setCreateTime(new Date());
        return commentService.addComment(comment);
    }

}

package org.toephy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Toephy on 2017.3.29 16:52
 */
@Controller
public class XblogController {


    @RequestMapping("/homepage")
    public String homepage() {
        return "homepage";
    }

    @RequestMapping("/aboutme")
    public String aboutme() {
        return "aboutme";
    }

    @RequestMapping("/freemark")
    public String freemark() {
        return "freemark";
    }

}

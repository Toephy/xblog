package org.toephy.blog.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Toephy on 2017/4/8 19:43
 */
public class BlogStringUtil {

    private BlogStringUtil() {
    }

    public static String beautifyContent(String content) {
        if (StringUtils.isEmpty(content))
            return "";

        content = content.replaceAll("<p>", "<div>").replaceAll("</p>", "</div>").replaceFirst("<div>", "").replaceFirst("</div>", "");
        return content;
    }

    /**
     * 提取文章描述
     * @return
     */
    public static String extractDesc(String content) {
        if (StringUtils.isEmpty(content))
            return "";
        content = content.replaceAll("<p>", "").replaceAll("</p>", " ").replaceAll("&nbsp;", " ").replaceAll("<br>", " ")
                .replaceAll("\n", " ").replaceAll("<a[^>]+>","").replaceAll("</a>", "").replaceAll("<img[^>]+>","")
                .replaceAll("<h1>", "").replaceAll("</h1>", " ").replaceAll("<h2>", "").replaceAll("</h2>", " ")
                .replaceAll("<h3>", "").replaceAll("</h3>", " ").replaceAll("<h4>", "").replaceAll("</h4>", " ").trim();
        int maxlength = 200;
        return (content.length() > maxlength ? content.substring(0, 200) : content) + " . . .";
    }

    public static void main(String[] args) {
        String str = "<p>枯藤老树昏鸦</p><p>小桥流水人家</p><p>&lt;div&gt;&lt;/div&gt;</p><p>夕阳西下</p><p>断肠人在天涯</p><p><img style=\"max-width:100%;\" src=\"http://img4.imgtn.bdimg.com/it/u=3698949177,2006748335&fm=23&amp;gp=0.jpg\"><br></p><p>。。。</p><p><br></p>";
        //<img style="max-width:100%;" src="http://img0.imgtn.bdimg.com/it/u=251234813,891911113&fm=23&amp;gp=0.jpg">
        str = beautifyContent(str);
        System.out.println(str);
        str = str.replaceFirst("<div>", "").replaceFirst("</div>", "");
        System.out.println(str);

        String s = "生成<img style=\"max-width:100%;\" src=\"http://img0.imgtn.bdimg.com/it/u=251234813,891911113&fm=23&amp;gp=0.jpg\">算法</a>主要>";
        System.out.println(extractDesc(s));
    }
}

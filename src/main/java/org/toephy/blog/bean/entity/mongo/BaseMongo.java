package org.toephy.blog.bean.entity.mongo;

/**
 * Created by Toephy on 2017.5.2 15:36
 */
public abstract class BaseMongo {

    /**
     * 获取entity所在库名
     * @return
     */
    public static String getDbName() {
        return "xblog";
    }

}

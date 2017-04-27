package org.toephy.blog.service;

import org.toephy.blog.bean.entity.GuestNote;

import java.util.Map;

/**
 * Created by Toephy on 2017.4.27 15:35
 */
public interface IGuestNoteService {

    Map<String, Object> noteList(int pageNo, int pageSize);

    boolean addNote(GuestNote note);

}

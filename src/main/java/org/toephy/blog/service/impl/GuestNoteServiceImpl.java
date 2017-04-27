package org.toephy.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.toephy.blog.bean.dto.GuestNoteDto;
import org.toephy.blog.bean.entity.GuestNote;
import org.toephy.blog.dao.IGuestNoteDao;
import org.toephy.blog.service.IGuestNoteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toephy on 2017.4.27 15:37
 */
@Service
public class GuestNoteServiceImpl implements IGuestNoteService {

    @Autowired
    private IGuestNoteDao guestNoteDao;

    @Override
    public Map<String, Object> noteList(int pageNo, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        int totalRecord = guestNoteDao.getCount();
        int totalPage = (totalRecord  +  pageSize  - 1) / pageSize;
        map.put("totalPage", totalPage);
        int startIndex = (pageNo - 1) * pageSize;
        List<GuestNoteDto> data = guestNoteDao.getNotes(startIndex, pageSize);
        List<GuestNoteDto> notes = new ArrayList<GuestNoteDto>();
        if (!CollectionUtils.isEmpty(data)) {
            for (GuestNoteDto item : data) {
                if (item.getUser() != null) {
                    notes.add(item);
                }
            }
        }
        map.put("notes", notes);
        return map;
    }

    @Override
    public boolean addNote(GuestNote note) {
        return guestNoteDao.insertNote(note);
    }

}

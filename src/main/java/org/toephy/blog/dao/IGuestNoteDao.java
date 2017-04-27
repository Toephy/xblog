package org.toephy.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.toephy.blog.bean.dto.GuestNoteDto;
import org.toephy.blog.bean.entity.GuestNote;

import java.util.List;

/**
 * Created by Toephy on 2017.4.27 15:27
 */
@Mapper
public interface IGuestNoteDao {

    int getCount();

    boolean insertNote(GuestNote note);

    List<GuestNoteDto> getNotes(@Param("startIndex") int startIndex, @Param("offset") int offset);
}

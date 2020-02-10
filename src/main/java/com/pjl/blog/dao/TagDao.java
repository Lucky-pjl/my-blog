package com.pjl.blog.dao;

import com.pjl.blog.pojo.Tag;
import com.pjl.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-02-10:09
 */
@Mapper
@Repository
public interface TagDao {

    int saveTag(Tag tag);

    Tag getTagById(Integer id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    int deleteTag(Integer id);

    int updateTag(Tag tag);

    List<Tag> getAllIndexTag();
}

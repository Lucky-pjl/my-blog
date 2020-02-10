package com.pjl.blog.service;

import com.pjl.blog.pojo.Tag;
import com.pjl.blog.pojo.Type;

import java.util.List;

/**
 * @author pjl
 * @create 2020-02-02-10:12
 */
public interface TagService {
    int saveTag(Tag tag);

    Tag getTagById(Integer id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    int deleteTag(Integer id);

    int updateTag(Tag tag);

    List<Tag> listTag(String ids);

    List<Tag> getIndexTags();

}

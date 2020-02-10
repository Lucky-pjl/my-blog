package com.pjl.blog.service;

import com.pjl.blog.dao.TagDao;
import com.pjl.blog.pojo.Tag;
import com.pjl.blog.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-02-10:12
 */
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao tagDao;

    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagDao.getTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.getTagByName(name);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    public int deleteTag(Integer id) {
        return tagDao.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    //新增博客时的标签
    @Override
    public List<Tag> listTag(String ids) {
        List<Integer> id = convertToList(ids);
        List<Tag> tags = new ArrayList<>();
        for(Integer i : id){

            tags.add(tagDao.getTagById(i));
        }
        return tags;
    }

    @Override
    public List<Tag> getIndexTags() {
        return tagDao.getAllIndexTag();
    }

    //将字符串装换为数组
    private List<Integer> convertToList(String ids) {
        List<Integer> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Integer(idarray[i]));
            }
        }
        return list;
    }
}

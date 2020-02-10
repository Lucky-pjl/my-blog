package com.pjl.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-01-11:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private Integer id;
    private String title;
    private String content;
    private String firstPicture;//博客首图
    private String flag;
    private Integer views;//浏览次数

    private boolean recommend;//是否推荐

    private Date createTime;
    private Date updateTime;

    //与类型的级联
    private Integer typeId;
    //属于的用户
    private Integer UserId;

    private String ids;

    private String description;

    private Type type;

    private User user;

    private List<Tag> tags = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();


    public void init(){
        this.ids = tagsToIds(this.getTags());
    }

    public String tagsToIds(List<Tag> tags){
        if(!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for(Tag tag : tags){
                if(flag){
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }
        return this.ids;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", recommend=" + recommend +
                ", published=" +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

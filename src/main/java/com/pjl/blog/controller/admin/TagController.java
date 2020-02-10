package com.pjl.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjl.blog.dao.TagDao;
import com.pjl.blog.pojo.Tag;
import com.pjl.blog.pojo.Type;
import com.pjl.blog.service.TagService;
import com.pjl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author pjl
 * @create 2020-02-02-10:09
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //跳转到标签显示页面
    @GetMapping("/tags")
    public String list(Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum, 4);
        List<Tag> allTag = tagService.getAllTag();
        //得到分页结果对象
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/tags";
    }


    //跳转到标签添加页面
    @GetMapping("/tags/input")
    public String toAdd(){
        return "admin/tags-add";
    }

    //标签添加 post提交方式
    @PostMapping("/tags")
    public String post(@Valid Tag tag, RedirectAttributes attributes){

        Tag t = tagService.getTagByName(tag.getName());

        if(t != null){
            attributes.addFlashAttribute("message","添加失败！此标签已有!");
            return "redirect:/admin/tags/input";
        }else {
            int i = tagService.saveTag(tag);
            if(i == 0){
                attributes.addFlashAttribute("message","操作失败");
            }else {
                attributes.addFlashAttribute("message","操作成功");
            }

        }
        return "redirect:/admin/tags";
    }

    //到修改页面
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Integer id, Model model) {

        Tag tag = tagService.getTagById(id);

        model.addAttribute("tag", tag);
        return "admin/tags-update";
    }

    //进行修改
    @PostMapping("/tags/update")
    public String editPost(Tag tag,Model model,RedirectAttributes attributes) {

        Tag t = tagService.getTagByName(tag.getName());
        if(t != null){
            model.addAttribute("message","此标签已有！请重新修改！");
            return "admin/tags-update";
        }else {

            int i = tagService.updateTag(tag);
            if(i == 0){
                attributes.addFlashAttribute("message","操作失败");
            }else {
                attributes.addFlashAttribute("message","操作成功");
            }

        }
        return "redirect:/admin/tags";
    }


    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes){
        int i = tagService.deleteTag(id);
        if(i == 0){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/tags";
    }
}

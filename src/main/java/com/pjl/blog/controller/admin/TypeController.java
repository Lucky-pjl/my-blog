package com.pjl.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjl.blog.pojo.Type;
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
 * @create 2020-02-01-18:05
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String list(Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum, 4);
        List<Type> allType = typeService.getAllType();
        //得到分页结果对象
        PageInfo<Type> pageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/types";
    }


    @GetMapping("/types/input")
    public String toAdd(){
        return "admin/type-add";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            return "admin/type-add";
        }

        Type t = typeService.getTypeByName(type.getName());


        if(t != null){
            attributes.addFlashAttribute("message","添加失败！此分类已有!");
            return "redirect:/admin/types/input";
        }else {

            int i = typeService.saveType(type);
            if(i == 0){
                attributes.addFlashAttribute("message","操作失败");
            }else {
                attributes.addFlashAttribute("message","操作成功");
            }

        }
        return "redirect:/admin/types";
    }

    //到修改页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Integer id, Model model) {

        Type type = typeService.getTypeById(id);

        model.addAttribute("type", type);
        return "admin/type-update";
    }

    //进行修改
    @PostMapping("/types/update")
    public String editPost(Type type,Model model,RedirectAttributes attributes) {

        Type t = typeService.getTypeByName(type.getName());
        if(t != null){
            model.addAttribute("message","此分类已有！请重新修改！");
            return "admin/type-update";
        }else {

            int i = typeService.updateType(type);
            if(i == 0){
                attributes.addFlashAttribute("message","操作失败");
            }else {
                attributes.addFlashAttribute("message","操作成功");
            }

        }
        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes attributes){
        int i = typeService.deleteType(id);
        if(i == 0){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/types";
    }

}

package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add")
    public String displayUserAddForm(Model model){
        return "user/add";
    }

    public String add(Model model, @ModelAttribute User user, String verify){
        //if User.password == verify
        return "index";
    }

}

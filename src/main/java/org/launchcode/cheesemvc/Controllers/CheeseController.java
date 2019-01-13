package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, String cheeseDesc) {
        Cheese newCheese = new Cheese(cheeseName, cheeseDesc);
        cheeses.add(newCheese);

        //redirect to /cheese.
        return "redirect:";
    }
        @RequestMapping(value = "remove", method = RequestMethod.GET)
        public String displayRemoveCheeseForm(Model model) {
            model.addAttribute("cheeses", cheeses);
            model.addAttribute("title", "Remove Cheese");
            return "cheese/remove";
        }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheese) {

        for (String aCheese : cheese) {
            cheeses.remove(aCheese);
        }

        return "redirect:";
    }

    }

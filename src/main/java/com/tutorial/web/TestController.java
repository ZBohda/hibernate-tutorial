package com.tutorial.web;

import com.tutorial.domain.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping(value = "/test/tests", method = RequestMethod.GET)
    public String vou(@RequestParam("foo") String foo, Model model) {
        model.addAttribute("product", foo);
        return "test";
    }

}

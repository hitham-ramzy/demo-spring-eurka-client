package com.alten.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeResource {

    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }

}

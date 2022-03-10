package Goldra9.bookStore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//== Home 화면 ==//
@Controller
@Slf4j
public class HomeController
{

    @RequestMapping("/")
    public String home()
    {
        log.info("home controller");
        return "home";
    }
}
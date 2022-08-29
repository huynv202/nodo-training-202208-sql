package com.example.unit6_spring_boot.Controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

    private final static Logger LOGGER = Logger.getLogger(HomeController.class);

@RequestMapping("/")
public ModelAndView mv() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("message", "Hello World1");
    mv.setViewName("index");
    LOGGER.info("Truy cap thanh cong!");
    return mv;
}
@RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value="error", required = false) String error,
                             @RequestParam(value="logout", required = false) String logout,
                             Model model) {
        ModelAndView mv = new ModelAndView();
        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/login-form", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }


@RequestMapping("/user/home")
    public ModelAndView User() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    mv.addObject("message", "Hello User"+auth.getName());
    LOGGER.info("Truy cap thanh cong!");
    return mv;
}
@RequestMapping("/logout")
    public String logout(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if(auth!=null){
        new SecurityContextLogoutHandler().logout(null, null, auth);
    }
    return "redirect:/login?logout";
}

//public String index(Model model) {
//    model.addAttribute("message", "Hello World");
//    return "index";
//}
}

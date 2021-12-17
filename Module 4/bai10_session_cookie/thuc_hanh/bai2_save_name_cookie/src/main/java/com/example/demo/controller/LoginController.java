package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpForm(){
        return new User();
    }
    @GetMapping("/login")
    public String index(@CookieValue(value = "setUser",defaultValue = "") String setUser, Model model){
        Cookie cookie=new Cookie("setUser",setUser);
        model.addAttribute("cookieValue",cookie);
        return "login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user")User user, Model model, @CookieValue(value = "setUser",defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request){
        if(user.getEmail().equals("admin@gmail.com")&& user.getPassword().equals("12345")){
            if(user.getEmail()!=null){
                setUser=user.getEmail();
            }
            // create cookie and set it in response
            Cookie cookie=new Cookie("setUser",setUser);
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            //get all cookie
            Cookie[] cookies=request.getCookies();
            //iterate each cookie
            for(Cookie cookie1:cookies){
                //display only the cookie with the name 'setUser'
                if(cookie1.getName().equals("setUser")){
                    model.addAttribute("cookieValue",cookie1);
                    break;
                }else {
                    cookie1.setValue("");
                    model.addAttribute("cookieValue",cookie1);
                    break;
                }
            }
            model.addAttribute("message","Login success. Welcome!");
        }else {
            user.setEmail("");
            Cookie cookie=new Cookie("setUser",setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }

}

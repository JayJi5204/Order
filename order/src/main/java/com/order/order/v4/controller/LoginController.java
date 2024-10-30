package com.order.order.v4.controller;

import com.order.order.v4.entity.Member;
import com.order.order.v4.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v4/login")
@Log4j2
public class LoginController {

   @Autowired
    LoginService loginService;
    @GetMapping("/form")
    public String doLoginForm(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        String name=(String)session.getAttribute("ss_name");

        model.addAttribute("name",name);
        return "/v4/login/login_form";
    }


    @PostMapping("/login_exe")
    public String doLoginExe(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw, Model model, HttpServletResponse response, HttpServletRequest request) {
        Member member = loginService.doLogin(id);
        String msg = "";

        log.info("ID = " + id + ", pw = " + pw);

        if (member == null) {
            msg = "ID가 잘못되었습니다.";
        } else {
            if (pw.equals(member.getPassword())) {
                msg = "로그인 성공";

                //setSession
                HttpSession session = request.getSession();

                // 세션 ID 가져오기
                String sessionId = session.getId();
                session.setAttribute("ss_id", member.getMemberId());
                session.setAttribute("ss_name", member.getName());
                session.setAttribute("ss_email", member.getEmail());
                session.setAttribute("ss_role", member.getRole());

                return "/v4/home/home";
            } else {
                msg = "비밀번호가 잘못되었습니다.";
            }
        }
        model.addAttribute("message", msg);
        return "/v4/login/login_form";
    }

    @GetMapping("/logout")
    public String doLogOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/";
    }
}

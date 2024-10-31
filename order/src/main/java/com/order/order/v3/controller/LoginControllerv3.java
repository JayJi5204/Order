package com.order.order.v3.controller;

import com.order.order.v3.service.LoginServiceV3;
import com.order.order.v3.vo.MemberInfoVo;
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
@RequestMapping("/v3/login")
@Log4j2
public class LoginControllerv3 {

    @Autowired
    LoginServiceV3 loginServiceV3;

    @GetMapping("/form")
    public String doLoginForm(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("ss_name");

        model.addAttribute("name", name);
        return "/v3/login/login_form";
    }


    @PostMapping("/login_exe")
    public String doLoginExe(@RequestParam(value = "id") String id, @RequestParam(value = "pw") String pw, Model model, HttpServletResponse response, HttpServletRequest request) {
        MemberInfoVo memberInfoVo = loginServiceV3.doLogin(id);
        String msg = "";

        log.info("ID = " + id + ", pw = " + pw);

        if (memberInfoVo == null) {
            msg = "ID가 잘못되었습니다.";
        } else {
            if (pw.equals(memberInfoVo.getPasswd())) {
                msg = "로그인 성공";

//                Cookie cookie=new Cookie("M_id",memberInfoVo.getMember_id());
//                response.addCookie(cookie);
//                cookie.setMaxAge(60*60*24*10); // 10일 유지

                //setSession
                HttpSession session = request.getSession();

                // 세션 ID 가져오기
                String sessionId = session.getId();
                session.setAttribute("ss_id", memberInfoVo.getMember_id());
                session.setAttribute("ss_name", memberInfoVo.getName());
                session.setAttribute("ss_email", memberInfoVo.getEmail());
                session.setAttribute("ss_role", memberInfoVo.getRole());

                return "/v3/login/login_form";
            } else {
                msg = "비밀번호가 잘못되었습니다.";
            }
        }
        model.addAttribute("message", msg);
        return "/v3/login/login_form";
    }

    @GetMapping("/logout")
    public String doLogOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:/";
    }
}

package com.order.order.comm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
public class LoginSession {

    @GetMapping("/session")
    public String doSession(HttpServletRequest request) {

        HttpSession session = request.getSession();

        // 세션 ID 가져오기
        String strSessionId = session.getId();
        System.out.println("session ID : " + strSessionId);

        // 세션의 값을 배열에 넣는다.
        Enumeration<String> names = session.getAttributeNames();

        // Enumeration 추출
        String strSession = "";
        while (names.hasMoreElements()) {
            strSession = names.nextElement();
            System.out.println(strSession + " : " + session.getAttribute(strSession));
        }

        return strSessionId;
    }

}
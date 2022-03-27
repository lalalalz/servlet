package hello.servlet.basic;

import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {

//        System.out.println("[STATUS CODE]");
//        response.setStatus(HttpServletResponse.SC_OK);
//
//        System.out.println("[Response Header]");
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("my-header", "hello");
//
//        System.out.println("[Response Body]");
//        response.getWriter().write("HttpResponseServlet Test");

        content(response);
        cookie(response);
        redirect(response);
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie", "test");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/basic/hello-form.html");
    }
}

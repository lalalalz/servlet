package hello.servlet.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJSONServlet", urlPatterns = "/response-json")
public class ResponseJSONServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(20);

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] result = objectMapper.writeValueAsBytes(helloData);

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result);
    }
}

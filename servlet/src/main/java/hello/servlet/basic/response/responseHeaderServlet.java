package hello.servlet.basic.response;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class responseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

       // response.setHeader("Content-Type", "Text/plain" );
       // response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

       // content(response);
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok");

    }

    private  void content(HttpServletResponse response){

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        Cookie cookie = new Cookie("myCooke","good");
        cookie.setMaxAge(600);

    }

    private void redirect(HttpServletResponse response) throws  IOException{

        //response.setStatus(HttpServletResponse.SC_FOUND);
        //response.setHeader("Location","/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}

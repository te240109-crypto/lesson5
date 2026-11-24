package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testenq")
public class TestEnqServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response
    )
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String qtype = request.getParameter("qtype");
        String body = request.getParameter("body");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>お問い合わせ結果</title>");
        out.println("</head>");
        out.println("<body>");

        if(qtype.equals("company")) {
            qtype = "会社について";
        }
        else if(qtype.equals("product")) {
            qtype = "製品について";
        }
        else if(qtype.equals("support")) {
            qtype = "アフターサポートについて";
        }

        out.println("<p>名前：" + name + "</p>");
        out.println("<p>種類：" + qtype + "</p>");
        out.println("<p>内容：" + body + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}


package pposonggil.usedStuff.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;

import java.io.IOException;

public class CustomAccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String message =accessDeniedException.getMessage();
        response.sendError(500,"accessDenied");
        response.setStatus(500);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(
                "<html>" +
                        "<head>" +
                        "<script type='text/javascript'>" +
                        "alert('" + message + "');" +
                        "window.location.href='/';" +
                        "</script>" +
                        "</head>" +
                        "<body></body>" +
                        "</html>"
        );
    }
}
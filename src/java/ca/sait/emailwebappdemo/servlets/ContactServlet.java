package ca.sait.emailwebappdemo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// The 'sendgrid-java' package needs to be added as a dependency.
import com.sendgrid.*;


/**
 *
 * @author Administrater
 */
public class ContactServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp").forward(request,response);
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        
        if(name ==null || name.isEmpty() || email==null || email.isEmpty() || message == null || message.isEmpty()){
            //could be improve the functionality
            
            // Missing field, do not continue
            request.setAttribute("alert", "One or more fields are missing.");
        }else{
            // Fields are there so we're good
            Email from = new Email("hello@sait.email");
            String subject = "Contact Form Submission";
//            Email to = new Email("joe.blow@...");
            Email to = new Email("ysmsam@hotmail.com");
            String actualMessage = "Name: "+ name +"\n" +
                                    "Email: "+ email + "\n" +
                                    "Message: " + message + "\n";
            Content content = new Content("text/plain", actualMessage);
            Mail mail = new Mail(from, subject, to, content);
            
            SendGrid sg = new SendGrid("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");
            Request sendGridRequest = new Request();
            try {
                sendGridRequest.setMethod(Method.POST);
                sendGridRequest.setEndpoint("mail/send");
                sendGridRequest.setBody(mail.build());
                Response sendGridResponse = sg.api(sendGridRequest);
                System.out.println(sendGridResponse.getStatusCode());
                System.out.println(sendGridResponse.getBody());
                System.out.println(sendGridResponse.getHeaders());
            } catch (IOException ex) {
                throw ex;
            }
            
            request.setAttribute("alert", "Email sent");
        }
        
//        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
                
        this.getServletContext().getRequestDispatcher("/WEB-INF/contact.jsp").forward(request,response);
        
    }


}

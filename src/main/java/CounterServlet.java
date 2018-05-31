import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String reset = req.getParameter("reset");
        res.setContentType("text/html");
        counter += 1;
        String ending;
        switch (lastNumber(counter)) {
            case 1:
                if (tenthOfNumber(counter) >= 4 && tenthOfNumber(counter) <= 20) {
                    ending = "th";
                } else {
                    ending = "st";
                }
                break;
            case 2:
                if (tenthOfNumber(counter) >= 4 && tenthOfNumber(counter) <= 20) {
                    ending = "th";
                } else {
                    ending = "nd";
                }
                break;
            case 3:
                if (tenthOfNumber(counter) >= 4 && tenthOfNumber(counter) <= 20) {
                    ending = "th";
                } else {
                    ending = "rd";
                }
                break;
            default:
                ending = "th";
        }
        res.getWriter().println("<h1>Welcome to the page! You are the " + counter + ending + " visitor!</h1>");
        res.getWriter().println("<p>Add ?reset=yes to the url to reset the counter</p>");

        if (reset.equals("yes")){
            counter =0;
        }
    }

    private int tenthOfNumber(int number) {
        return number % 100;
    }

    private int lastNumber(int number) {
        return number % 10;
    }
}

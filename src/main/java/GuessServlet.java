import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet{
    Random rand = new Random();
    int num = rand.nextInt(10) + 1;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/guess.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int choice = Integer.parseInt(req.getParameter("guess"));
        String restart = req.getParameter("reset");
        String value;
        if (choice > num) {
            value = "You need to go lower";
            req.setAttribute("value", value);
            req.getRequestDispatcher("/winner.jsp").forward(req, res);
        }
        if (choice < num) {
            value = "You need to go higher";
            req.setAttribute("value", value);
            req.getRequestDispatcher("/winner.jsp").forward(req, res);
        }
        if (choice == num) {
            value = "You win!";
            req.setAttribute("loser", "");
            req.setAttribute("value", value);
            req.getRequestDispatcher("/winner.jsp").forward(req, res);
        }

        if (restart.equals("Play Again?")){
            num = rand.nextInt(10) + 1;
            req.setAttribute("choice", 0);
            req.getRequestDispatcher("/guess.jsp").forward(req, res);
        }
    }
}

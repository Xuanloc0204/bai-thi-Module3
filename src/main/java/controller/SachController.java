package controller;

import model.Sach;
import service.sach.ISachService;
import service.sach.SachService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SachController", urlPatterns = "/Sach")
public class SachController extends HttpServlet {
    private final ISachService sachService = new SachService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "viewRoom":
//                    viewRoom(req, resp);
//                break;
            case "listSach":
                listSach(req, resp);
                break;
            default:
                listSach(req, resp);
                break;
        }
    }

    private void listSach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Sach> sach = sachService.findAllSach();
            req.setAttribute("sach", sach);
            RequestDispatcher dispatcher = req.getRequestDispatcher("listSach.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace(); // Ghi log lỗi chi tiết
            req.setAttribute("error", "Cannot retrieve the room list.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
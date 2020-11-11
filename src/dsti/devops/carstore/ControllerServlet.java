package dsti.devops.carstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all requests from the user.
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarCRUD carCRUD;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        carCRUD = new CarCRUD(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertCar(request, response);
                break;
            case "/delete":
                deleteCar(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCar(request, response);
                break;
            default:
                listCar(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Car> listCar = carCRUD.listAllCars();
        request.setAttribute("listCar", listCar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String matriculation = request.getParameter("matriculation");
        Car existingCar = carCRUD.getCar(matriculation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CarForm.jsp");
        request.setAttribute("car", existingCar);
        dispatcher.forward(request, response);
 
    }
 
    private void insertCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String matriculation = request.getParameter("matriculation");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        float price = Float.parseFloat(request.getParameter("price"));
 
        Car newCar = new Car(matriculation, brand, model, price);
        carCRUD.insertCar(newCar);
        response.sendRedirect("list");
    }
 
    private void updateCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String matriculation = request.getParameter("matriculation");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        float price = Float.parseFloat(request.getParameter("price"));
 
        Car car = new Car(matriculation, brand, model, price);
        carCRUD.updateCar(car);
        response.sendRedirect("list");
    }
 
    private void deleteCar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	String matriculation = request.getParameter("matriculation");
 
        Car car = new Car(matriculation);
        carCRUD.deleteCar(car);
        response.sendRedirect("list");
 
    }
}

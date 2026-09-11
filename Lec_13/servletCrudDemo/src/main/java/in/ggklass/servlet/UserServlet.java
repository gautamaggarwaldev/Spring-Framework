package in.ggklass.servlet;

import in.ggklass.model.User;
import in.ggklass.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null || name == null || email == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"some fields are missing\"}");
            return;
        }

        Integer id = Integer.parseInt(idParam);

        User user = new User(id, name, email, mobile);
        userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write("{\"message\":\"user added successfully\"}");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        response.setContentType("application/json");
        if (idParam == null) {
            List<User> users = userService.getAllUsers();
            response.setStatus(200);
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParam);
        User user = userService.getUserById(id);
        if (user == null) {
            response.setStatus(404);
            response.getWriter().write("{\"message\":\"user not found\"}");
            return;
        }
        response.setStatus(200);
        response.getWriter().write(userToJson(user));
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || name == null || email == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"some fields are missing\"}");
            return;
        }

        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"user not found\"}");
            return;
        }

        User updatedUser = new User(id, name, email, mobile);
        userService.updateUser(updatedUser);

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(updatedUser));
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (id == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"id is required\"}");
            return;
        }

        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\":\"user not found\"}");
            return;
        }

        userService.deleteUser(id);
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write("{\"message\":\"user deleted successfully\"}");
    }

    /**********************************************************************************************************************/
    /**********************************************************************************************************************/
    /**********************************************************************************************************************/
    /**********************************************************************************************************************/

    private String userToJson(User user) {
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : " + user.getName() + ",\n" +
                "    \"email\" : " + user.getEmail() + ",\n" +
                "    \"mobile\" : " + user.getMobile() + "\n" +
                "}";
    }

    private String usersToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(int i=0;i<users.size();i++) {
            stringBuilder.append(userToJson(users.get(i)));

            if(i<users.size()-1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.model.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Path("/users")
public class UserService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(UserModel userModel) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(userModel);

        if (userModel != null) {
            try {
                if (userModel.getBirthYear() > 2000)
            }
        }
    }

    @GET
    @Path("/{getAll}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        UserDao userDao = new UserDaoImpl();
        return Response.ok().entity(userDao.getAll()).build();
    }

    @GET
    @Path("/{gender}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getByGender(@PathParam("gender") UserModel userModel) {
        UserModel baseUser = new UserDaoImpl().getByGender(userModel.getGender());
        if (baseUser != null) {
            return Response.ok()
                    .entity(baseUser.toString())
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Ничего не найдено!").build();
    }

    public Response delete() {

    }
}

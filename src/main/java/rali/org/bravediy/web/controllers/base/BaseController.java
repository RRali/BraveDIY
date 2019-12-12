package rali.org.bravediy.web.controllers.base;



import rali.org.bravediy.services.models.auth.LoginUserServiceModel;

import javax.servlet.http.HttpSession;

public class BaseController {
    protected boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    protected String getUsername(HttpSession session) {
        return ((LoginUserServiceModel) session.getAttribute("user")).getUsername();
    }
    protected String getName(HttpSession session) {
        return ((LoginUserServiceModel) session.getAttribute("user")).getName();
    }
}

package com.amigo.control;

import com.amigo.present.UserPresenter;
import com.amigo.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @Autowired
    UserPresenter presenter;

    @GetMapping("/dashboard")
    public ModelAndView showDashboard(@ModelAttribute User user) {
        if (!user.isValid() && !presenter.hasUser()) {
            return new ModelAndView("404");
        }
        if (user != null) {
            presenter.setUser(user);
        }
        ModelAndView mav = new ModelAndView("dashboard");
        presenter.populate(mav.getModel());
        return mav;
    }
}

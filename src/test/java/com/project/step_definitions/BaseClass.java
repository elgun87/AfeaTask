package com.project.step_definitions;

import com.project.pages.Cart;
import com.project.pages.DashBoardPage;
import com.project.pages.LoginPage;

public abstract class BaseClass{
    public Cart cart = new Cart();
    public DashBoardPage dashBoardPage = new DashBoardPage();
    public LoginPage loginPage = new LoginPage();
}

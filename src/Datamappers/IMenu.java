package Datamappers;

import Model.Pizza;

import java.util.ArrayList;

public interface IMenu {

    ArrayList<Pizza> getMenuItems();

    Pizza getMenuItemById(int pizzaID);
}

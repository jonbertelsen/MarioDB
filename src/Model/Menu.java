package Model;

import Datamappers.MenuMapper;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Pizza> menuCard = null;
    private MenuMapper menuMapper;

    public Menu() {
        menuMapper = new MenuMapper();
        loadMenu();

    }

    public ArrayList<Pizza> getMenuCard() {
        return menuCard;
    }

    public void loadMenu(){
        menuCard = menuMapper.getMenuItems();
    }

    public Pizza getMenuItemById(int id){

        Pizza pizza = menuMapper.getMenuItemById(id);
        return pizza;
    }

}

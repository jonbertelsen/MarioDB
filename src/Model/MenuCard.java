package Model;

import Datamappers.MenuMapper;

import java.util.ArrayList;

public class MenuCard {
    private ArrayList<Pizza> menuCard = null;
    private MenuMapper menuMapper;

    public MenuCard() {
        menuMapper = new MenuMapper();
        loadMenu();

    }

    public ArrayList<Pizza> getMenuCard() {
        return menuCard;
    }

    private void loadMenu(){
        menuCard = menuMapper.getMenuItems();
    }

    public Pizza getMenuItemById(int id){

        return menuMapper.getMenuItemById(id);
    }

}

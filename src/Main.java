
import Controller.FruitShopManagement;
import View.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author HI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FruitShopManagement today = new FruitShopManagement();
        Menu menu = new Menu("FRUIT SHOP MANAGEMENT",
                new String[]{"Create Fruit",
                    "View Orders",
                    "Shopping (for buyers)",
                    "Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1: {
                        today.addFruit();
                        break;
                    }
                    case 2: {
                        today.viewOrders();
                        break;
                    }
                    case 3: {
                        today.shopping();
                        break;
                    }
                    case 4: {
                        System.out.println("Thank you!");
                        break;
                    }
                }
            }
        };
        menu.run();
    }

}

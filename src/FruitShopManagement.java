
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HI
 */
public class FruitShopManagement {

    protected ArrayList<Fruit> fruitList = new ArrayList<>();
    private HashMap<String, ArrayList<Fruit>> CustomerOrder = new HashMap();

    private int isExist(String id) {
        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addFruit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fruit id: ");
        String id = sc.nextLine();
        if (isExist(id) == -1) {
            System.out.print("Enter fruit name: ");
            String name = sc.nextLine();
            System.out.print("Enter fruit price: ");
            double price = sc.nextDouble();
            System.out.print("Enter fruit quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter fruit origin: ");
            String origin = sc.nextLine();
            Fruit fr = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fr);
        } else {
            System.out.println("There has been a fruit with ID: " + id);
        }
        System.out.println("Do you want to continue (Y/N)? ");
        String option = sc.nextLine();
        if (option.equalsIgnoreCase("y")) {
            addFruit();
        } else if (option.equalsIgnoreCase("n")) {
            displayFruitCreated();
        }
    }

    public void displayFruitCreated() {
        System.out.println("FRUIT CREATED: ");
        for (Fruit fr : fruitList) {
            System.out.println(fr.toString());
        }
        System.out.println("---------------------");
    }

    public void displayListOfFruits() {
        System.out.println("List of fruit: ");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int i = 1;
        for (Fruit fr : fruitList) {
            System.out.printf("       %-10d %-18s %-16s %.1f $ %n",i, fr.getName(), fr.getOrigin(), fr.getPrice());
//            System.out.println("\t" + i + "\t\t" + fr.getName() + "\t\t" + fr.getOrigin() + "\t\t" + fr.getPrice() + "$");
            i++;
        }
    }

    public Fruit getFruit(int i) {
        return fruitList.get(i);
    }

    public void shopping() {
        ArrayList<Fruit> itemList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String choice;
        Fruit fruit = new Fruit();
        do {
            displayListOfFruits();
            int itemNumber = sc.nextInt();
            System.out.println("You selected: " + getFruit(itemNumber - 1).getName());
            System.out.print("Please input quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Do you want to order now (Y/N)? ");
            choice = sc.nextLine();
            fruit = new Fruit(getFruit(itemNumber - 1).getId(), getFruit(itemNumber - 1).getName(), getFruit(itemNumber - 1).getPrice(), quantity, getFruit(itemNumber - 1).getOrigin());
            itemList.add(fruit);
        } while (!choice.equalsIgnoreCase("y"));
        System.out.println("Product | Quantity | Price | Amount");
        double total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%-10s %-10d %.1f $ %8.1f $ %n", itemList.get(i).getName(), itemList.get(i).getQuantity(), itemList.get(i).getPrice(), itemList.get(i).getQuantity() * itemList.get(i).getPrice());
//            System.out.println(itemList.get(i).getName() + "\t" + itemList.get(i).getQuantity() + "\t" + itemList.get(i).getPrice() + "$" + "\t" + itemList.get(i).getQuantity() * itemList.get(i).getPrice() + "$");
            total += itemList.get(i).getQuantity() * itemList.get(i).getPrice();
        }
        System.out.println("Total: " + total + "$");
        System.out.print("Input your name: ");
        String customerName = sc.nextLine();
        CustomerOrder.put(customerName, itemList);
    }

    public void viewOrders() {
        for (String customerName : CustomerOrder.keySet()) {
            System.out.println("---------------------");
            System.out.println("Customer: " + customerName);
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            for (int i = 0; i < CustomerOrder.get(customerName).size(); i++) {
                System.out.printf("%d. %-10s %-10d %.1f $ %8.1f $ %n", i+1, CustomerOrder.get(customerName).get(i).getName(), CustomerOrder.get(customerName).get(i).getQuantity(), CustomerOrder.get(customerName).get(i).getPrice(), CustomerOrder.get(customerName).get(i).getQuantity() * CustomerOrder.get(customerName).get(i).getPrice());
//                System.out.print(i + 1 + "." + CustomerOrder.get(customerName).get(i).getName());
//                System.out.print("\t");
//                System.out.println(CustomerOrder.get(customerName).get(i).getQuantity() + "\t" + CustomerOrder.get(customerName).get(i).getPrice() + "$" + "\t" + CustomerOrder.get(customerName).get(i).getQuantity() * CustomerOrder.get(customerName).get(i).getPrice() + "$");
                total += CustomerOrder.get(customerName).get(i).getQuantity() * CustomerOrder.get(customerName).get(i).getPrice();
            }
            System.out.println("Total: " + total + "$");
        }
    }
}

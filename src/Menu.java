
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HI
 */
public abstract class Menu {
    public static int getMenu(){
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View Orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("-------------------------------");
        System.out.print("Enter option: ");
        option = sc.nextInt();
        sc.nextLine();
        return option;
    }
}

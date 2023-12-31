package com.solvd.zoomaven;

import com.solvd.zoomaven.enums.Health;
import com.solvd.zoomaven.interfaces.IFly;
import com.solvd.zoomaven.models.Duck;
import com.solvd.zoomaven.models.Eagle;
import com.solvd.zoomaven.models.Ticket;

public class FourHomework {
    public static void main(String[] args) {

        /*Add 5 interfaces to the existing hierarchy.
        Use polymorphism with the abstract class and interface from the hierarchy.
        Create final class, method, variable.
        Create a static block, method, variable.*/




        // Here is the UML
        // https://drive.google.com/file/d/1ckBdXep63E6FVlErL3jLCg0uoyFfvMHT/view?usp=sharing


        System.out.println("1 ---------------------");
        //Add 5 interfaces to the existing hierarchy.
        //IFly, IClimb, IAttack, IHide, ISwim


        System.out.println("2 ---------------------");
        //Use polymorphism with the abstract class and interface from the hierarchy.
        IFly duck = new Duck(2222, "white", Health.HEALTHY, 2000);
        IFly eagle = new Eagle(5000, "brown", Health.HEALTHY,"America");


        duck.fly();
        eagle.fly();


        System.out.println("3 ---------------------");
        //Create final class, method, variable.
        //Final class "Ticket"
        //Final method "getFirstName, getLastName" Class Person
        //Final variable "lastName, firstName" Class Person


        System.out.println("4 ---------------------");
        //Create a static block, method, variable.*/
        //Static block, method and variable in Ticket Class
        System.out.println("Static method: " + Ticket.getTicketsSold());

    }
}

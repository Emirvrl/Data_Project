/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
/**
 *
 * @author emreyazici
 */
public class Manager {
    private SLinkedList sListFirstLevel;
    private DLinkedList dListSecondLevel;
    private int emptyCounter = 0;
    public SLinkedList getsListFirstLevel() {
        return sListFirstLevel;
    }

    public DLinkedList getdListSecondLevel() {
        return dListSecondLevel;
    }
    
    public SLinkedList createList(int level){
        sListFirstLevel = new SLinkedList();
        sListFirstLevel.add("Start", 0);
        if (level==1) {
            for (int i = 1; i < 32; i++) { // first spot is start,last spot is finish point
            sListFirstLevel.add(getSpotTypeFirstLevel(), i);
           }
            System.out.println("List is created for Level 1...");
        }else{
            for (int i = 1; i < 32; i++) { // first spot is start,last spot is finish point
            sListFirstLevel.add(getSpotTypeSecondLevel(), i);
                System.out.println(getSpotTypeSecondLevel());
           }
            System.out.println("List is created for Level 2...");
        }
        sListFirstLevel.add("Finish", 32);
        return sListFirstLevel;
    }
    
    private String getSpotTypeFirstLevel(){
        String spots[]={"Treasure","Trap","Empty"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(spots.length);
        if (randomIndex==2) {
            emptyCounter++;
            if (emptyCounter>4) {
                randomIndex = rand.nextInt(spots.length-1);
                emptyCounter--;
            }
        }
        
        return spots[randomIndex];
    }
    
    private String getSpotTypeSecondLevel(){
        String spots[]={"Treasure","Trap","Forward","Back","Empty"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(spots.length);
        if (randomIndex==4) {
            emptyCounter++;
            if (emptyCounter>4) {
                randomIndex = rand.nextInt(spots.length-1);
                emptyCounter--;
            }
        }
        
        return spots[randomIndex];
    }
    
//    public SLinkedList createMapSecondLevel(){
//        dListSecondLevel = new DLinkedList();
//        sListFirstLevel.add("Start", 0);
//        for (int i = 1; i < 32; i++) { // first spot is start,last spot is finish point
//            sListFirstLevel.add(getSpotTypeSecondLevel(), i);
//        }
//        sListFirstLevel.add("Finish", 32);
//        System.out.println("Map is created for Level 2...");
//        return sListFirstLevel;
//    }
}

package engine;

import java.io.Serializable;

public class testObject implements Serializable {  
    String one;
    String two;

    public testObject(String one, String two){
        this.one = one;
        this.two = two;
    } 

    public String toString(){
        return "" + one +" " + two;
    }    

}
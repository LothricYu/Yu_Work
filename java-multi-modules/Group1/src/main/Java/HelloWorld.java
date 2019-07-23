import java.awt.*;

public class HelloWorld {
    public String SayHello(){
        return"Hello Maven";
    }
    public static void main(String args[]){

        System.out.print(new HelloWorld().SayHello());

    }
}

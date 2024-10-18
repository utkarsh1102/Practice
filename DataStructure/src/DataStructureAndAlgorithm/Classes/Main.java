package DataStructureAndAlgorithm.Classes;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
//        Cookie myCookie = new Cookie("Green");
//        Cookie myCookietwo = new Cookie("red");
//
//        myCookie.setColor("Yellow");
//
//        System.out.println(myCookie.getColor());
//        System.out.println(myCookietwo.getColor());

        HashMap<String , Integer> map1 = new HashMap<>();
        HashMap<String , Integer> map2 = new HashMap<>();

        map1.put("Value" , 64);
        map2 = map1;

        map1.put("ergalue",22);

        System.out.println(map1);
        System.out.println(map2);

    }


}

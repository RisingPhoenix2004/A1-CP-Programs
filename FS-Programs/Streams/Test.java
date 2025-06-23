import java.util.*;
import java.util.stream.*;
class Test{
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        Stream<String> stream = list.stream();
        list.add("three");
        list.remove(1);
        String s = stream.collect(Collectors.joining(" "));
        System.out.println(s);
    }
}
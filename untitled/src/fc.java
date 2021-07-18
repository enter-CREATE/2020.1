import java.util.ArrayList;
import java.util.List;

public class fc {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("王");
        list.add("张");
        list.add("李");
        list.add("赵");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

import java.util.*;

class NewClass2 {

    int newField;

    int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {
        return oldField;
    }
}

public class AnnotationEx3 {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        NewClass2 nc2 = new NewClass2();

        nc2.oldField = 10;
        System.out.println(nc2.getOldField());

        @SuppressWarnings("unchecked")
        ArrayList<NewClass2> list = new ArrayList();
        list.add(nc2);
    }
}

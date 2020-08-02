package HomeWork6;

public class DataMain01 {
    public static void main(String[] args) {
        //DataContainer<String> data = new DataContainer<>(new String[0]);
        DataContainer<String> data = new DataContainer<>();

        int index1 = data.add("AAAAA");
        int index2 = data.add("Элюмент дзва");
        int index3 = data.add("Элюмент тры");


        System.out.println(data.get(index1));
        System.out.println(data.get(index2));
        System.out.println(data.get(index3));

        boolean res_of_del = false;
        //int el = 0;
        //res_of_del = data.delete(el);
        //System.out.println("Результат удаления элемента [" + el + "]: " + res_of_del);

        res_of_del = data.delete("Элюмент дзва");

        System.out.println("После удаления одного элемента:");
        System.out.println(data.get(index1));
        System.out.println(data.get(index2));

        //System.out.println("Элемент [" + el + "]: " + data.get(el));
        //System.out.println("Результат удаления элемента: " + res_of_del);

        //System.out.println("Элемент [1]: " + data.get(1));
    }
}

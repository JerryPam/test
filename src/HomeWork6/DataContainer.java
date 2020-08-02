
// https://issue.life/questions/529085
// DataContainer


package HomeWork6;


public class DataContainer<T> {
    private Object[] data;

    public DataContainer(){
        this.data = new Object[1];
        //this.data = initArr;
    }

    public int add(T item){
        if (data[0] == null){ // если первый элемент массива пустой, значит он единственный
            this.data[0] = item;
            return 0; // вернём индекс единственного элемента
        } else { // если количество элементов в массиве больше одного
            Object[] b = new Object[this.data.length + 1];
            b[this.data.length] = item;
            for (int i = 0; i < this.data.length; i++) {
               b[i] = data[i];
            }
            data = b;
            return this.data.length - 1; // вернём ссылку на последний элемент (который занесли в массив)
        }
    }

    boolean delete(int index){
        if (index < 0 || index > this.data.length - 1) return false;
        else {
            Object[] b = new Object[this.data.length - 1]; // созд новый массив размерностью на один элемент меньше, чем существующий
            int i2 = 0;
            int a = 0; // заглушка (переменная для пустой операции)
            for (int i = 0; i < this.data.length; i++) { // идём по элементам существующего массива
                if (i == index){ a++; } // пропустим удаляемый элемент
                else {
                    b[i2] = data[i];
                    i2++;
                }
            }
            data = b;
            return true;
        }
    }

    boolean delete (T item){
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(item)) {
                Object[] b = new Object[this.data.length - 1]; // созд новый массив размерностью на один элемент меньше, чем существующий
                int i2 = 0;
                int a = 0; // заглушка (переменная для пустой операции)
                for (int j = 0; j < this.data.length; j++) { // идём по элементам существующего массива
                    if (j == i){ a++; } // пропустим удаляемый элемент
                    else {
                        b[i2] = data[j]; // заполним новую таблицу
                        i2++;
                    }
                }
                data = b;
                return true;
            }
        }
        return false;
    }

    public T get(int index){
        return (T) this.data[index];
    }

    public T[] getItems(){
        return (T[]) this.data;
    }
/*
    int length_mas(){
        return this.data.length;
    }
 */
/*
        int index = this.data.length - 1;
        this.data[index] = item;
        return index;
 */
}

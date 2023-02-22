import java.util.*;
public class hw_3 {

//    1 Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
//    2 Пусть дан произвольный список целых чисел, удалить из него четные числа
//    3* Реализовать алгоритм сортировки слиянием
        public static void main(String[] args) {
            Scanner tas = new Scanner(System.in);
            System.out.println("Какую задачу смотрим? ");
            int tasks = tas.nextInt();
//        tas.close();
            switch (tasks){
                case (1):
                    Scanner newS1 = new Scanner(System.in);
                    System.out.println("Введите длину массива: ");
                    int len1 = newS1.nextInt();
                    System.out.println("Введите начальный элемент массива: ");
                    int min1 = newS1.nextInt();
                    System.out.println("Введите конечный элемент массива: ");
                    int max1 = newS1.nextInt() + 1;
                    newS1.close();
                    minMaxEq(newArray(len1, min1, max1));
                    break;

                case (2):
                    Scanner newS2 = new Scanner(System.in);
                    System.out.println("Введите длину массива: ");
                    int len2 = newS2.nextInt();
                    System.out.println("Введите начальный элемент массива: ");
                    int min2 = newS2.nextInt();
                    System.out.println("Введите конечный элемент массива: ");
                    int max2 = newS2.nextInt() + 1;
                    newS2.close();
                    honestDel(newArray(len2, min2, max2));
                    break;

                case (3):
                    Scanner newS3 = new Scanner(System.in);
                    System.out.println("Введите длину массива: ");
                    int len3 = newS3.nextInt();
                    System.out.println("Введите начальный элемент массива: ");
                    int min3 = newS3.nextInt();
                    System.out.println("Введите конечный элемент массива: ");
                    int max3 = newS3.nextInt() + 1;
                    newS3.close();
                    System.out.println("Отсортированный массив: " + sortInMerge(newArray(len3, min3, max3)));
                    break;

                default:
                    System.out.println("Такую задачу не смотрели");

            } // switch
        }
        static ArrayList<Integer> newArray (int len, int min, int max){
            ArrayList<Integer> newArr = new ArrayList<>();
            Random rand = new Random();

            for (int i = 0; i < len; i++) {
                newArr.add(rand.nextInt(min, max));
            }
            System.out.println("Изначальный массив: " + newArr);
            return newArr;
        }


        public static void minMaxEq(ArrayList<Integer> list){

            double sum = 0;
            for (int i : list){
                sum += i;
            }
            double arithm = sum / list.size();

            System.out.printf("Среднее арифметическое элементов массива: %.2f\n", arithm);
            System.out.println("Минимальный элемент массива: " + list.get(0));
            System.out.println("Максимальный элемент массива: " + list.get(list.size()-1));
        }

        public static void honestDel(ArrayList<Integer> list){
            Iterator<Integer> iter = list.iterator();

            while (iter.hasNext()){
                int i = iter.next();
                if (i % 2 == 0){
                    iter.remove();
                }
            }
            System.out.println("Отформатированный список без четных элементов: " + list);
        }

        public static ArrayList<Integer> sortInMerge(ArrayList<Integer> list){
            if (list.size() > 1) {
                ArrayList<Integer> buff1 = new ArrayList<>();
                ArrayList<Integer> buff2 = new ArrayList<>();

                int half = list.size() / 2;

                for (int i = 0; i < half; i++) {
                    buff1.add(list.get(i));
                }
                for (int i = half; i < list.size(); i++) {
                    buff2.add(list.get(i));
                }

                sortInMerge(buff1);
                sortInMerge(buff2);

                merge(buff1, buff2, list);
            }
            return list;
        }

        public static void merge(ArrayList<Integer> buff1, ArrayList<Integer> buff2, ArrayList<Integer> list){

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < buff1.size() && j < buff2.size()){
                if (buff1.get(i) < buff2.get(j)){
                    list.set(k,buff1.get(i));
                    i++;
                }
                else{
                    list.set(k,buff2.get(j));
                    j++;
                }
                k++;
            }
            while (i < buff1.size()){
                list.set(k,buff1.get(i));
                i++;
                k++;
            }

            while (j < buff2.size()){
                list.set(k,buff2.get(j));
                j++;
                k++;
            }
        }
    }


package turn;
import java.util.Arrays;
import java.util.Scanner;
public class turn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder strS = new StringBuilder();
        String str;
        StringBuilder qq = new StringBuilder();
        StringBuilder qq1 = new StringBuilder();
        int n = 0, m = 0;
        System.out.println("введите 1 для поворота по часовой стрелке, или 0 против");
        int ss1 = sc.nextInt();
        str = sc.nextLine();
        System.out.println("введите матрицу");
        boolean value3 = false;
        while (!value3) { //вычисляем m и n
            str = sc.nextLine(); //скан строки
            strS.append(str).append(" "); // сохраняем матрицу в строку
            value3 = str.isEmpty( );
            if (n < str.length())
                n=str.replace(" ", "").length();//столбцов
            m++; //строк
        }
        // разбиваем строку на массив, задаем таблицу по найденым m и n
        m--;
        String[] s = strS.toString().split(" ");
        String[][] t = new String[m][n];
        for (int i = 0, j = 0; (i <m ); i++, j = j + n) { //цикл разбиения
            t[i] = Arrays.copyOfRange(s, j, j + n);
        } //строка
        String[][] arr1 = new String[n][m]; //создание матрицы поворота +
        String[][] arr = new String[n][m]; //создание матрицы поворота -
        for (int i = 0; i < n; i++) { //строк
            for (int j = 0; j < m; j++) {  //столбцов
                arr[i][j] = t[j][n - i - 1]; //поворот против часовой на 90
                arr1[i][j] = t[m - j - 1][i];// поворот по часовой на 90
                qq.append(arr[i][j]).append(" "); //создание строки
                qq1.append(arr1[i][j]).append(" ");
            }
            if (ss1 == 1) {
                System.out.println(qq.toString().trim());
                qq = new StringBuilder();
            } else {
                System.out.println(qq1.toString().trim());
                qq1 = new StringBuilder();
            }
        }
    }
}



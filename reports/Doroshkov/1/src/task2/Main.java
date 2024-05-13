import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double [] arr_input;
        if(args.length == 0)
        {
            arr_input = new double[1];
        }else {
            arr_input = new double[args.length];
        }

        for(int i=0; i<args.length;i++)
        {
            arr_input[i] = Double.parseDouble(args[i]);
        }
        int i = 4;
        double[] shifted_arr = shift_left(arr_input, i);
        for (int j=0;j<shifted_arr.length;j++) {
            System.out.printf(shifted_arr[j]+"\t");
        }
    }
    public static double[] shift_left(double[] arr, int shift)
    {
        double[] new_arr= new double[arr.length];

        for(int i=0; i<=shift;i++)
        {

                 for(int j=0; j<arr.length;j++)
                 {
                    new_arr[j] = arr[(j+i)% arr.length];
                 }

        };
        return new_arr;
    }

}
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] arr_input = new int[args.length];
        for(int i=0; i<args.length;i++)
        {
            arr_input[i] = Integer.parseInt(args[i]);
        }
        int amount_1 = 0, amount_2 = 0, amount_3 = 0; // номер зависит от количества цифр в числе 1 - однозначное 2- двузначное 3- трехзначное

        for (int i=0; i<arr_input.length;i++){
            int noun_digit = 1;
            while ((arr_input[i]/10)>0){
                noun_digit+=1;
                arr_input[i] = arr_input[i]/10;
            }
            arr_input[i] = noun_digit;
        }


        for (int i = 0; i < arr_input.length; i++) {
            int amount =1;
            int noun_digit = arr_input[i];
            for(int j =i+1; j<arr_input.length;j++)
            {
                if(arr_input[i] == arr_input[j] && arr_input[j]!=0)
                {
                    amount +=1;
                    arr_input[j] = 0;
                }

            }
            if( noun_digit !=0)
            {
                System.out.println(noun_digit+" desyatkov: " + amount);
            }
        }
    }
}


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static StringBuffer sortFrequency(int arr1[], int l1)
    {
        Map<Integer, Integer> sortMap = frequencyMap(arr1, l1);
        StringBuffer output = new StringBuffer();
        sortMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .forEach(e ->
                {
                    int key = e.getKey();
                    int val = e.getValue();
                    for (int i = 0; i < val; i++)
                    {
                        output.append(key + " ");
                    }
                });
        return output;
    }
    private static Map<Integer, Integer> frequencyMap(int[] arr, int l1)
    {
        Map<Integer, Integer> FrequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < l1; i++)
        {
            if (FrequencyMap.containsKey(arr[i]))
            {
                FrequencyMap.put(arr[i], FrequencyMap.get(arr[i]) + 1);
            }
            else
            {
                FrequencyMap.put(arr[i], 1);
            }
        }
        return FrequencyMap;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.print("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Исходный массив: "+ Arrays.toString(arr));
        System.out.println("Отсортированный массив: "+sortFrequency(arr, arr.length));
    }
}
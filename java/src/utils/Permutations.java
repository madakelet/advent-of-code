package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> void allPermutationsHelper(T[] permutation, List<T[]> permutations, int n) {
        if (n <= 0) {
            permutations.add(Arrays.copyOf(permutation, permutation.length));
            return;
        }
        T[] tempPermutation = Arrays.copyOf(permutation, permutation.length);
        for (int i = 0; i < n; i++) {
            swap(tempPermutation, i, n - 1);
            allPermutationsHelper(tempPermutation, permutations, n - 1);
            swap(tempPermutation, i, n - 1);
        }
    }

    public static <T> List<T[]> permutations(T[] original) {
        List<T[]> permutations = new ArrayList<>();
        allPermutationsHelper(original, permutations, original.length);
        return permutations;
    }
}

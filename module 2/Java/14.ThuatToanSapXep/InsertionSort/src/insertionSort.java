public static void insertionSort(int[] list) {
    for (int i = 1; i < list.length; i++) {
        int key = list[i];
        int j = i - 1;

        // Dịch các phần tử lớn hơn key sang phải
        while (j >= 0 && list[j] > key) {
            list[j + 1] = list[j];
            j--;
        }

        // Chèn key vào đúng vị trí
        list[j + 1] = key;
    }
}

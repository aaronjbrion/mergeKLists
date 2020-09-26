public class KLists {

    public double[] mergeKLists (double[][] outerArray) {
        if (outerArray.length == 0) {
            return new double[0];
        }
        double[] result = outerArray[0];
        for (int i = 1; i < outerArray.length; i++) {
            result = merge(result, outerArray[i]);
        }
        return result;
    }
    public double[] merge(double[] left, double[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        int leftLength = left.length;
        int rightLength = right.length;
        double[] result = new double[leftLength + rightLength];

        while(l < leftLength && r < rightLength){
            if (left[l] <= right[r]) {
                result[i] = left[l++];
            }
            else {
                result[i] = right[r++];
            }
            i++;
        }
        while(l < leftLength) {
            result[i++] = left[l++];
        }
        while(r < rightLength) {
            result[i++] = right[r++];
        }
        return result;
    }

    public void arrayOutput(double[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if (arr.length > 0) {
            System.out.print(arr[arr.length-1]);
        }
        System.out.print("]\n");
    }

    public static void main(String args[]) {
        KLists kLists = new KLists();
        double[][] firstArray = { {1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6} };
        double[][] secondArray = {};
        double[][] thirdArray = {{}};
        double[][] fourthArray = { {9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27} };

        double[] firstResult = kLists.mergeKLists(firstArray);
        double[] secondResult = kLists.mergeKLists(secondArray);
        double[] thirdResult = kLists.mergeKLists(thirdArray);
        double[] fourthResult = kLists.mergeKLists(fourthArray);

        kLists.arrayOutput(firstResult);
        kLists.arrayOutput(secondResult);
        kLists.arrayOutput(thirdResult);
        kLists.arrayOutput(fourthResult);
    }
}
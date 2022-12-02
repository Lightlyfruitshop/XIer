package round_2nd;

public class question1 {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        Runnable output_1 = () -> {
            try {
                for (int i = 0; i < arr1.length; i++) {
                    System.out.println(arr1[i]);
                    Thread.sleep(1);
                }
            } catch (Exception e) {
            }
        };
        Runnable output_2 = () -> {
            try {
                for (int i = 0; i < arr1.length; i++) {
                    System.out.println(arr2[i]);
                    Thread.sleep(1);
                }
            } catch (Exception e) {
            }
        };
        new Thread(output_1).start();
        new Thread(output_2).start();
    }
}

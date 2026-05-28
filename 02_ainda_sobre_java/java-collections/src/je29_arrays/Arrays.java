package je29_arrays;

public class Arrays {

    public static void main(String[] args) {
//        Integer[] meuArray = new Integer[6];
        Integer[] meuArray = new Integer[]{2, 4, 10, 5, 15, 3};

//        meuArray[0] = 2;
//        meuArray[1] = 4;
//        meuArray[2] = 10;
//        meuArray[3] = 5;
//        meuArray[4] = 15;
//        meuArray[5] = 3;

//        for (int i = 0; i < meuArray.length; i++) {
//            System.out.println(meuArray[i]);
//        }

        for (Integer integer : meuArray) {
            System.out.println(integer);
        }
    }

}

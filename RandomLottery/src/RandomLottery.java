import sun.plugin.javascript.navig.Array;

import java.util.*;

public class RandomLottery {

    static List<Integer> mBasetList = null;

    public static List<Integer> getRandomNumber(int min, int max, int k){

        if (min < 0 || max <= min){
            return  null;
        }
        int size = max - min + 1;
        if( k < 0 || k > size){
            return null;
        }

        if(mBasetList == null){
            mBasetList = new ArrayList<Integer>();
        }
        mBasetList.clear();
        for (int i = min; i <= max; i++) {
            mBasetList.add(i);
        }

        List<Integer> result = new ArrayList<Integer>();
        Random random = new Random();

        for (; k > 0; ) {
            int index = random.nextInt(size);
            result.add( mBasetList.get( index ));
            mBasetList.remove( index );

            k--;
            size--;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("你会挑选多少个号码：");
        int k = in.nextInt();

        System.out.println("请输入选择的号码范围：（min —— max）");

        int min = in.nextInt();
        int max = in.nextInt();

        System.out.printf("%d %d %d\n", min, max, k);

        List<Integer> result = RandomLottery.getRandomNumber(min, max, k);

        if (result == null){
            System.out.println("重新进行选号设置。");
        } else {
            System.out.println("你选择的幸运号码是：");
            for(int item: result){
                System.out.print(item + " ");
            }
        }


    }
}

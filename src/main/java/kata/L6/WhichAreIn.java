package kata.L6;

import java.util.Arrays;
//Given two arrays of strings a1 and a2 return a sorted array r in
//lexicographical order of the strings of a1 which are substrings of strings of a2.
//Example 1:
//a1 = ["arp", "live", "strong"]
//
//a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//
//returns ["arp", "live", "strong"]
//
//Example 2:
//a1 = ["tarp", "mice", "bull"]
//
//a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
//
//returns []
public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(array2).forEach(str -> sb.append(str));
        return Arrays.stream(array1)
                .filter(item-> sb.indexOf(item) > -1)
                .toArray(String[]::new);
    }

    public static String[] inArray_solution(String[] array1, String[] array2) {
        return Arrays.stream(array1)
                .filter(str ->
                        Arrays.stream(array2).anyMatch(s -> s.contains(str)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
    }

    //tips1 stream.toArray() 转数组 默认是object数组，可传参转化obj类型;如构建string数组 调用new String
    //tips2 anymatch一旦为true则立马返回true 不再继续执行下去
    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        long t1 = System.currentTimeMillis();
        for(int i=0;i<1_00_0000;i++){
            //time 3279ms
            WhichAreIn.inArray(a, b);
            //time 4033ms
//            WhichAreIn.inArray_solution(a, b);
            System.out.println(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
//        Arrays.stream(WhichAreIn.inArray_solution(a, b)).forEach(System.out::println);
    }
}

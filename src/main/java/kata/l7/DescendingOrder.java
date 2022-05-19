package kata.l7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Your task is to make a function that can take any non-negative integer as an argument and
// return it with its digits in descending order.
// Essentially, rearrange the digits to create the highest possible number.
//
//Examples:
//Input: 42145 Output: 54421
//
//Input: 145263 Output: 654321
//
//Input: 123456789 Output: 987654321
public class DescendingOrder {

    public static int descending(int num){
        char[] chars = String.valueOf(num).toCharArray();
        List<Integer> ints = new ArrayList<>();
        for(char c : chars){
            ints.add(Character.getNumericValue(c));
        }
        String str = ints.stream()
                .sorted((o1, o2) -> {return o2-o1;}).collect(Collectors.toList())
                .stream().map(i -> i.toString()).collect(Collectors.joining(""));
        return Integer.parseInt(str);
    }


    public static void main(String[] args) {
        System.out.println(descending(15486));
    }

    //标准答案
    //tips1: String.chars()方法可直接获取intStream
    //tips2: sorted使用Comparator.reverseOrder()则降序
    //tips3: collect转字符串为Collectors.joining()
    //tips4: idea方法换行有方法执行返回类提示
    public static int descending_solution(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

}

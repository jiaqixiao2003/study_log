package study.java.colletction.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Collection1_Set {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<String>();
//
//// 增
//        list.add("啦啦啦");
//        list.add("拉拉");
//        list.add("立");
//// 遍历
//        for (int i = 0; i < list.size(); i++) {
//            String s = list.get(i);
//            System.out.println(s);
//        }
//        for (String s : list) {
//            System.out.println(s);
//        }
//// 删
//        list.remove(1);
//        for (String s : list) {
//            System.out.println(s);
//        }
//// 改
//        list.set(1, "lala");
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        HashSet<String> set = new HashSet<>();
////增
//        set.add("啦啦啦");
//        set.add("拉拉");
//        set.add("立");
//        System.out.println("元素个数：" + set.size());
//        System.out.println(set);
//
//        // 查
//        boolean contain = set.contains("lala");
////        System.out.println("?:" + contain);
//
//        // 删
//        boolean removeOk = set.remove("立");
////        System.out.println("remove li?: " + removeOk);
//
//        // 修改元素：~！！！需要先删除后添加；
//        boolean removeFlag = set.remove("拉拉");
//        boolean addLaLa = set.add("lala");
////        System.out.println("Modified set？ :" + (removeFlag && addLaLa));
//
//// 输出修改后的HashSet
//        System.out.println("HashSet after modification: " + set);

        PriorityQueue<String> queue = new PriorityQueue<>();
// 增
        queue.offer("啦啦啦");
        queue.offer("拉拉");
        queue.offer("啦");
        System.out.println(queue);
// out  [啦啦啦，拉拉，啦]
// 删
        queue.poll();
        System.out.println(queue);
// out	[拉拉，啦]
// 改：不支持直接修改，需要先删除再修改
        String first = queue.poll();
        queue.offer("改");
        System.out.println(queue);
// out

    }


}

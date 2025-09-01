package study.java.colletction.map;

import study.java.colletction.map.Student;

import java.util.PriorityQueue;

public class Collection2_PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());

        pq.offer(new Student("王二", 80, 90));
        System.out.println(pq);
        pq.offer(new Student("小1", 95, 95));
        System.out.println(pq);
        pq.offer(new Student("肖佳琦", 90, 95));
        System.out.println(pq);
        pq.offer(new Student("沉默", 90, 80));
        System.out.println(pq);
        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}

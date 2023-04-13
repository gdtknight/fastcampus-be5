package me.day05.objectarrays;

import java.util.Arrays;
import java.util.Objects;

public class Members {
    /////////////////////////////////////////
    // singleton
    private static Members allMembers;

    public static Members getInstance() {
        if (allMembers == null) {
            allMembers = new Members();
        }
        return allMembers;
    }
    /////////////////////////////////////////

    private Member[] members;

    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Members() {
        members = new Member[DEFAULT];
        capacity = DEFAULT;
    }
    private Members(int initial) {
        members = new Member[initial];
        capacity = initial;
    }

    private Members(Member[] members) { //  new Member[] {new Member(), new Member(), new Member(), new Member()}
        this.members = members;
        capacity = members.length;
        size = members.length;
    }

    public void init() { // Members 초기화
        for (int i = 0; i < 10; i++) {
            allMembers.add(new Member(
                    Character.toString('a' + i),
                    Character.toString('a' + i) + "1234"
            ));
        }
    }

    // add, set, get, pop, indexOf, size, capacity
    public int size() {
        return size;
    }

    private int capacity() { //
        return capacity;
    }

    public Member get(int i) {
        if (i < 0 || i >= size) return null;
        return members[i];
    }

    public void set(int i, Member member) {
        if (i < 0 || i >= size) return;
        if (member == null) return;

        members[i] = member;
    }

    public int indexOf(Member member) {
        if (member == null) return -1; // not found (throw exception)

        for (int i = 0; i < size; i++) {
            if (members[i] == null) continue;
            if (members[i].equals(member)) return i;
        }
        return -1;
    }

    // 배열의 cap이 부족한 경우
    public void add(Member member) {
        if (size < capacity) {
            members[size] = member;
            size++;
        } else {
            grow();
            add(member);
        }
    }

    public void add(int index, Member member) {
        if (size < capacity) {
            for (int i = size-1; i >= index ; i--) {
                members[i+1] = members[i];
            }
            members[index] = member;
            size++;
        } else {
            grow();
            add(index, member);
        }
    }

    public Member pop() {
//        if (size == 0) return null;
//
//        Member popElement = members[size-1];
//        members[size-1] = null;
//        size--;
//        return popElement;
        return pop(size-1);
    }

    public Member pop(int index) {
        if (size == 0) return null;
        if (index < 0 || index >= size) return null;

        Member popElement = members[index];
        members[index] = null; // 삭제됨을 명시적으로 표현

        for (int i = index+1; i < size; i++) {
            members[i-1] = members[i];
        }
        members[size-1] = null;
        size--;
        return popElement;
    }

    public void grow() {
        capacity *= 2;
        members = Arrays.copyOf(members, capacity);

        // size는 그대로임
    }
}

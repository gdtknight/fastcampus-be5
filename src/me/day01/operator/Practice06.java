package me.day01.operator;

public class Practice06 {
    public static void main(String[] args) {
        // byte 자료형은 왜 많이 쓰일까? (-128~127 => 미리 메모리에 저장이 되어있음,,,왜? 자주 쓰이니까 (아스키코드))
        // 자바 기본 자료형
        // 숫자 (정수): int
        // 숫자 (실수): double
        byte byte1 = 1;
        byte byte2 = 1;
//        byte byte3 = byte1 + byte2; // byte 끼리 계산하면 연산 후 정수형 중 기본형인 int 로 변경되기 때문에 정수 변수에 담을 수 없음
        int byte3 = byte1 + byte2; // 가능
        System.out.println("byte1 = " + byte1);
        System.out.println("byte2 = " + byte2);
        System.out.println("byte3 = " + byte3);

        byte byteValue = 65;

        int 가 = 10; // 자바는 유니코드를 채택함 (2 바이트 이상)
//        char charValue = byteValue; // byte 의 범위 (-128 ~ 127) 는 char 형 (unsigned)과 다르기 때문에 형변환이 불가능함
        int charValue = byteValue;
        System.out.println("byteValue = " + byteValue);
        System.out.println("charValue = " + charValue);
    }
}

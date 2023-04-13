package com.cos.book.utill;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDateTime {

    public String get_nowData(){
        // 현재 날짜/시간
        Date now = Calendar.getInstance().getTime();
        // 현재 날짜/시간 출력
//            System.out.println(now); // Thu Jun 17 07:05:24 KST 2021

        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
        // 포맷팅 적용
        String formatedNow = formatter.format(now);
        // 포맷팅 현재 날짜/시간 출력
//            System.out.println(formatedNow);  // 2021년 06월 17일 07시 05분 24초
        return formatedNow;
    }
}


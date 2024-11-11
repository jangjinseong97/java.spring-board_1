package com.green.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
// lombok 때문에 에노테이션으로 setter getter가 자동 설정
@ToString
// toString 오버라이딩도 해줌 에노테이션 위에 마우스를 대보면 어디껀지 알 수 있다.
public class BoardInsReq {
    private String title;
    private String contents;
    private String writer;
}

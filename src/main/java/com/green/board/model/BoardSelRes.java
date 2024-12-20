package com.green.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardSelRes {
    private int boardId;
    private String title;
    private String writer;
    private String createdAt;
    // 항상 대소문자 조심 리소스의 매퍼에  _가 들어간 자리로 인해 AS를 주어 대문자로 바꿔주기
}

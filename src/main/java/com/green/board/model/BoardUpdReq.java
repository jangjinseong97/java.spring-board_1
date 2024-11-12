package com.green.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardUpdReq {
    private int boardId;
    private String title;
    private String contents;
    private String writer;
}

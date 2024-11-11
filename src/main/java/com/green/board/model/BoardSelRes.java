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
}

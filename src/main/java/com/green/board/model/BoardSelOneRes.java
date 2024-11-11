package com.green.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardSelOneRes {
    private int boardId;
    private String title;
    private String content;
    private String writer;
    private String createdAt;
}

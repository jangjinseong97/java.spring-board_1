package com.green.board;

/*
    src > main > resource > mappers 폴더 아래에 이름이 같은 xml파일을 만듬
    (사실 같은 이름으로 할 필요는 없지만 관리상 용이하게 하기 위하여 같은 이름을 줌)

    xml + interface 파일을 이용해서 implements한 class 파일을 만들고 빈 등록까지 해준다.
    스프링 컨테이너가 빈등록한 class파일을 객체화 할 것,
    여기서 만든 주소값을 BoardService객체화 할 때 DI해준다.

    insert, update, delete의 리턴타입은 int로 하면됨
 */
import com.green.board.model.BoardInsReq;
import com.green.board.model.BoardSelRes;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsReq p);
    List<BoardSelRes> selBoardList();
}

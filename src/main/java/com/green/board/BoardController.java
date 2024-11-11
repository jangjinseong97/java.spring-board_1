package com.green.board;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    controller의 역할: 요청(request)을 받고 응답(response)을 처리하는 객체
                      로직처리는 하지 않는다.

    @Controller - 응답을 html (데이터로 만든 화면을 응답)
    @RestController - 응답을 json (데이터를 응답)

    @RequestMapping - URL 과 클래스 아래에 있는 Method 맵핑(연결)
                      class 에 RequestMapping을 주면 전체 메소드 주소가 매핑

    @PostMapping - URL + Post 방식으로 요청이 왔을 시
                  담당자 요청과 응답은 (header, body)로 이루어져 있음

    요청과 응답은 (header, body) 로 이루이져 있음
    header에는 목적지(url), 방식, 인코딩 등등
    body에는 값, 데이터가 담겨져 있다.

    FE가 BE에게 url + method + 데이터 요청을 보내고 BE가 JSON으로 응답

    브라우저를 통해 요청을 보낼 때 URL 과 method를 함께 요쳥을 보낸다.
    브라우저의 주소창에 주소값을 적고 엔터는
    URL + GET + 데이터 보내는 방식(Key/Value)으로 요청을 보낸다.

    get과 post 방식의 큰 차이점은 데이터를 보낼때 보여지나 안보여지나 차이
    1. 쿼리스트링 방식 (파라미터라고 부르기도 함), url에 데이터를 포함하는 방식
    2. body에 담아서 보내는 방식

    쿼리스트링 모양 : url + 쿼리스트링 (?로 시작 key=value, 여러개라면 & 구분)
                   www.naver.com?name=홍길동&age=12&height=172.1 이런 방식

    대용량의 데이터를 보내야 할때 body 사용 (url의 길이 제한으로 인해 쿼리스트링은 한계가 있다.)

    Restful 이전에는 get, post방식만 있었음
    get은 주로 쿼리스트링 방식 - 데이터를 읽어올 떄(간혹 삭제할때도 사용)
    post는 body에 데이터를 담아서 보내는 방식 - 데이터를 저장/수정/삭제 할때
    데이터가 있었을 때는 get방식이 처리속도가 빠름, 데이터 처리가 아닌 단순 화면을 띄울때도
    get 방식을 사용

    예를들어 로그인을 하는 상황에서 로그인을 하는 화면이 띄워져야 한다.
    작업(1) 로그인 하는 화면은 get방식으로 url은 /login 이하(get) /login 이렇게 표현
    작업(2) 그 다음, 아이디/비번을 작성하고 로그인 버튼을 누르면 (post) /login 이렇게 요청을 보냄

    url은 같은데 method로 작업을 구분 (if문 처럼)
    위 작업은 2가지 밖에 없었으므로 같은 주소값으로 method를 구분가능
    그런데 CRUD(작업을 4가지)를 해야되는 상황에서 작업구분을 주소값으로 해야됬다.

    (get) /board - 게시판 리스트 보기 화면
    (get) /board_detail - 게시판 글 하나 보기 화면
    (get) /board_create - 게시판 글 등록하는 화면
    (post) /board_create - 게시판 글 등록하는 작업 처리
    (get) /board_mod - 게시판 글 수정하는 화면
    (post) /board_mod - 게시판 글 수정하는 작업 처리
    (post/get) /board_delete - 게시판 글 삭제하는 작업 처리

    즉 get와 post만 있어 주소값들이 지저분해짐

    첫 페이지(index화면)을 띄울 때 화면을 띄울 수 있는 소프트웨어(FE 작업 코드)가 모두 다운로드 됨
    화면 이동은 모두 FE 코드가 작동하는 것.
    화면 만들기는 client 리소스를 활용하여 그린다.(Rendering)
    화면마다 데이터가 필요하다면 FE 작업코드가 BE에게 요청을 한다.
    즉 BE는 화면을 신경쓰지 않아도 된다. > FE 코드가 요청한 작업에 응답을 해주면 됨

    Client 리소스 : Client, 즉 요청을 보낸 컴퓨터의 자원을 사용.(cpu 렘 등등)

    Restful방식은 화면은 없고 작업만 신경쓰면 된다.
     ( 요청(의 method)은 크게 4가지로 나뉘어짐 )
    - POST 방식 : Create - Insert 작업
    - GET 방식
    - PUT / PATCH 방식
    - DELETE 방식

    post, put 방식은 주로 body에 담아서 보냄
    get, delete 방식은 Query String 이나 Path Variable 을 사용해서 보냄

    1. (post) /board - 글 등록
    2. (get) /board - 리스트 데이터(row(튜플)가 여러개)
    3. (get) /board/ - 끝에 /만 붙었음에도 위의 url과 다른 요청이 됨(2 3번은 다른 url)
    4. (get) /board?page=1 - 뒤에 쿼리스트링이 붙는다고 다른 요청인 것은 아님(1 2 4 전부 같은 url)
    5. (get) /board/n - 한개의 튜플 데이터(row 1줄) 이때 뒤의 n은 PK 값, path variable
    6. (put / patch) /board - 글 수정
    7. (delete) /board - 글 삭제(5번처럼 path variable이나 4번처럼 쿼리스트링으로 pk값 전달)

 */
@RestController
@RequestMapping("/board")
public class BoardController {
    //insert(create)
    @PostMapping // (post) /board 요청이 오면 이 메소드가 응답해주는 것(응답 담당자)

    //@PostMapping("/board") 위의 RequestMapping이 없었더라면 이런 식으로 URL을 따로 작성
    public int insBoard(){
        return 1;
    }
}

-- 게시판 테이블 삭제
drop table x_board;

-- 게시판 테이블 생성
--primary key : 식별자가 된 컬럼은 값을 중복시킬 수 없음
-- auto_increment : 알아서 번호가 자동 증가
create table x_board (
board_id int not null primary key auto_increment,  
title varchar(255) not null,
contents text null,
created_date datetime null default now(),
view_count int null default 0
);

-- 데이터 입력 (순서는 바꿔도 괜찮음)
insert into x_board(title, contents) 
values('제목1', '내용');

insert into x_board(title, contents) 
values('제목2', '내용');

insert into x_board(title, contents) 
values('제목3', '내용');

insert into x_board(title, contents) 
values('제목4', '내용');

insert into x_board(title, contents) 
values('제목5', '내용');

insert into x_board(title, contents) 
values('제목6', '내용');

-- 데이터 조회 
--(x_board에서 데이터를 가져오는데, board_id가 100 이하인 것 중 board_id, title, create_date만 가져오기
--(다 가져오려면 *
select
 board_id,
 title,
 created_date
from 
x_board

select
 board_id,
 title,
 contents,
 created_date,
 view_count
from 
x_board
where 
board_id = 3 and title = '제목3';

-- desc : 역순으로
select
 board_id,
 title,
 created_date
from 
x_board
order by board_id desc;

-- 데이터 변경
update x_board set
view_count = view_count + 1,
created_date = now()
where
board_id = 3;

-- 데이터 삭제
delete from x_board
where
board_id = 3;


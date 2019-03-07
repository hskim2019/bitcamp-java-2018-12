drop table if exists board_test;

create table board_test(
board_test_id int not null primary key auto_increment,
file_path varchar(255) not null,
board_id int not null,
constraint foreign key (board_id) references lms_board(board_id)
);

insert into board_test(board_test_id, file_path, board_id)
values(101, 'a1.gif', 1);
insert into board_test(board_test_id, file_path, board_id)
values(102, 'a2.gif', 1);

insert into board_test(board_test_id, file_path, board_id)
values(103, 'b1.gif', 2);
insert into board_test(board_test_id, file_path, board_id)
values(104, 'b2.gif', 2);


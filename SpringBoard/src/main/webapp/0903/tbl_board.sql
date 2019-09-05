
--board.sql
--bno,title,content,writer,regdate,updatedate
drop table tbl_board;
create table tbl_board
(
	bno number,
	title varchar2(200) not null,
	content varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);

alter table tbl_board
add constraint board_pk primary key(bno);

create sequence tbl_board_seq;

select * from tbl_board;

insert into tbl_board(bno,title,content,writer)
select tbl_board_seq.nextval, title, content, writer from tbl_board;



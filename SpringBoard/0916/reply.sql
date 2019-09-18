--reply.sql

drop table tbl_reply;
drop sequence reply_seq;

--rno, bno, reply, replyer, replyDate, updateDate
create table tbl_reply(
   rno number(10),  -- 댓글 번호
   bno number(10) not null,   -- 게시글 번호
   reply varchar2(1000) not null, -- 댓글 내용
   replyer varchar2(50) not null,  -- 댓글 작성자
   replyDate date default sysdate,  -- 댓글 작성일
   updateDate date default sysdate   -- 댓글 수정일
);

create sequence reply_seq
       start with 1
       increment by 1
       nocycle
       nocache;
       
alter table tbl_reply 
drop constraint reply_pk;

alter table tbl_reply add constraint reply_pk2 primary key (rno);

alter table tbl_reply add constraint reply_bno_fk
      foreign key(bno)  references tbl_board(bno);
      
select * from TBL_REPLY;
select count(*) from TBL_REPLY;
select count(*) from TBL_REPLY where bno=256;






      
      
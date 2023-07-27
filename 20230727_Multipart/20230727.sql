drop table shop_member   cascade constraints; 
drop table  shop_product   cascade constraints; 
drop sequence seq_shop_product;
drop sequence seq_shop_order;

create table shop_member(
id 	 varchar2(20) primary key,
pwd	 varchar2(20),
name	 varchar2(20),
email	 varchar2(50),
addr	 varchar2(50),
type 	 number	
);
select * from shop_member;

create table shop_product(
num		 number primary key,
name		 varchar2(500) not null,
quantity	    number not null,
price		 number not null, 
img		 varchar2(500),
content   	varchar2(500),
s_id varchar2(20) references shop_member(id) on delete  cascade
);

select * from shop_product;

create sequence seq_shop_product;

create table shop_order(
num		 number primary key,
pro_num		 number references shop_product(num) on delete cascade,
order_num	 number,
total_price	 number,
o_id		 varchar2(20) references shop_member(id) on delete cascade,
o_date		 date,
o_state		 number,
d_state		 number
);

create sequence seq_shop_order;




//´ñ±Û ÀÛ¼º db
create table shop_comment(
    comment_num number primary key,
    product_num number references shop_product(num) on delete cascade,
    user_id varchar2(20) references shop_member(id) on delete cascade,
    user_comment varchar2(500) not null
);

INSERT INTO shop_comment (comment_num, product_num, user_id, user_comment)
VALUES (seq_comment.nextval, 7, 'customer', 'test');

select * from shop_comment;
select * from shop_product;
select * from shop_member;

-- ´ñ±Û ÀÛ¼º ½ÃÄö½º »ý¼º
drop sequence seq_comment;
create sequence seq_comment
start with 1
increment by 1
maxvalue 50000
nocycle
nocache;
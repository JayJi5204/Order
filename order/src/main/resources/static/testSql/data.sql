INSERT INTO item_info (item, kind, price)
 VALUES
 ('티셔츠','의류',20000),
 ('후드티','의류',30000),
 ('청바지','의류',30000),
 ('라면','식품',1500),
 ('과자','식품',2000),
 ('음료수','식품',2000),
 ('에어팟','전자기기',300000),
 ('무선충전기','전자기기',100000)
 ;

 INSERT INTO member_info(member_id,name,email,role)
 VALUES
 ('ID1','테스트1','email1@test.com','MEMBER'),
 ('ID2','테스트2','email2@test.com','MEMBER'),
 ('ID3','테스트3','email3@test.com','MEMBER'),
 ('ID4','테스트4','email4@test.com','MEMBER'),
 ('ID5','관리자1','admin1@test.com','ADMIN'),
 ('ID6','관리자2','admin2@test.com','ADMIN')
 ;

 INSERT INTO order_list (item_no,item,price,member_id,name)
 VALUES
 (1,'티셔츠',20000,'ID1','테스트1'),
 (1,'티셔츠',20000,'ID2','테스트2'),
 (3,'청바지',30000,'ID3','테스트3'),
 (3,'청바지',30000,'ID3','테스트3'),
 (5,'과자',2000,'ID4','테스트4'),
 (8,'무선충전기',100000,'ID2','테스트2'),
 (4,'라면',1500,'ID3','테스트3'),
 (2,'후드티',30000,'ID1','테스트1')
 ;

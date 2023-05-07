SELECT * FROM JPA_BOARD;
SELECT * FROM MEMBER;

INSERT INTO JPA_BOARD(board_no,BOARD_CONTENT,BOARD_DATE,BOARD_TITLE,BOARD_WRITER) 
	values(seq_jpaboardno.nextval,'test1',sysdate,'test1','admin');
INSERT INTO JPA_BOARD(board_no,BOARD_CONTENT,BOARD_DATE,BOARD_TITLE,BOARD_WRITER) 
	values(seq_jpaboardno.nextval,'test2',sysdate,'test2','admin');
INSERT INTO JPA_BOARD(board_no,BOARD_CONTENT,BOARD_DATE,BOARD_TITLE,BOARD_WRITER) 
	values(seq_jpaboardno.nextval,'test3',sysdate,'test3','admin');

SELECT * FROM user_constraints JOIN user_cons_columns USING(constraint_name)
WHERE user_constraints.TABLE_NAME ='JPA_BOARD';

SELECT * FROM user_cons_columns WHERE TABLE_NAME ='JPA_BOARD';
ALTER TABLE jpa_board DROP CONSTRAINTS FKFNBS2PGIN69X1EIE9UFQ5P1TS;
ALTER TABLE jpa_board ADD CONSTRAINTS fk_userid FOREIGN KEY(board_writer) REFERENCES MEMBER(userid);
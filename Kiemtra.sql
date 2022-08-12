
--Bài tập
CREATE table NV_HUY_NXB (
    ID number(4) PRIMARY KEY ,
    MA_NXB number(4) unique ,
    NNAME varchar2(60),
    STATUS number(1),
    ADDRESS varchar2(60),
    Mota varchar2(60)
);
drop table NV_HUY_TACGIA;
select * from NV_HUY_NXB;
CREATE TABLE NV_HUY_TACGIA(
    ID number(4) PRIMARY KEY ,
    MA_TACGIA number(4) unique ,
    TNAME varchar2(60),
    PHONE number(10),
    TG_ADD varchar2(60),
    Mota varchar2(60)
);

CREATE TABLE NV_HUY_SACH(
    ID number(4) PRIMARY KEY ,
    MA_SACH number(4) unique ,
    SNAME varchar2(60),
    ID_NXB number(4),
    ID_TACGIA number(4),
    Chude varchar2(20),
    CONSTRAINT  FK_IDNXB FOREIGN KEY (ID_NXB)
    references NV_HUY_NXB(ID),
    CONSTRAINT  FK_IDNTG FOREIGN KEY (ID_TACGIA)
    references NV_HUY_TACGIA(ID),
    NAM_XB DATE,
    Mota varchar2(60),
    SL_CL number(4),
    SL_DM number(4),
    Tong_SACH number(5)
);
drop table NV_HUY_TACGIA;
select * from NV_HUY_SACH;

CREATE TABLE NV_HUY_READER(
    ID number(4) PRIMARY KEY ,
    MA_READER number(4) unique ,
    RNAME varchar2(60),
    RPHONE number(10),
    R_ADD varchar2(60),
    R_BIRTH DATE,
    R_ACC DATE,
    RANK varchar2(10)
)

CREATE TABLE NV_HUY_MUONSACH(
    ID number(4) PRIMARY KEY ,
    ID_R number(4),
    ID_S number(4),
    CONSTRAINT  FK_IDR FOREIGN KEY (ID_R)
    references NV_HUY_READER(ID),
    CONSTRAINT  FK_IDS FOREIGN KEY (ID_S)
    references NV_HUY_SACH(ID),
    SL number(3),
    NGAY_MUON DATE,
    NGAY_TRA DATE,
    STATUS varchar2(20),
    Ghichu varchar2(30))



select * from NV_HUY_MUONSACH;
drop table NV_HUY_NXB;

--B YÊU CẦU
--1

create index NV_HUY_MUONSACH_IDX_IDR
on NV_HUY_MUONSACH(ID_R);

CREATE SEQUENCE NV_HUY_NXB_SEQ
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE NV_HUY_TACGIA_SEQ
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE NV_HUY_SACH_SEQ
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE NV_HUY_READER_SEQ
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE NV_HUY_MUONSACH_SEQ
    START WITH 1
    INCREMENT BY 1;

select * from NV_HUY_TACGIA;
select * from NV_HUY_NXB;
select * from NV_HUY_SACH;
select * from NV_HUY_READER;
select * from NV_HUY_MUONSACH;

select NV_HUY_TACGIA_SEQ.currval from DUAL;
INSERT INTO NV_HUY_NXB values (NV_HUY_NXB_SEQ.currval,'1','NHA XUAT BAN HA NOI','0','HANOI','');
INSERT INTO NV_HUY_NXB values (NV_HUY_NXB_SEQ.nextval,'2','NHA XUAT BAN HOA BINH','0','HOABINH','');
INSERT INTO NV_HUY_NXB values (NV_HUY_NXB_SEQ.nextval,'3','NHA XUAT BAN NAM DINH','0','NAMDINH','');
INSERT INTO NV_HUY_NXB values (NV_HUY_NXB_SEQ.nextval,'4','NHA XUAT BAN DAK LAK','0','DAKLAK','');
INSERT INTO NV_HUY_NXB values (NV_HUY_NXB_SEQ.nextval,'5','NHA XUAT BAN THAI BINH','0','THAIBINH','');


select * from NV_HUY_SACH;


INSERT INTO NV_HUY_SACH values (NV_HUY_SACH_SEQ.currval,'1','DORAEMON','8','5','Truyện tranh','11-12-1992','KO','150','53','203');
INSERT INTO NV_HUY_SACH values (NV_HUY_SACH_SEQ.nextval,'2','Conan','21','2','Truyện tranh','11-12-1992','KO','150','40','190');
INSERT INTO NV_HUY_SACH values (NV_HUY_SACH_SEQ.nextval,'3','Tí Quậy','22','3','Truyện tranh','11-12-1992','KO','300','20','320');
INSERT INTO NV_HUY_SACH values (NV_HUY_SACH_SEQ.nextval,'4','Heo Con','25','3','Truyện tranh','11-12-1992','KO','100','29','129');
INSERT INTO NV_HUY_SACH values (NV_HUY_SACH_SEQ.nextval,'5','Chó con','26','4','Truyện tranh','11-12-1992','KO','45','45','90');






INSERT INTO NV_HUY_TACGIA values (NV_HUY_TACGIA_SEQ.currval,'1','Fujiko Fujio','0987654321','JAPAN','NO');
INSERT INTO NV_HUY_TACGIA values (NV_HUY_TACGIA_SEQ.nextval,'2','Việt Anh','0987654321','VietNam','NO');
INSERT INTO NV_HUY_TACGIA values (NV_HUY_TACGIA_SEQ.nextval,'3','Mạnh','0987654321','VietNam','NO');
INSERT INTO NV_HUY_TACGIA values (NV_HUY_TACGIA_SEQ.nextval,'4','DŨng','0987654321','VietNam','NO');
INSERT INTO NV_HUY_TACGIA values (NV_HUY_TACGIA_SEQ.nextval,'5','Huy','0987654321','VietNam','NO');



INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.currval,'1','Nguyễn Văn Huy','0123456789','NamDinh','22-02-2002','10-08-2022','Đồng');
INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.nextval,'2','Trần Mạnh','0123456789','HANOI','22-05-2002','06-08-2022','Đồng');
INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.nextval,'3','Cao Quý','0123456789','Hòa Binh','12-12-2002','07-08-2022','Đồng');
INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.nextval,'4','Nguyễn Văn Bình','0123456789','Thái Bình','19-05-2002','08-08-2022','Đồng');
INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.nextval,'5','Nguyễn Văn Quân','0123456789','HANOI','21-03-2002','09-08-2022','Đồng');
INSERT INTO NV_HUY_READER values (NV_HUY_READER_SEQ.nextval,'6','Nguyễn Văn Quân1','0123456789','HANOI','21-03-2020','09-08-2022','Đồng');

INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.currval,'1','25','2','11-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'2','24','4','11-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'3','23','12','11-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'4','22','6','11-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'5','21','21','11-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'2','21','21','01-08-2022','18-08-2022','Đang mượn','');
INSERT INTO NV_HUY_MUONSACH values (NV_HUY_MUONSACH_SEQ.nextval,'5','21','21','01-08-2021','18-08-2022','Đang mượn','');
select * from NV_HUY_READER;
select * from NV_HUY_MUONSACH;

--5
select T.MA_TACGIA,T.TNAME, S.Chude, S.Tong_SACH from NV_HUY_TACGIA T, NV_HUY_SACH S
order by S.Tong_SACH DESC

--6
select S.MA_SACH as MASACH,S.SNAME as TEN_SACH,N.NNAME as TEN_NXB,T.TNAME as TEN_TACGIA, S.Chude,
                S.NAM_XB, S.SL_CL,S.SL_DM, S.Tong_SACH from  NV_HUY_SACH S, NV_HUY_TACGIA T,NV_HUY_NXB N
where S.ID_NXB = N.ID and S.ID_TACGIA= T.ID and ROWNUM <10
order by S.Tong_SACH DESC

--7
select * from NV_HUY_SACH;
select  R.MA_READER,R.RNAME,S.MA_SACH,S.SNAME,
       M.NGAY_MUON,M.SL
       from NV_HUY_MUONSACH M join  NV_HUY_READER R on M.ID_R = R.ID join NV_HUY_SACH S on M.ID_S =S.ID
where M.NGAY_MUON = (select add_months(trunc(SYSDATE,'month'),-0) from DUAL) and M.NGAY_TRA > (select SYSDATE from DUAL)
order by  M.NGAY_MUON DESC , R.RNAME

--8
select * from NV_HUY_SACH;
select * from NV_HUY_MUONSACH;
select to_char(SYSDATE,'MM-YYYY') from DUAL;
select  S.MA_SACH,S.SNAME,S.SL_DM, M.ID from  NV_HUY_SACH S,NV_HUY_MUONSACH M
where M.ID_S = S.ID and M.NGAY_MUON > '01-01-2022' and TO_CHAR(M.NGAY_MUON,'DD-MM-YYYY') <(select to_char(SYSDATE,'DD-MM-YYYY') from DUAL)
and ROWNUM<10

--9
select * from NV_HUY_MUONSACH;
select * from NV_HUY_READER;
select R.MA_READER,R.RNAME ,count(M.ID_R) as SL_Muon  from NV_HUY_READER R, NV_HUY_MUONSACH M
where R.ID = M.ID_R
group by  R.RNAME,R.MA_READER
having count(M.ID_R) >1

--10
select MA_READER, RNAME,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(R_BIRTH,'YYYY') as Tuổi from NV_HUY_READER

--11
select (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(R_BIRTH,'YYYY')) as Tuổi , count(ID) as Tong_so_ban_doc  from NV_HUY_READER
group by (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(R_BIRTH,'YYYY'))

--12
select * from NV_HUY_NXB;
select * from NV_HUY_SACH;
select  S.NAM_XB,N.MA_NXB,N.NNAME as TEN_NXB, S.Tong_SACH as SL_SACH
        from NV_HUY_NXB N , NV_HUY_SACH S
where S.ID_NXB =N.ID order by S.NAM_XB DESC, N.NNAME

--13

select NHR.RNAME,S.MA_SACH,S.SNAME, S.SL_DM from NV_HUY_MUONSACH M join NV_HUY_SACH S on M.ID_S = S.ID
join NV_HUY_READER NHR on M.ID_R = NHR.ID where M.NGAY_MUON > '01-01-2022' and TO_CHAR(M.NGAY_MUON,'DD-MM-YYYY') <(select to_char(SYSDATE,'DD-MM-YYYY') from DUAL)
and (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(NHR.R_BIRTH,'YYYY')) between 18 and 25

--14
select R.MA_READER,R.RNAME,S.SNAME from NV_HUY_READER R JOIN NV_HUY_MUONSACH M on R.ID = M.ID_R
 RIGHT JOIN NV_HUY_SACH S On M.ID_S = S.ID

create table Team (
      id bigint not null primary key auto_increment,
      name varchar(30)
);

create table Member (
    id bigint not null primary key auto_increment,
    team_id bigint,
    name varchar(30),
    age int not null,
    foreign key (team_id) references Team (id)
);

insert into Team (name) values ( '영업팀' );
insert into Team (name) values ( '운영팀' );
insert into Team (name) values ( '개발팀' );

insert into Member (team_id, name, age) values ( 1, '조재원', 50 );
insert into Member (team_id, name, age) values ( 1, '이경원', 45 );
insert into Member (team_id, name, age) values ( 2, '조영찬', 41 );
insert into Member (team_id, name, age) values ( 2, '양희정', 37 );
insert into Member (team_id, name, age) values ( 2, '유민규', 31 );
insert into Member (team_id, name, age) values ( 3, '전영민', 28 );
insert into Member (team_id, name, age) values ( 3, '하재형', 26 );
insert into Member (team_id, name, age) values ( 3, '최승우', 27 );

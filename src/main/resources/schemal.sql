create table Status
(
    statusId int(5) AUTO_INCREMENT PRIMARY KEY,
    statusName varchar(30) NOT NULL
) ;

create table type
    (
        typeId int(5) AUTO_INCREMENT PRIMARY KEY,
        name varchar(30) NOT NULL

);

create table project
(
    projectId int(5) AUTO_INCREMENT PRIMARY KEY,
    name varchar(60) NOT NULL,
    shortName varchar(12) NOT NULL unique ,
    description varchar(250) NOT NULL,
    statusId int(5) not null,
    FOREIGN KEY(statusId) references status (statusId)
);

create table item
(
    itemId int(5) AUTO_INCREMENT primary key,
    title varchar(60) Not null,
    description varchar(250) not null,
    statusId int(5) not null,
    foreign key (statusId) references status(statusId),
    typeId int(5) UNSIGNED,
    foreign key (typeId) references type(typeId)
);

create table comment
(
    commentId int(5) auto_increment primary key,
    text      varchar(3000),
    itemId    int(5) not null,
    foreign key item (itemId) references item (itemId)
);

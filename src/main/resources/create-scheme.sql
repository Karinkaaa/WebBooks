create table Books
(
    id   int         not null auto_increment primary key,
    name varchar(30) not null
);

create table Authors
(
    id      int         not null auto_increment primary key,
    name    varchar(10) not null,
    surname varchar(15) not null
);

create table Books_Authors
(
    bookId   int not null,
    authorId int not null,
    unique (bookId, authorId),
    foreign key (bookId) references Books (id) ON DELETE CASCADE,
    foreign key (authorId) references Authors (id) ON DELETE CASCADE
);
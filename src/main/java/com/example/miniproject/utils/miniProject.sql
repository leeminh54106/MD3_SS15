create database mini_project;

use mini_project;

create table category
(
    id int auto_increment primary key ,
    name varchar(255) not null,
    status bit
);

create table book (
                      id int auto_increment primary key ,
                      categoryId int ,
                      foreign key (categoryId) references category (id),
                      name varchar(255),
                      price double ,
                      stock int ,
                      totalPages int,
                      yearCreated int,
                      author varchar(255),
                      status bit,
                      image varchar(255)
);

delimiter $$
create procedure get_all_books()
begin
    select b.*,c.name from book b inner join category c on b.categoryId = c.id;
end $$;


delimiter $$
create procedure insert_book(
    categoryId_in int,
    name_in varchar(255),
    price_in double,
    stock_in int,
    totalPages_in int,
    yearCreated_in int,
    author_in varchar(255),
    status_in bit,
    image_in varchar(255)

)
begin
    insert into book(categoryId, name, price, stock, totalPages, yearCreated, author, status, image)
        value (categoryId_in, name_in, price_in, stock_in, totalPages_in, yearCreated_in, author_in, status_in, image_in);
end $$;


delimiter $$
create procedure update_book(
    id_in int,
    categoryId_in int,
    name_in varchar(255),
    price_in double,
    stock_in int,
    totalPages_in int,
    yearCreated_in int,
    author_in varchar(255),
    status_in bit,
    image_in varchar(255)
)
begin
    update book set categoryId = categoryId_in, name = name_in, price = price_in, stock = stock_in,
                    totalPages = totalPages_in, yearCreated = yearCreated_in,
                    author = author_in, status = status_in, image = image_in where id = id_in;
end $$;

delimiter $$
create procedure delete_book(id_in int)
begin
    delete from book where id = id_in;
end $$;

delimiter $$
create procedure get_book_by_id(id_in int)
begin
    select b.*,c.name from book b inner join category c on b.categoryId = c.id where id = id_in;
end $$;

DELIMITER $$
CREATE PROCEDURE get_book_by_name(IN name_in VARCHAR(50))
BEGIN
    IF name_in = '' THEN
        SELECT b.*, c.name
        FROM book b
                 INNER JOIN category c ON b.categoryId = c.id;
    ELSE
        SELECT b.*, c.name
        FROM book b
                 INNER JOIN category c ON b.categoryId = c.id
        WHERE b.name LIKE CONCAT('%', name_in, '%');
    END IF;
END$$
DELIMITER ;
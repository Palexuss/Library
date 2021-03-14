INSERT INTO Book (Title, Year, Publishing)
VALUES
    ('1984', 1949, 'Secker and Warburg'),
    ('Witcher', 1986, 'superNOWA'),
    ('The Lord of the Rings', 1954, 'George Allen & Unwin'),
    ('Harry Potter', 1997, 'Bloomsbury'),
    ('Thinking in Java', 1998, 'Prentice Hall'),
    ('Unnamed book', 2021, 'None');



INSERT INTO Author (Name, Surname, Day, Month, Year, Gender)
VALUES
       ('john', 'Eckel',8,7,1957,'Male'),
       ('Andrzej', 'Sapkowski',21,6,1948,'Male'),
       ('Joanne', 'Rowling',31,7,1965,'Female'),
       ('John', 'Tolkien',3,1,1892,'Male'),
       ('George', 'Orwell',25,6,1903,'Male'),
       ('Noname', 'Nosurname',1,1,2021,'Undefined');

INSERT INTO Book_Author (BookId, AuthorId)
VALUES
(1,5),
       (2,2),
       (3,4),
       (4,3),
       (5,1),
       (6,6);


DROP DATABASE IF EXISTS test;
CREATE DATABASE test CHARACTER SET utf8 COLLATE utf8_general_ci;

USE test;

DROP TABLE IF EXISTS book;
CREATE TABLE book
(
  id INT AUTO_INCREMENT
    PRIMARY KEY ,
  title VARCHAR(100) NULL,
  description VARCHAR(255) NULL,
  autor VARCHAR(100) NULL,
  isbn VARCHAR(20) NULL,
  print_year INT NULL,
  read_already TINYINT NULL,
  CONSTRAINT id_UNIQUE
  UNIQUE (id)
)
  ENGINE = innoDB
  DEFAULT CHARACTER SET = utf8
;

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Spring 4 для профессионалов',
   'Руководство по Spring Framework 4, соответствующее отраслевым стандартам',
   'Крис Шеффер, Кларенс Хо, Роб Харроп',
   '978-5-8459-1992-2',
   2017, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Thinking in Java',
   'Book about the Java programming language',
   'Bruce Eckel',
   '978-0131872486',
2006, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('JavaFX 9 by Example',
   'Rich-client applications for any platform',
   'Carl Dea, Gerrit Grunwald, José Pereda, Ph.D Sean Phillips, Mark Heckler',
   '978-1-4842-1960-7',
2017, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Libgdx Cross-platform Game Development Cookbook',
   'Over 75 practical recipes to help you master cross-platform 2D game development',
   'David Saltares Marques, Alberto Cejas Sanchez',
   '978-1-78328-729-1',
2014, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('LibGDX Game Development Essentials',
   'Make the most of game development features powered by LibGDX',
   'Juwal Bose',
   '978-1-78439-929-0',
2014, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Learning LibGDX Game Development',
   'Wield the power of the LibGDX framework to create a cross-platform game',
   'Suryakumar Balakrishnan Nair, Andreas Oehlke',
   '978-1-78355-477-5',
2013, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('OpenGL Game Development',
   'Library of Congress Cataloging-in-Publication Data',
   'Chris Seddon',
   '1-55622-989-5',
2005, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Совершенный код',
   'Мастер-класс',
   'Макконнелл С.',
   '978-5-7502-0064-1',
2010, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Head First. Программирование для Android',
   'Система Android покорила мир',
   'Гриффитс Дон, Гриффитс Дэвид',
   '978-5-496-02171-5',
2016, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Регулярные выражения',
   'Книга откроет перед вами секрет высокой  производительности.',
   'Джеффри Фридл',
   '978-5-93286-121-9',
2010, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Android для разработчиков',
   'Третье издание было полностью обновлено и познакомит вас с возможностями Android 6 и Android Studio',
   'Дейтел П., Дейтел Х., Уолд А.',
   '978-5-496-02371-9',
2016, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Основы веб-хакинга: нападение и защита',
   'Книга для всех интересующихся хакингом веб-сайтов',
   'Жуков Ю. В.',
   '978-5-4237-0184-0',
2011, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Изучаем Java',
   'Книга не только научит вас теории языка Java и объектно-ориентированного программирования, она сделает вас программистом',
   'Сьерра К., Бэйтс Б.',
   '5699545743',
2012, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Java. Объектно-ориентированное программирование',
   'Учебное пособие предназначено для изучающих объектно-ориентированное программирование в вузе.',
   'Васильев А. Н.',
   '978-5-49807-948-6',
2011, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Beginning Java Game Development with LibGDX',
   'Create a great variety of games quickly and efficiently with LibGDX',
   'Lee Stemkoski',
   '978-1-4842-1501-2',
2015, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Java. Библиотека профессионала, том 1',
   'Настоящее издание по-прежнему адресуется серьезным программистам',
   'Хорстманн, Кей С.',
   '978-5-8459-2084-3',
2016, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Meнтaлист. Haстoльнaя книгa paзвития свepxспoсoбнoстей сoзиaния',
   'Дopдж Kpeскин - пpизнaнный мeнтaлиcт N 1 нaшeгo вpeмeни.',
   'Kpeскин',
   '978-69945346-7',
2011, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Первый удар Сталина 1941',
   'Альтернативы Великой Отечественной',
   'Алексей Исаев, Виктор Суворов, Михаил Барятинский',
   '978-5-699-43818-1',
2010, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Изучаем С#. 2-е изд',
   'Второе издание книги включает последние версии C# .NET 4.0 и Visual Studio 2010',
   'Стиллмен Э., ГринДж.',
   '978-5-459-00422-9',
2012, TRUE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Spring в действии',
   'В книге описана последняя версия Spring 3',
   'Уоллс К.',
   '978-5-94074-568-6',
2013, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Spring in Action',
   'Fourth Edition is for all Java developers',
   'Craig Walls',
   '9781617291203',
2015, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Spring 4 для профессионалов',
   'Наиболее исчерпывающее справочное и учебное руководство по Spring',
   'Шефер, Крис, Хо, Кларенс, Харроп, Роб',
   '978-5-8459-1992-2',
2015, FALSE );

INSERT INTO book (title, description, autor, isbn, print_year, read_already) VALUES
  ('Spring Persistence with Hibernate',
   'ARCHITECTING YOUR APPLICATION WITH SPRING, HIBERNATE, AND PATTERNS',
   'Paul Tepper Fisher, Brian D. Murphy',
   '978-1-4302-2632-1',
2010, FALSE );
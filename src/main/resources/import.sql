insert into genero (id, descripcion) values('1', 'Terror');
insert into genero (id, descripcion) values('2', 'Aventura');
insert into genero (id, descripcion) values('3', 'Accion');
insert into genero (id, descripcion) values('4', 'Ciencia ficcion');
insert into genero (id, descripcion) values('5', 'Comedia');
insert into genero (id, descripcion) values('6', 'Fantasia');
insert into genero (id, descripcion) values('7', 'Suspenso');
insert into genero (id, descripcion) values('8', 'Deporte');
insert into genero (id, descripcion) values('9', 'Drama');

insert into plataforma (id, descripcion) values('1', 'Steam');
insert into plataforma (id, descripcion) values('2', 'Playstation');
insert into plataforma (id, descripcion) values('3', 'Netflix');
insert into plataforma (id, descripcion) values('4', 'Nintendo');
insert into plataforma (id, descripcion) values('5', 'HBO Max');
insert into plataforma (id, descripcion) values('6', 'Xbox');
insert into plataforma (id, descripcion) values('7', 'Disney +');
insert into plataforma (id, descripcion) values('8', 'Amazon');

insert into plan (id, descripcion, precio) values ('1', 'Free', '0')
insert into plan (id, descripcion, precio) values ('2', 'Basico', '500')
insert into plan (id, descripcion, precio) values ('3', 'Premium', '700')

insert into usuario (id, email, password, nombre, biografia, foto) values('1', 'free@gmail.com', '123', 'free', 'hola soy un usuario free', 'perfil.jpg')
insert into usuario (id, email, password, nombre, biografia, foto) values('2', 'basico@gmail.com', '123', 'basico', 'hola soy un usuario basico', 'perfil2.jpg')
insert into usuario (id, email, password, nombre, biografia, foto) values('3', 'premium@gmail.com', '123', 'premium', 'hola soy un usuario premium', 'perfil3.jpg')
insert into usuario (id, email, password, nombre, biografia, foto) values('4', 'premium2@gmail.com', '123', 'premium 2', 'hola soy un usuario premium 2', 'perfil4.jpg')
insert into usuario (id, email, password, nombre, biografia, foto) values('5', 'premium3@gmail.com', '123', 'premium 3', 'hola soy un usuario premium 3', 'perfil5.jpg')

insert into historial(id, usuario_id) values ('1','1');
insert into historial(id, usuario_id) values ('2','2');
insert into historial(id, usuario_id) values ('3','3');
insert into historial(id, usuario_id) values ('4','4');
insert into historial(id, usuario_id) values ('5','5');

insert into usuarioplan(id, plan_id, usuario_id ,fechaVencimiento) values ('1', '1', '1', '2022-01-01')
insert into usuarioplan(id, plan_id, usuario_id ,fechaVencimiento) values ('2', '2', '2', '2022-11-15')
insert into usuarioplan(id, plan_id, usuario_id ,fechaVencimiento) values ('3', '3', '3', '2022-12-05')
insert into usuarioplan(id, plan_id, usuario_id ,fechaVencimiento) values ('4', '3', '4', '2022-11-15')
insert into usuarioplan(id, plan_id, usuario_id ,fechaVencimiento) values ('5', '3', '5', '2022-10-15')

update usuario set historial_id = 1 where id = 1
update usuario set historial_id = 2 where id = 2
update usuario set historial_id = 3 where id = 3
update usuario set historial_id = 4 where id = 4
update usuario set historial_id = 5 where id = 5

update usuario set planAdquirido_id = 1 where id = 1
update usuario set planAdquirido_id = 2 where id = 2
update usuario set planAdquirido_id = 3 where id = 3
update usuario set planAdquirido_id = 4 where id = 4
update usuario set planAdquirido_id = 5 where id = 5

insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno, calificacion) values ('zeldabotw.jpg', 'The Legend Of Zelda', 'Nintendo', '55', '1','Olvida todo lo que sabes acerca de los juegos de la serie The Legend of Zelda. Explora y descubre un mundo lleno de aventuras en The Legend of Zelda: Breath of the Wild, una nueva saga que rompe los esquemas de la aclamada serie. Viaja a través de praderas y bosques, y alcanza cimas de montañas mientras descubres cómo cayó en la ruina el reino de Hyrule en esta emocionante aventura al aire libre.','2020-03-25', '0.0')
insert into videojuego_genero(videojuego_id, genero_id) values ('1','2')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('1','2')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno, calificacion) values ('godofwar.jpg', 'God Of War', 'Santa Monica', '2','1','Con su ejército destruido y a punto de ser asesinado por el líder bárbaro, Kratos pide la ayuda de Ares, el dios de la guerra, ofreciéndole su vida a cambio. El dios desciende de los cielos y acaba con todos los enemigos, luego entrega a Kratos las Espadas de Caos que son adheridas a sus brazos por cadenas.', '2019-03-25', '0.0')
insert into videojuego_genero(videojuego_id, genero_id) values ('2','3')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('2','1')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno, calificacion) values ('revillage.jpg', 'Resident Evil Village', 'Capcom', '3','1','Ethan llega a una aldea cercana que está siendo atacada por criaturas mutantes parecidas a hombres lobo, conocidas como licántropos. Al escapar de una masacre, Ethan es capturado por la deidad del pueblo, la Madre Miranda, y sus cuatro jerarcas: Alcina Dimitrescu, Donna Beneviento, Salvatore Moreau y Karl Heisenberg.', '2018-03-25', '0.0')
insert into videojuego_genero(videojuego_id, genero_id) values ('3','1')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('3','4')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno, calificacion) values ('cyberpunk.jpg', 'Cyberpunk 2077','CDProjectRed', '4','2','Cyberpunk 2077 es una historia de acción y aventura en mundo abierto ambientada en Night City, una megalópolis obsesionada con el poder, el glamur y la modificación corporal. Tu personaje es V, un mercenario que persigue un implante único que permite alcanzar la inmortalidad.', '2022-07-25', '0.0')
insert into videojuego_genero(videojuego_id, genero_id) values ('4','2')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('4','2')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno, calificacion) values ('videojuego5.jpg', 'Dishonored','Arkane Studios', '25','1','Dishonored es un videojuego de acción-aventura y sigilo en primera persona desarrollado por Arkane Studios y publicado por Bethesda Softworks. Fue lanzado a nivel mundial entre el 9 y el 12 de octubre de 2012 para Microsoft Windows, PlayStation 3, y Xbox 360.​', '2012-10-09', '0.0')
insert into videojuego_genero(videojuego_id, genero_id) values ('5','3')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('5','1')

insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno, calificacion) values ('pelicula1.jpg', 'Mary Harron', 'American Psycho', '120','En la década de 1980, Patrick Bateman es un hombre exitoso y obsesionado por la competencia y por la perfección material, quien utiliza los más caros cosméticos masculinos, equipos de gimnasia, solárium y demás maquinaria estética para lograr un cuerpo atlético y bien acicalado, identificador material del éxito social.', '2000-07-24','0.0')
insert into pelicula_genero(pelicula_id, genero_id) values ('1','1')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('1','3')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno, calificacion) values ('pelicula2.jpg', 'Dan Gilroy', 'Nightcrawler', '140','Louis Bloom es un joven de Los Angeles, sin empleo ni escrúpulos, quien, después de haber sido testigo de un accidente espeluznante, decide que quiere ganar fama y fortuna a través del periodismo sensacionalista.', '2014-10-31','0.0')
insert into pelicula_genero(pelicula_id, genero_id) values ('2','7')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('2','5')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno, calificacion) values ('pelicula5.jpg', 'Nicolas Winding Refn', 'Drive', '120','Un doble de cine de Hollywood que trabaja como conductor para criminales empieza a recibir amenazas de muerte después de un robo fallido.', '2011-03-01','0.0')
insert into pelicula_genero(pelicula_id, genero_id) values ('3','7')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('3','8')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno, calificacion) values ('pelicula4.jpg',  'David Fincher', 'Fight Club', '60', 'Un empleado de oficina insomne, harto de su vida, se cruza con un vendedor peculiar. Ambos crean un club de lucha clandestino como forma de terapia y, poco a poco, la organización crece y sus objetivos toman otro rumbo.', '1999-10-04', '0.0')
insert into pelicula_genero(pelicula_id, genero_id) values ('4','5')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('4','7')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno, calificacion) values ('pelicula3.jpg', 'Peter Jackson', 'Lord of the Rings', '100','En la Tierra Media, el Señor Oscuro Sauron forjó los Grandes Anillos del Poder y creó uno con el poder de esclavizar a toda la Tierra Media. Frodo Bolsón es un hobbit al que su tío Bilbo hace portador del poderoso Anillo Único con la misión de destruirlo. Acompañado de sus amigos, Frodo emprende un viaje hacia Mordor, el único lugar donde el anillo puede ser destruido. Sin embargo, Sauron ordena la persecución del grupo para recuperar el anillo y acabar con la Tierra Media.', '2002-01-31','0.0')
insert into pelicula_genero(pelicula_id, genero_id) values ('5','2')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('5','8')


insert into serie (poster, nombre, duracion, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno, calificacion) values ('friends.jpg', 'Friends', '86', '10','236', '22','Tres hombres y tres mujeres jóvenes son mejores amigos y viven en el mismo conjunto de apartamentos. Ellos enfrentan la vida y el amor en la ciudad de Nueva York y se involucran en los asuntos personales de los demás, donde incluso a veces intercambian novios o novias, lo que algunas veces genera situaciones que las personas comunes quizás nunca experimentan, especialmente durante las rupturas.', '1994-09-22', '0.0')
insert into serie_genero(serie_id, genero_id) values ('1','5')
insert into serie_plataforma(serie_id, plataforma_id) values ('1','3')
insert into serie (poster, nombre, duracion, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno, calificacion) values ('TheWire.jpg', 'The Wire', '55', '5','60', '55','The Wire trata de ser una visión realista de la vida de Baltimore, centrándose especialmente en el tráfico de drogas. Muchos de sus personajes se basan en personas reales de Baltimore y varios actores secundarios son aficionados que interpretan sus propios personajes.', '2002-06-02', '0.0')
insert into serie_genero(serie_id, genero_id) values ('2','9')
insert into serie_plataforma(serie_id, plataforma_id) values ('2','5')
insert into serie (poster, nombre, duracion, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno, calificacion) values ('chernobyl.jpg', 'Chernobyl', '5', '1','5', '60','Con millones de personas en peligro después de la explosión de Chernobyl, la físico nuclear Ulana Khomyuk hace un intento desesperado de llegar a Valery Legasov, un destacado físico nuclear soviético, y le advierte sobre la amenaza de una segunda explosión que podría devastar el continente.', '2019-05-06', '0.0' )
insert into serie_genero(serie_id, genero_id) values ('3','9')
insert into serie_plataforma(serie_id, plataforma_id) values ('3','5')
insert into serie (poster, nombre, duracion, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno, calificacion) values ('strangerThings.jpg', 'Stranger Things', '28', '4','34', '50','La historia se sitúa en el pueblo ficticio de Hawkins, en el estado Indiana, Estados Unidos, durante los años ochenta, cuando un niño de doce años llamado Will Byers desaparece misteriosamente. Poco después, Eleven (Once, en español), una niña aparentemente fugitiva y con poderes telequinéticos, se encuentra con Mike, Dustin y Lucas, amigos de Will, y los ayuda en la búsqueda del mismo.', '2016-07-15', '0.0')
insert into serie_genero(serie_id, genero_id) values ('4','9')
insert into serie_plataforma(serie_id, plataforma_id) values ('4','7')
insert into serie (poster, nombre, duracion, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno, calificacion) values ('serie5.jpg', 'Breaking Bad', '51', '5', '62', '50','El profesor calmado de química de una secundaria, Walter White cree que su vida no puede ser peor. Su salario apenas le alcanza para sostener a su familia, una situación que no mejora cuando su esposa da a luz y su hijo adolescente sufre de parálisis cerebral, pero Walter queda anonadado cuando se entera que tiene un cáncer terminal.', '2013-09-29', '0.0')
insert into serie_genero(serie_id, genero_id) values ('5','9')
insert into serie_plataforma(serie_id, plataforma_id) values ('5','7')

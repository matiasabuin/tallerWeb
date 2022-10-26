insert into genero (id, descripcion) values('1', 'Terror');
insert into genero (id, descripcion) values('2', 'Aventura');
insert into genero (id, descripcion) values('3', 'Accion');
insert into genero (id, descripcion) values('4', 'Ciencia ficcion');
insert into genero (id, descripcion) values('5', 'Comedia');
insert into genero (id, descripcion) values('6', 'Fantasia');
insert into genero (id, descripcion) values('7', 'Suspenso');
insert into genero (id, descripcion) values('8', 'Deporte');

insert into plataforma (id, descripcion) values('1', 'Steam');
insert into plataforma (id, descripcion) values('2', 'Playstation');
insert into plataforma (id, descripcion) values('3', 'Netflix');
insert into plataforma (id, descripcion) values('4', 'Nintendo');
insert into plataforma (id, descripcion) values('5', 'HBO Max');
insert into plataforma (id, descripcion) values('6', 'Xbox');
insert into plataforma (id, descripcion) values('7', 'Disney +');
insert into plataforma (id, descripcion) values('8', 'Amazon');

insert into plan (id, descripcion) values ('1', 'Free')
insert into plan (id, descripcion) values ('2', 'Basico')
insert into plan (id, descripcion) values ('3', 'Premium')

insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno) values ('zeldabotw.jpg', 'The Legend Of Zelda', 'Nintendo', '55', '1','Olvida todo lo que sabes acerca de los juegos de la serie The Legend of Zelda. Explora y descubre un mundo lleno de aventuras en The Legend of Zelda: Breath of the Wild, una nueva saga que rompe los esquemas de la aclamada serie. Viaja a través de praderas y bosques, y alcanza cimas de montañas mientras descubres cómo cayó en la ruina el reino de Hyrule en esta emocionante aventura al aire libre.','2020-03-25')
insert into videojuego_genero(videojuego_id, genero_id) values ('1','2')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('1','2')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno) values ('godofwar.jpg', 'God Of War', 'Santa Monica', '2','1','Con su ejército destruido y a punto de ser asesinado por el líder bárbaro, Kratos pide la ayuda de Ares, el dios de la guerra, ofreciéndole su vida a cambio. El dios desciende de los cielos y acaba con todos los enemigos, luego entrega a Kratos las Espadas de Caos que son adheridas a sus brazos por cadenas.', '2019-03-25')
insert into videojuego_genero(videojuego_id, genero_id) values ('2','3')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('2','1')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno) values ('revillage.jpg', 'Resident Evil Village', 'Capcom', '3','1','Ethan llega a una aldea cercana que está siendo atacada por criaturas mutantes parecidas a hombres lobo, conocidas como licántropos. Al escapar de una masacre, Ethan es capturado por la deidad del pueblo, la Madre Miranda, y sus cuatro jerarcas: Alcina Dimitrescu, Donna Beneviento, Salvatore Moreau y Karl Heisenberg.', '2018-03-25')
insert into videojuego_genero(videojuego_id, genero_id) values ('3','1')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('3','4')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis, fechaEstreno) values ('cyberpunk.jpg', 'Cyberpunk 2077','CDProjectRed', '4','2','Cyberpunk 2077 es una historia de acción y aventura en mundo abierto ambientada en Night City, una megalópolis obsesionada con el poder, el glamur y la modificación corporal. Tu personaje es V, un mercenario que persigue un implante único que permite alcanzar la inmortalidad.', '2022-07-25')
insert into videojuego_genero(videojuego_id, genero_id) values ('4','2')
insert into videojuego_plataforma(videojuego_id, plataforma_id) values ('4','2')

insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno) values ('pelicula1.jpg', 'Mary Harron', 'American Psycho', '120','En la década de 1980, Patrick Bateman es un hombre exitoso y obsesionado por la competencia y por la perfección material, quien utiliza los más caros cosméticos masculinos, equipos de gimnasia, solárium y demás maquinaria estética para lograr un cuerpo atlético y bien acicalado, identificador material del éxito social.', '2000-07-24')
insert into pelicula_genero(pelicula_id, genero_id) values ('1','1')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('1','3')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno) values ('pelicula2.jpg', 'Dan Gilroy', 'Nightcrawler', '140','Louis Bloom es un joven de Los Angeles, sin empleo ni escrúpulos, quien, después de haber sido testigo de un accidente espeluznante, decide que quiere ganar fama y fortuna a través del periodismo sensacionalista.', '2014-10-31')
insert into pelicula_genero(pelicula_id, genero_id) values ('2','7')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('2','5')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno) values ('pelicula3.jpg', 'Peter Jackson', 'Lord of the Rings', '100','En la Tierra Media, el Señor Oscuro Sauron forjó los Grandes Anillos del Poder y creó uno con el poder de esclavizar a toda la Tierra Media. Frodo Bolsón es un hobbit al que su tío Bilbo hace portador del poderoso Anillo Único con la misión de destruirlo. Acompañado de sus amigos, Frodo emprende un viaje hacia Mordor, el único lugar donde el anillo puede ser destruido. Sin embargo, Sauron ordena la persecución del grupo para recuperar el anillo y acabar con la Tierra Media.', '2002-01-31')
insert into pelicula_genero(pelicula_id, genero_id) values ('3','2')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('3','8')
insert into pelicula (poster, director, nombre, duracion, sinopsis, fechaEstreno) values ('pelicula4.jpg',  'David Fincher', 'Fight Club', '60', 'Un empleado de oficina insomne, harto de su vida, se cruza con un vendedor peculiar. Ambos crean un club de lucha clandestino como forma de terapia y, poco a poco, la organización crece y sus objetivos toman otro rumbo.', '1999-10-04')
insert into pelicula_genero(pelicula_id, genero_id) values ('4','5')
insert into pelicula_plataforma(pelicula_id, plataforma_id) values ('4','7')

insert into serie (poster, nombre, cantDeTemps, cantDeCaps, duracionPorCaps, sinopsis, fechaEstreno  ) values ('friends.jpg', 'Friends', '10','236', '22','Tres hombres y tres mujeres jóvenes son mejores amigos y viven en el mismo conjunto de apartamentos. Ellos enfrentan la vida y el amor en la ciudad de Nueva York y se involucran en los asuntos personales de los demás, donde incluso a veces intercambian novios o novias, lo que algunas veces genera situaciones que las personas comunes quizás nunca experimentan, especialmente durante las rupturas.', '1994-09-22' )
insert into serie_genero(serie_id, genero_id) values ('1','5')
insert into serie_plataforma(serie_id, plataforma_id) values ('1','3')
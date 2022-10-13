insert into genero (id, descripcion) values('1', 'Terror');
insert into genero (id, descripcion) values('2', 'Aventura');
insert into genero (id, descripcion) values('3', 'Accion');

insert into plataforma (id, descripcion) values('1', 'Steam');
insert into plataforma (id, descripcion) values('2', 'Playstation');
insert into plataforma (id, descripcion) values('3', 'Nintendo');
insert into plataforma (id, descripcion) values('4', 'Xbox');
insert into plataforma (id, descripcion) values('5', 'Windows');
insert into plataforma (id, descripcion) values('6', 'Mac OS');

insert into usuario (email, password, nombre, foto, biografia, plan) values ('admin@gmail.com','123','admin','perfil.jpg', 'soy admin','Premium');

insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis) values ('zeldabotw.jpg', 'The Legend Of Zelda', 'Nintendo', '55', '1','In this 3D open-world entry in the Zelda series, Link is awakened from a deep slumber without his past memories in the post-apocalyptic Kingdom of Hyrule, and sets off on a journey to defeat the ancient evil Calamity Ganon. Link treks, climbs and glides through fields, forests and mountain ranges while meeting and helping friendly folk and defeating enemies in order to gather up the strength to face Ganon.')
insert into videojuego_genero(videojuego_id, genero_id) values ('1','2')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis) values ('godofwar.jpg', 'God Of War', 'Santa Monica', '2','1','Con su ejército destruido y a punto de ser asesinado por el líder bárbaro, Kratos pide la ayuda de Ares, el dios de la guerra, ofreciéndole su vida a cambio. El dios desciende de los cielos y acaba con todos los enemigos, luego entrega a Kratos las Espadas de Caos que son adheridas a sus brazos por cadenas.')
insert into videojuego_genero(videojuego_id, genero_id) values ('2','3')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis) values ('revillage.jpg', 'Resident Evil Village', 'Capcom', '3','1','Ethan llega a una aldea cercana que está siendo atacada por criaturas mutantes parecidas a hombres lobo, conocidas como licántropos. Al escapar de una masacre, Ethan es capturado por la deidad del pueblo, la Madre Miranda, y sus cuatro jerarcas: Alcina Dimitrescu, Donna Beneviento, Salvatore Moreau y Karl Heisenberg.')
insert into videojuego_genero(videojuego_id, genero_id) values ('3','1')
insert into videojuego (poster, nombre, desarrollador, duracion, cantidadJugadores, sinopsis) values ('cyberpunk.jpg', 'Cyberpunk 2077','CDProjectRed', '4','2','Cyberpunk 2077 es una historia de acción y aventura en mundo abierto ambientada en Night City, una megalópolis obsesionada con el poder, el glamur y la modificación corporal. Tu personaje es V, un mercenario que persigue un implante único que permite alcanzar la inmortalidad.')
insert into videojuego_genero(videojuego_id, genero_id) values ('4','2')

insert into pelicula (poster, nombre, duracion, sinopsis) values ('pelicula1.jpg', 'American Psycho', '2','En la década de 1980, Patrick Bateman es un hombre exitoso y obsesionado por la competencia y por la perfección material, quien utiliza los más caros cosméticos masculinos, equipos de gimnasia, solárium y demás maquinaria estética para lograr un cuerpo atlético y bien acicalado, identificador material del éxito social.')
insert into pelicula (poster, nombre, duracion, sinopsis) values ('pelicula2.jpg', 'Nightcrawler', '3','Louis Bloom es un joven de Los Ángeles, sin empleo ni escrúpulos, quien, después de haber sido testigo de un accidente espeluznante, decide que quiere ganar fama y fortuna a través del periodismo sensacionalista.')
insert into pelicula (poster, nombre, duracion, sinopsis) values ('pelicula3.jpg', 'Lord of the Rings', '4','En la Tierra Media, el Señor Oscuro Sauron forjó los Grandes Anillos del Poder y creó uno con el poder de esclavizar a toda la Tierra Media. Frodo Bolsón es un hobbit al que su tío Bilbo hace portador del poderoso Anillo Único con la misión de destruirlo. Acompañado de sus amigos, Frodo emprende un viaje hacia Mordor, el único lugar donde el anillo puede ser destruido. Sin embargo, Sauron ordena la persecución del grupo para recuperar el anillo y acabar con la Tierra Media.')
insert into pelicula (poster, nombre, duracion, sinopsis) values ('pelicula4.jpg', 'Fight Club', '1', 'Un empleado de oficina insomne, harto de su vida, se cruza con un vendedor peculiar. Ambos crean un club de lucha clandestino como forma de terapia y, poco a poco, la organización crece y sus objetivos toman otro rumbo.')

insert into serie (poster, nombre, duracion) values ('friends.jpg', 'Friends', '20')


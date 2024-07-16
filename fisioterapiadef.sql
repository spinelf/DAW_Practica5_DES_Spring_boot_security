CREATE DATABASE  IF NOT EXISTS fisioterapia;
USE fisioterapia;

CREATE TABLE direcciones (
  id_direccion int NOT NULL AUTO_INCREMENT,
  calle varchar(45) NOT NULL,
  localidad varchar(45) NOT NULL,
  numero int NOT NULL,
  piso varchar(5) DEFAULT 'null',
  letra varchar(5) DEFAULT 'null',
  CP varchar(5) NOT NULL,
  PRIMARY KEY (id_direccion)
);
INSERT INTO direcciones VALUES (1,'calle Wallaby','Madrid',42,NULL,NULL,'28870'),(2,'calle Falsa','Barcelona',123,NULL,NULL,'08080'),(3,'Baker Street','Malaga',221,NULL,'B','29450'),(4,'Central Park West','Madrid',550,'22','2206','28690');

CREATE TABLE familias (
  id_familia int NOT NULL AUTO_INCREMENT,
  nombre_familia varchar(45) NOT NULL,
  descripcion_familia varchar(100) DEFAULT NULL,
  PRIMARY KEY (id_familia)
);
INSERT INTO familias VALUES (1,'masajes','todo lo relacionado con los masajes y tratamientos'),(2,'tienda','compra de productos: aceites, cremas,...'),(3,'regalo','ticket regalo por el importe deseado para sesiones o tienda');

CREATE TABLE productos (
  id_producto int NOT NULL AUTO_INCREMENT,
  normbre_producto varchar(45) NOT NULL,
  descripcion_producto varchar(150) NOT NULL,
  precio_producto double(6,2) NOT NULL,
  stock_producto int NOT NULL,
  id_familia int NOT NULL,
  PRIMARY KEY (id_producto),
 FOREIGN KEY (id_familia) REFERENCES familias (id_familia)
);
INSERT INTO productos VALUES (1,'terapeutico','sesion masaje terapeutico 45 minutos',45.00,100,1),(2,'relajante','sesion masaje relajante 45 minutos',40.00,100,1),(3,'deportivo','sesion masaje deportivo 45 minutos',45.00,100,1),(4,'crema relajante','crema relajante muscular',15.99,5,2),(5,'aceite masaje','aceite para masajes',18.99,10,2),(6,'crema frio','crema efecto frio',10.99,5,2),(7,'regalo sesion','regalo sesion masaje relajante',40.00,100,2),(8,'ticket','ticket regalo 50 euros',50.00,100,3);

CREATE TABLE roles (
  id_rol int NOT NULL AUTO_INCREMENT,
  nombre_rol varchar(45) NOT NULL,
  PRIMARY KEY (id_rol)
);

INSERT INTO roles VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USUARIO');

CREATE TABLE usuarios (
  id_usuario int NOT NULL AUTO_INCREMENT,
  nombre_usuario varchar(45) NOT NULL,
  apellidos_usuario varchar(45) NOT NULL,
  fecha_nacimiento date NOT NULL,
  email_usuario varchar(45) NOT NULL,
  Password varchar(100) NOT NULL,
  enabled INT NOT NULL DEFAULT 1,
  id_rol int NOT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY  (email_usuario)
);
INSERT INTO usuarios VALUES (1,'Sherlock','Holmes','1863-01-06','sherlock@gmail.com','$2a$10$NhvkQpTwxLZ/OMXuMBUmduOW19TSxR/C1GIfiHkoX/dxsRIs2eP2u','true',1),(2,'John','Watson','1852-08-07','john@gmail.com','$2a$10$6fqldDWaSpn24LAy45ttPuOkDBuY82g87VR.Qvu/E5Uogo73VVs6C','true',2),(3,'Dana','Barret','1984-06-08','dana@gmail.com','$2a$10$7tJTrUPZ8ziw6MJBZ4wxUOZJQgXwL8QB.fjn7zY1hgW3TWCtG/QSC','true',2),(4,'Homer','Simpson','1956-05-12','homer@gmail.com','$2a$10$qdbAy.ZDjjGdfRLx9CriwOK0Hoaq8afP.tJE5Lvc1b7XHDxmFWzPK','true',1),(5,'P.','Sherman','2003-11-28','p@gmail.com','$2a$10$NXIt4y6TTDRqUbadDeYwCuewz4pBzJ90ixo0k9lDeOKRwg6YbcYpa','true',2);

CREATE TABLE tarjetas (
  id_tarjeta int NOT NULL AUTO_INCREMENT,
  numero_tarjeta varchar(16) NOT NULL,
  nombre_titular varchar(45) NOT NULL,
  mes_caducidad varchar(2) NOT NULL,
  anno_caducidad varchar(2) NOT NULL,
  cvv varchar(3) NOT NULL,
  PRIMARY KEY (id_tarjeta)
);

INSERT INTO `tarjetas` VALUES (1,'1234567891234567','Sherlock Holmes','10','25','123'),(2,'1112223334445556','Sherlock Holmes','05','28','001'),(3,'9999999999999999','Dana Barret','01','31','999'),(4,'0101010101010101','Homer J. Simpson','05','29','101');

CREATE TABLE direcciones_usuarios (
  id_direccion int NOT NULL,
  id_usuario int NOT NULL,
  PRIMARY KEY (id_usuario,id_direccion),
  FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion),
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
  );
-- INSERT INTO direcciones_usuarios VALUES (1,3,1),(2,3,2),(3,4,3),(4,2,4),(5,1,5);

CREATE TABLE tarjetas_usuarios (
  id_tarjeta int NOT NULL,
  id_usuario int NOT NULL,
  PRIMARY KEY (id_tarjeta,id_usuario),
  FOREIGN KEY (id_tarjeta) REFERENCES tarjetas(id_tarjeta),
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
);

CREATE TABLE pedidos (
  id_pedido int NOT NULL AUTO_INCREMENT,
  fecha_pedido date NOT NULL,
  estado_pedido varchar(45) NOT NULL,
  id_usuario int NOT NULL,
  id_tarjeta int NOT NULL,
  Id_direccion int NOT NULL,
  PRIMARY KEY (id_pedido),
  FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario),
  FOREIGN KEY (id_tarjeta) REFERENCES tarjetas (id_tarjeta),
  FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion)
  );
-- INSERT INTO pedidos VALUES (1,'2023-02-06','pendiente',1,1,3),(2,'2023-01-29','pendiente',1,2,3),(3,'2023-01-31','pendiente',4,4,2),(4,'2022-12-06','cerrado',5,5,1),(5,'2023-01-10','cerrado',3,3,4);

CREATE TABLE productos_pedidos (
  id_productos_pedidos int NOT NULL AUTO_INCREMENT,
  id_producto int NOT NULL,
  id_pedido int NOT NULL,
  cantidad int NOT NULL,
  precio_venta decimal(9,2) NOT NULL,
  PRIMARY KEY (id_productos_pedidos),
  FOREIGN KEY (id_producto) REFERENCES productos (id_producto),
  FOREIGN KEY (id_pedido) REFERENCES pedidos (id_pedido)
);

-- INSERT INTO productos_pedidos VALUES (1,2,1,10,150),(3,4,1,1,45),(4,3,2,2,80),(5,6,2,1,45),(6,1,3,10,150),(7,4,3,10,150),(8,8,4,1,45),(9,7,5,1,45),(10,5,5,10,150);


create user fisio_2023 identified by 'fisio_2023';
grant all PRIVILEGES on fisioterapia.* to fisio_2023;
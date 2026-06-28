CREATE DATABASE IF NOT EXISTS ecommercedb;
USE ecommercedb;

CREATE TABLE Productos (
    Id_producto INT NOT NULL AUTO_INCREMENT,
    Url_imagen VARCHAR(255) DEFAULT NULL,
    Titulo VARCHAR(100) NOT NULL,
    Fecha_public DATE NOT NULL,
    Stock INT NOT NULL DEFAULT 0,
    Descripcion VARCHAR(255) DEFAULT NULL,
    Caracteristicas VARCHAR(255) DEFAULT NULL,
    Precio DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (Id_producto)
);

CREATE TABLE Usuarios (
    Id_usuario INT NOT NULL AUTO_INCREMENT,
    Nombre_user VARCHAR(50) DEFAULT NULL,
    Apellido_user VARCHAR(50) DEFAULT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Contrasena VARCHAR(100) NOT NULL,
    Telefono VARCHAR(20) DEFAULT NULL,
    Rol VARCHAR(20) DEFAULT 'CLIENTE',
    PRIMARY KEY (Id_usuario)
);

CREATE TABLE Compras (
    Id_compra INT NOT NULL AUTO_INCREMENT,
    Id_usuario INT NOT NULL,
    Fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP,
    Estado VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    PRIMARY KEY (Id_compra),
    CONSTRAINT FK_Compras_Usuarios FOREIGN KEY (Id_usuario) REFERENCES Usuarios (Id_usuario)
);

CREATE TABLE Detalle_compras (
    Id_detalle INT NOT NULL AUTO_INCREMENT,
    Id_compra INT NOT NULL,
    Id_producto INT NOT NULL,
    Cantidad INT NOT NULL,
    Precio_unitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (Id_detalle),
    CONSTRAINT FK_Detalle_Compras FOREIGN KEY (Id_compra) REFERENCES Compras (Id_compra),
    CONSTRAINT FK_Detalle_Productos FOREIGN KEY (Id_producto) REFERENCES Productos (Id_producto)
);

INSERT INTO Usuarios (Nombre_user, Apellido_user, Email, Contrasena, Rol) 
VALUES ("Admin", "General", "admin@ecommerce.com", "123456", "ADMINISTRADOR");

INSERT INTO Productos (Url_imagen, Titulo, Fecha_public, Stock, Descripcion, Caracteristicas, Precio)
VALUES 
('https://via.placeholder.com/150', 'Producto de Muestra A', '2026-06-26', 15, 'Descripción del producto A', 'Característica principal A', 1500.00),
('https://via.placeholder.com/150', 'Producto de Muestra B', '2026-06-25', 8, 'Descripción del producto B', 'Característica principal B', 3200.50);
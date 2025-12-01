DROP DATABASE IF EXISTS Cedis;
CREATE DATABASE Cedis;
USE Cedis;

-- TABLA MARCA
CREATE TABLE marca(
    idMarca INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombreMarca VARCHAR(100) NOT NULL
);

-- TABLA CLIENTE
CREATE TABLE cliente(
    idCliente INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    telefono VARCHAR(100)
);

-- TIPO DE ALMACÉN
CREATE TABLE tipoAlmacen(
    idTipo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombreTipo VARCHAR(100) NOT NULL
);

-- TIPO DE PRODUCTO
CREATE TABLE tipoProducto(
    idTipoProducto INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombreTipoProducto VARCHAR(100) NOT NULL
);

-- ALMACÉN
CREATE TABLE almacen(
    idAlmacen INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombreAlmacen VARCHAR(100) NOT NULL,
    idTipoAlmacen INT UNSIGNED NOT NULL,
    FOREIGN KEY(idTipoAlmacen)
        REFERENCES tipoAlmacen(idTipo)
        ON DELETE CASCADE
);

-- FACTURA
CREATE TABLE factura(
    idFactura INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idCliente INT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY(idCliente)
        REFERENCES cliente(idCliente)
        ON DELETE CASCADE
);

-- PRODUCTO
CREATE TABLE producto(
    idProducto INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idTipo INT UNSIGNED NOT NULL,
    idMarca INT UNSIGNED NOT NULL,
    nombreProducto VARCHAR(100) NOT NULL,
    imei varchar(15),
    peso FLOAT NOT NULL,
    fragil BOOLEAN NOT NULL,
    precioUnidad FLOAT NOT NULL,
    FOREIGN KEY(idMarca)
        REFERENCES marca(idMarca)
        ON DELETE CASCADE,
    FOREIGN KEY(idTipo)
        REFERENCES tipoProducto(idTipoProducto)
        ON DELETE CASCADE
);

-- PROVEEDOR
CREATE TABLE proveedor(
    idProveedor INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombreProveedor VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(100) NOT NULL
);

-- PRODUCTO-PROVEEDOR
CREATE TABLE producto_proveedor(
    idPP INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    idProducto INT UNSIGNED NOT NULL,
    idProveedor INT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    valorCompra FLOAT NOT NULL,
    cantidadCompra INT NOT NULL,
    total FLOAT NOT NULL,
    FOREIGN KEY(idProducto)
        REFERENCES producto(idProducto)
        ON DELETE CASCADE,
    FOREIGN KEY(idProveedor)
        REFERENCES proveedor(idProveedor)
        ON DELETE CASCADE
);

CREATE TABLE estadoAlmPro(
	idEstadoAlmPro int AUTO_INCREMENT PRIMARY KEY,
    nombreEstado varchar(100) not null
);

-- ALMACÉN - PRODUCTO (INVENTARIO)
CREATE TABLE almacen_producto(
    idAlmacen INT UNSIGNED NOT NULL,
    idProducto INT UNSIGNED NOT NULL,
    idEstadoAlmPro int not null,
    cantDisp INT NOT NULL,
    PRIMARY KEY(idAlmacen, idProducto),
    FOREIGN KEY(idAlmacen)
        REFERENCES almacen(idAlmacen)
        ON DELETE CASCADE,
    FOREIGN KEY(idProducto)
        REFERENCES producto(idProducto)
        ON DELETE CASCADE,
    FOREIGN KEY(idEstadoAlmPro)
    REFERENCES estadoAlmPro(idEstadoAlmPro) on DELETE CASCADE
);

CREATE TABLE factura_producto(
    idFactura INT UNSIGNED NOT NULL,
    idProducto INT UNSIGNED NOT NULL,
    cantidad INT NOT NULL,
    precioVenta DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(idFactura, idProducto),
    FOREIGN KEY(idFactura) REFERENCES factura(idFactura) ON DELETE CASCADE,
    FOREIGN KEY(idProducto) REFERENCES producto(idProducto) ON DELETE CASCADE
);

DELIMITER $$

-- Trigger para INSERT
CREATE TRIGGER trg_ins_almacen_producto
BEFORE INSERT ON almacen_producto
FOR EACH ROW
BEGIN
    IF NEW.cantDisp <= 5 THEN
        SET NEW.idEstadoAlmPro = 2;
    END IF;
END$$

-- Trigger para UPDATE
CREATE TRIGGER trg_upd_almacen_producto
BEFORE UPDATE ON almacen_producto
FOR EACH ROW
BEGIN
    IF NEW.cantDisp <= 5 THEN
        SET NEW.idEstadoAlmPro = 2;
    END IF;
END$$

DELIMITER ;

DELIMITER $$

-- Trigger para INSERT
CREATE TRIGGER trg_ins_producto_fragil
BEFORE INSERT ON producto
FOR EACH ROW
BEGIN
    IF NEW.peso < 0.5 THEN
        SET NEW.fragil = TRUE;
    END IF;
END$$

-- Trigger para UPDATE
CREATE TRIGGER trg_upd_producto_fragil
BEFORE UPDATE ON producto
FOR EACH ROW
BEGIN
    IF NEW.peso < 0.5 THEN
        SET NEW.fragil = TRUE;
    END IF;
END$$

DELIMITER ;


DELIMITER $$

-- Trigger para INSERT
CREATE TRIGGER trg_ins_producto_imei
BEFORE INSERT ON producto
FOR EACH ROW
BEGIN
    DECLARE tipoNombre VARCHAR(100);

    -- Obtener el nombre del tipo de producto
    SELECT nombreTipoProducto 
    INTO tipoNombre
    FROM tipoProducto
    WHERE idTipoProducto = NEW.idTipo;

    -- Validar IMEI
    IF tipoNombre <> 'CELULAR' AND NEW.imei IS NOT NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Solo se permite IMEI si el producto es un CELULAR';
    END IF;
END$$

-- Trigger para UPDATE
CREATE TRIGGER trg_upd_producto_imei
BEFORE UPDATE ON producto
FOR EACH ROW
BEGIN
    DECLARE tipoNombre VARCHAR(100);

    SELECT nombreTipoProducto 
    INTO tipoNombre
    FROM tipoProducto
    WHERE idTipoProducto = NEW.idTipo;

    IF tipoNombre <> 'CELULAR' AND NEW.imei IS NOT NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Solo se permite IMEI si el producto es un CELULAR';
    END IF;
END$$

DELIMITER ;

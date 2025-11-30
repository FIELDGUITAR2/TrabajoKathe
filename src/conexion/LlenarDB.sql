-- =========================
-- DATOS DE REFERENCIA
-- =========================

-- MARCAS
INSERT INTO marca (nombreMarca) VALUES
('Samsung'),
('Apple'),
('LG'),
('Sony');

-- CLIENTES
INSERT INTO cliente (nombre, correo, telefono) VALUES
('Juan Pérez', 'juan.perez@example.com', '3001234567'),
('María Gómez', 'maria.gomez@example.com', '3017654321'),
('Carlos López', 'carlos.lopez@example.com', '3029876543');

-- TIPOS DE ALMACÉN
INSERT INTO tipoAlmacen (nombreTipo) VALUES
('Central'),
('Regional'),
('Minorista');

-- TIPOS DE PRODUCTO
INSERT INTO tipoProducto (nombreTipoProducto) VALUES
('Electrónico'),
('Electrodoméstico'),
('Accesorio');

-- ALMACENES
INSERT INTO almacen (nombreAlmacen, idTipoAlmacen) VALUES
('Almacén Central Bogotá', 1),
('Almacén Medellín', 2),
('Almacén Cali', 3);

-- ESTADOS DE PRODUCTO EN ALMACÉN
INSERT INTO estadoAlmPro (nombreEstado) VALUES
('Disponible'),
('Stock Bajo'),
('Agotado');

-- PROVEEDORES
INSERT INTO proveedor (nombreProveedor, direccion, correo, telefono) VALUES
('Distribuidora Andina', 'Cra 10 #20-30 Bogotá', 'contacto@andina.com', '3101112233'),
('ElectroImport', 'Av. Libertador #45-67 Medellín', 'ventas@electroimport.com', '3112223344'),
('TechWorld', 'Calle 50 #12-34 Cali', 'info@techworld.com', '3123334455');

-- PRODUCTOS
INSERT INTO producto (idTipo, idMarca, nombreProducto, imei, peso, fragil, precioUnidad) VALUES
(1, 1, 'Samsung Galaxy S22', '123456789012345', 0.18, TRUE, 3500000),
(1, 2, 'iPhone 14', '987654321098765', 0.20, TRUE, 4500000),
(2, 3, 'LG Refrigerador', NULL, 60.00, FALSE, 2500000),
(2, 4, 'Sony Televisor 55"', NULL, 18.00, FALSE, 3200000),
(3, 1, 'Cargador Samsung', NULL, 0.25, TRUE, 80000);

-- PRODUCTO-PROVEEDOR (COMPRAS)
INSERT INTO producto_proveedor (idProducto, idProveedor, fecha, valorCompra, cantidadCompra, total) VALUES
(1, 1, '2025-11-01', 3000000, 10, 30000000),
(2, 2, '2025-11-02', 4000000, 8, 32000000),
(3, 3, '2025-11-03', 2000000, 5, 10000000),
(4, 1, '2025-11-04', 2800000, 7, 19600000),
(5, 2, '2025-11-05', 60000, 20, 1200000);

-- INVENTARIO (ALMACÉN - PRODUCTO)
INSERT INTO almacen_producto (idAlmacen, idProducto, idEstadoAlmPro, cantDisp) VALUES
(1, 1, 1, 15),
(1, 2, 1, 12),
(2, 3, 1, 6),
(2, 4, 2, 5),   -- Trigger ajustará estado a 2 si cantDisp <= 5
(3, 5, 2, 4);   -- Trigger ajustará estado a 2

-- FACTURAS
INSERT INTO factura (idCliente, fecha) VALUES
(1, '2025-11-10'),
(2, '2025-11-11'),
(3, '2025-11-12');

-- DETALLE DE FACTURAS
INSERT INTO factura_producto (idFactura, idProducto, cantidad, precioVenta) VALUES
(1, 1, 1, 3600000),
(1, 5, 2, 90000),
(2, 2, 1, 4600000),
(3, 4, 1, 3300000);

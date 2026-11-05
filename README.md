# API REST - Gestión de Productos

## Descripción

Este proyecto consiste en el desarrollo de una API REST utilizando Spring Boot para gestionar los productos de una tienda.

La aplicación permite consultar, registrar y eliminar productos mediante solicitudes HTTP. Los datos se almacenan en una colección en memoria mientras la aplicación permanece ejecutándose.

## Tecnologías utilizadas

- Java 25
- Spring Boot 4.1.2
- Spring Web MVC
- Maven
- IntelliJ IDEA

## Arquitectura del proyecto

El proyecto está organizado en las siguientes capas y componentes:

- **model:** contiene la clase Producto.
- **service:** contiene la lógica de negocio y las operaciones sobre los productos.
- **controller:** expone los endpoints de la API REST.
- **exception:** contiene las excepciones personalizadas y el manejador global de errores.

Se utiliza inyección de dependencias mediante constructor para proporcionar el servicio al controlador.

## Endpoints disponibles

| Método | Endpoint | Descripción |
|---|---|---|
| GET | /api/productos | Consultar todos los productos |
| GET | /api/productos/{id} | Consultar un producto por ID |
| POST | /api/productos | Registrar un producto |
| DELETE | /api/productos/{id} | Eliminar un producto |

## Ejemplo de registro

Solicitud POST:

```json
{
  "nombre": "Monitor",
  "precio": 220.50,
  "stock": 8
}
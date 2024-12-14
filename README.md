# Web Agencia de Viajes García

## Descripción
Web Agencia de Viajes García es una aplicación diseñada para una agencia que ofrece cruceros por todo el mundo. La plataforma permite a los usuarios explorar información sobre noticias, viajes, y tipos de barcos, así como registrarse y realizar pedidos.

---

## Tecnologías utilizadas

- **Backend:** Spring Boot (Java)
- **Base de datos:** MySQL
- **Frontend:** Angular, HTML, CSS

---

## Funcionalidades principales

1. **Mostrar información:** Noticias relevantes sobre cruceros, tipos de barcos y descripciones de viajes.
2. **Registro y autenticación:** Los usuarios pueden registrarse, iniciar sesión y gestionar sus pedidos.
3. **Realizar pedidos:** Seleccionar y confirmar reservas de cruceros.

---

## Arquitectura

La aplicación implementa las siguientes arquitecturas:

1. **MVC:** Separación de la lógica de negocio, modelos y vistas.
2. **Microservicios:** Actualmente cuenta con tres microservicios:
   - Gestión de usuarios
   - Gestión de pedidos
   - Visualización de pedidos
3. **Cliente-servidor:** Interacción cliente-servidor con consultas a la base de datos.

---

## Manual de usuario

1. **Registro:** Los usuarios pueden registrarse proporcionando sus datos personales.
2. **Inicio de sesión:** Acceso a la cuenta mediante credenciales.
3. **Explorar:** Navegar por las secciones para obtener información sobre cruceros y barcos.
4. **Pedidos:** Seleccionar un crucero y confirmar la reserva.

---

## Configuración e implementación

- La aplicación es web y no requiere instalación.
- Requisitos:
  - **Servidor:**
    - Java Runtime Environment (JRE)
    - Servidor MySQL
    - Node.js y Angular CLI para modificaciones en el frontend.

---

## Estructura del código

El código está organizado según el patrón **Modelo-Vista-Controlador (MVC):**

1. **Modelo:** Contiene la definición de entidades y relaciones.
2. **Vista:** Desarrollada con Angular, HTML y CSS.
3. **Controlador:** Maneja las solicitudes HTTP y la lógica de negocio.

---

## Base de datos

La aplicación utiliza una base de datos MySQL.

### Esquema:

- **Usuarios:**
  - `id_usuario` (PK)
  - `name`
  - `correo`
  - `password`
  - `rol`


- **Reservas:**
  - `id_reservas` (PK)
  - `idUsuario` (FK)
  - `fecha`
  - `status`

- **Viajes:**
  - `id_viaje` (PK)
  - `name`
  - `idContinente`
  - `capacidad`
  - `precio`

- **Continentes:**
  - `idContinente ` (PK)
  - `name`

- **elementosReservas:**
  - `id_elementosReservas ` (PK)
  - `id_reservas` (PK)
 - `id_viajes ` (PK)
  - `unidades `
---



## Futuras mejoras

1. Incorporar nuevos microservicios para la gestión de barcos y reportes de actividad.
2. Optimizar el rendimiento de las consultas a la base de datos.
3. Agregar un formulario de contacto para reportar problemas y sugerencias.

---

## Instalación y configuración local

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/PedroDonato137/TFM.WebViajesGarcia.git
   ```

2. Configurar la base de datos MySQL:
   - Crear una base de datos llamada `bd_agenciaviajes`.
   - Puedes importar la base de datos MySQL con los ficheros de la carpeta Base de datos

3. Configurar el backend:
   - Actualizar el archivo `application.properties` con las credenciales de tu base de datos.

4. Ejecutar el backend:
   ```bash
   mvn spring-boot:run
   ```


5. Ejecutar el frontend:
   ```bash
   cd frontend
   npm install
   ng serve
   ```

6. Acceder a la aplicación en `http://localhost:4200`.

---

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.


# Parqueadero Management System
 
## Descripción
 
Este proyecto es una aplicación web de gestión de parqueaderos, donde los usuarios pueden registrar, ver y gestionar clientes y servicios. El sistema utiliza el patrón de arquitectura Model-View-Controller (MVC) y está dividido en un frontend, backend y una base de datos en la nube.
 
- **Backend**: Spring Boot (Java)

- **Frontend**: Angular (TypeScript) y Axios

- **Base de Datos**: MongoDB (en la nube)

- **Protocolo de Comunicación**: REST con formato JSON

- **Contenedores**: Docker
 
## Características
 
1. **Gestión de Clientes**: 

   - Agregar, actualizar, visualizar y eliminar clientes.

   - Registrar automáticamente la hora de entrada y salida de los clientes en el parqueadero.
 
2. **Gestión de Servicios**: 

   - Registrar servicios de entrada y salida con detalles como la hora y el costo.

   - Seguimiento de los servicios proporcionados a cada cliente.
 
3. **Gestión del Parqueadero**:

   - Control de espacios disponibles en el parqueadero y ganancias totales.

   - Ajuste automático de espacios al ingresar o salir un cliente.
 
## Estructura del Proyecto
 
### Backend
 
El backend está construido utilizando Spring Boot y expone una API REST para manejar la lógica de negocio, las capas de servicio y las operaciones con MongoDB.

![WhatsApp Image 2024-09-28 at 23 00 08](https://github.com/user-attachments/assets/010494f5-5a1a-4a85-b44b-e4a23a9e7d96)

 
### Frontend
 
El frontend es una aplicación Angular que consume la API REST proporcionada por el backend.

 
![WhatsApp Image 2024-09-28 at 22 58 43](https://github.com/user-attachments/assets/7796e5d0-fb53-4e9a-8682-9d23b97197f9)

 
### Descripción del uso de Axios
 
Axios es una librería utilizada en el frontend de Angular para realizar peticiones HTTP. Se utiliza para interactuar con la API REST del backend, lo que permite obtener, crear, actualizar y eliminar datos relacionados con los clientes, servicios y el estado del parqueadero.
 
#### Ventajas de Axios
 
- **Soporte para Promesas**: Axios utiliza promesas, lo que facilita el manejo de respuestas asíncronas con `async/await` o `.then()`.

- **Interceptors**: Permite configurar interceptores para modificar las peticiones o respuestas antes de que lleguen a su destino.

- **Manejo de Errores**: Incluye un mecanismo para capturar y manejar errores de forma eficiente con `.catch()` o `try/catch`.

- **Personalización**: Fácil configuración de headers, tiempo de espera y autenticación en cada petición.
 
#### Integración con el Proyecto
 
En este proyecto, Axios se utiliza para interactuar con los siguientes endpoints del backend, permitiendo al frontend gestionar de manera eficiente las operaciones CRUD (Crear, Leer, Actualizar y Eliminar) de clientes y servicios, así como la gestión del parqueadero.
 
### Endpoints del Backend
 
#### Clientes
 
- **GET /api/clientes**: Obtiene la lista de todos los clientes.

- **GET /api/clientes/{id}**: Obtiene un cliente específico por ID.

- **POST /api/clientes**: Crea un nuevo cliente.

- **PUT /api/clientes/{id}**: Actualiza los datos de un cliente existente.

- **DELETE /api/clientes/{id}**: Elimina un cliente y registra su salida del parqueadero.
 
#### Servicios
 
- **GET /api/servicios**: Obtiene la lista de todos los servicios.

- **GET /api/servicios/{id}**: Obtiene un servicio específico por ID.

- **POST /api/servicios**: Crea un nuevo servicio (Entrada/Salida de un cliente).

- **PUT /api/servicios/{id}**: Actualiza los detalles de un servicio.

- **DELETE /api/servicios/{id}**: Elimina un servicio.
 
#### Parqueadero
 
- **GET /api/parqueadero**: Obtiene el estado actual del parqueadero, incluyendo espacios disponibles y ganancias totales.
 
## Ejecución

Sigue estos pasos para ejecutar el proyecto localmente utilizando Docker:

1. **Descargar el código**: Clona este repositorio en tu máquina local usando el siguiente comando:
    ```bash
    git clone https://github.com/tu-usuario/taller-2-arquitectura.git
    ```

2. **Ejecutar Docker Compose**: Dentro del directorio del proyecto, ejecuta el siguiente comando para construir y levantar los contenedores:
    ```bash
    docker-compose up --build
    ```
3. **Abrir la imagen del frontend en Docker**: Una vez que los contenedores estén en funcionamiento, abre la imagen correspondiente al frontend en Docker para interactuar con la aplicación.
 

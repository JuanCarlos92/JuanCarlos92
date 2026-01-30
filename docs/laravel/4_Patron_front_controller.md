## El patrón FRONT CONTROLLER

El patrón **Front Controller** es un diseño de software donde existe un **único punto de entrada** centralizado para todas las solicitudes HTTP de la aplicación. En Laravel, este patrón es la columna vertebral que dirige el tráfico hacia los controladores y acciones correspondientes.

---

### Elementos clave en Laravel

#### 1. Punto de Entrada Único
El archivo **`public/index.php`** es el corazón de este patrón. 
* Todas las peticiones HTTP se redirigen aquí.
* **Seguridad:** Al ser la carpeta `public` el único acceso externo, el resto del código (configuración, base de datos, lógica) queda protegido fuera de la raíz web.

#### 2. Enrutamiento (Routing)
El sistema de rutas analiza la URL y decide qué parte de la aplicación debe responder.
* **Archivo principal:** `routes/web.php`.
* Asocia una URL específica con un controlador y un método concreto.

#### 3. Controladores
Son clases que agrupan la lógica de negocio de la aplicación.
* Reciben la petición del enrutador.
* Procesan los datos y devuelven una respuesta (una vista o un JSON).

#### 4. Vistas (Views)
Son las plantillas (generalmente usando el motor **Blade**) encargadas de la interfaz de usuario.
* El controlador les pasa los datos necesarios para renderizar el HTML final que verá el usuario.

#### 5. Middlewares
Actúan como "capas de cebolla" o filtros que rodean la ejecución de la lógica principal.
* **Funciones:** Autenticación, control de sesiones, seguridad (CSRF) y validación de permisos.
* Se ejecutan antes o después de que la solicitud llegue al controlador.

---

### Resumen del Flujo de Trabajo

El patrón Front Controller garantiza un proceso **centralizado y coherente**:

1. **Petición:** El usuario solicita una URL.
2. **Entrada:** `index.php` recibe la solicitud.
3. **Filtro:** Los *Middlewares* verifican la seguridad.
4. **Ruta:** El *Router* busca el controlador asignado.
5. **Lógica:** El *Controlador* gestiona la base de datos o procesos.
6. **Salida:** La *Vista* genera el HTML y se envía al usuario.

> Este sistema promueve un código organizado, escalable y, sobre todo, mucho más seguro que el desarrollo PHP tradicional.
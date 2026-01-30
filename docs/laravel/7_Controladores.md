## 5. Controladores (`app/Http/Controllers`)

El controlador es el cerebro que coordina la lógica de una ruta. Su función es recibir la petición, procesar los datos (interactuando con modelos si es necesario) y devolver una respuesta (una vista o datos).

---

### Responsabilidades principales
1.  **Recibir Solicitudes:** Se asocian a rutas y métodos HTTP (GET, POST, etc.).
2.  **Procesar Lógica:** Validan datos, realizan cálculos y toman decisiones.
3.  **Preparar Datos:** Consultan modelos y organizan la información para las vistas.
4.  **Enviar Respuesta:** Retornan una vista renderizada, un JSON o una redirección.

---

### Creación de un Controlador
Para crear un controlador, usamos la terminal (Artisan) desde la raíz del proyecto:

```bash
php artisan make:controller HomeController

```

> **Convención:** Se recomienda que el nombre siempre termine en `Controller` (ej. `PostController`, `UserController`).

---

### Caso 1: Controlador de un solo método (`__invoke`)

Si un controlador solo va a realizar una acción, podemos usar el método mágico `__invoke()`.

**Archivo `app/Http/Controllers/HomeController.php`:**

```php
<?php
namespace App\Http\Controllers;

class HomeController extends Controller
{
    public function __invoke()
    {
        return "<h1>Hola Crack,</h1><br> bienvenido a Laravel!!";
    }
}

```

**En `routes/web.php`:**

```php
use App\Http\Controllers\HomeController;

Route::get('/', HomeController::class);

```

---

### Caso 2: Controlador con múltiples métodos

Cuando una entidad (como `2DAW`) tiene varias acciones, creamos métodos públicos para cada una.

**Creación:**

```bash
php artisan make:controller DawController

```

**Archivo `app/Http/Controllers/DawController.php`:**

```php
<?php
namespace App\Http\Controllers;

class DawController extends Controller
{
    public function index() {
        return "Estás en el segundo curso de DAW";
    }

    public function profesor() {
        return "<h1>El profesor de 2ºDAW</h1> en IES Trafalgar es Teo";
    }

    public function modulo($modulo) {
        return "Bienvenido al módulo: " . $modulo;
    }

    public function alumno($modulo, $alumno, $nota = null) {
        if(empty($nota)) return "Hola usuario <h1>$alumno.</h1>";
        return "El usuario <h1>$alumno</h1> ha sacado un $nota en $modulo.";
    }
}

```

---

### Configuración final de `routes/web.php`

Para que Laravel reconozca los controladores, debemos importarlos al principio del archivo de rutas.

```php
<?php
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\DawController;

// Ruta con controlador de método único
Route::get('/', HomeController::class);

// Rutas con controlador de múltiples métodos
Route::get('2DAW', [DawController::class, 'index']);
Route::get('2DAW/DWESProfesor', [DawController::class, 'profesor']);
Route::get('2DAW/{modulo}', [DawController::class, 'modulo']);
Route::get('2DAW/{modulo}/{alumno}/{nota?}', [DawController::class, 'alumno']);

```

---

### Resumen

Mover la lógica de las rutas a los controladores permite tener un archivo `web.php` limpio y una aplicación organizada. Recuerda que el orden de las rutas sigue siendo importante: **las rutas fijas siempre deben ir antes que las dinámicas.**

```

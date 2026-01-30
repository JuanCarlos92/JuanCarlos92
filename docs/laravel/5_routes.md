## Rutas (`/routes`)

Cuando un usuario accede a una aplicación Laravel, entra por el archivo `public/index.php`. El **sistema de enrutamiento** es el encargado de decidir qué controlador o función debe ejecutarse según la URL ingresada.

---

### Definición de Rutas
Las rutas se definen principalmente en el archivo `routes/web.php`. Estas reglas mapean una URL a una acción.

**Ejemplo básico:**
```php
use Illuminate\Support\Facades\Route;

// Retornar una vista
Route::get('/', function(){
    return view('welcome');
});

// Retornar código HTML directo
Route::get('/saludo', function(){
    return "<h1>Hola Crack,</h1><br> bienvenido a Laravel!!";
});

```

---

### Rutas Dinámicas

Para pasar variables a través de la URL (estilo GET), usamos llaves `{}`. El nombre de la variable debe pasarse como argumento a la función anónima.

```php
Route::get('2DAW/{modulo}', function($modulo){
    return "Hola Crack!. Bienvenido al módulo: " . $modulo;
});

```

---

### Orden de las Rutas: Estáticas vs Dinámicas

Laravel lee el archivo de rutas de **arriba hacia abajo**. Si una ruta dinámica coincide con el patrón de una estática, la primera que encuentre será la que se ejecute.

> **Regla de oro:** Siempre coloca las rutas fijas (estáticas) **antes** de las dinámicas.

**Orden correcto:**

```php
// 1º Ruta fija (específica)
Route::get('2DAW/DWESProfesor', function () {
    return "<h1>El profesor de 2ºDAW</h1> en IES Trafalgar es Teo";
});

// 2º Ruta dinámica (general)
Route::get('2DAW/{modulo}', function ($modulo) {
    return "Bienvenido al módulo: " . $modulo;
});

```

---

### Rutas con múltiples parámetros

Puedes pasar tantos argumentos como necesites manteniendo el orden en la función:

```php
Route::get('2DAW/{modulo}/{alumno}/{nota}', function ($modulo, $alumno, $nota) {
    return "El alumno: $alumno, ha sacado un $nota en el módulo $modulo";
});

```

---

###Rutas con parámetros opcionales

Si un parámetro puede no estar presente, añade un signo de interrogación `?` al final del nombre y asegúrate de darle un valor por defecto en la función (normalmente `null`).

```php
Route::get('2DAW/{modulo}/{alumno}/{nota?}', function ($modulo, $alumno, $nota = null) {
    if (empty($nota)) {
        return "Hola usuario <h1>$alumno.</h1>";
    }
    return "El usuario <h1>$alumno</h1> ha sacado un $nota en el módulo $modulo.";
});

```

---

### Buenas Prácticas: `routes/web.php`

Aunque es didáctico escribir lógica dentro de las rutas, la buena práctica en Laravel dicta que **el archivo de rutas no debe contener lógica de programación**.

> **Regla:** Las rutas deben limitarse a dirigir la petición al **Controlador** correspondiente, que es donde debe residir la lógica.

```

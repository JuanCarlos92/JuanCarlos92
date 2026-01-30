## Grupos de Rutas

Cuando desarrollamos en Laravel, uno de los principios fundamentales es el **DRY** (*Don't Repeat Yourself*). Si observamos el archivo `routes/web.php` del apartado anterior, vemos que repetimos el nombre del controlador en múltiples líneas:

```php
// Código redundante
Route::get('2DAW', [DawController::class, 'index']);
Route::get('2DAW/DWESProfesor', [DawController::class, 'profesor']);
Route::get('2DAW/{modulo}', [DawController::class, 'modulo']);
Route::get('2DAW/{modulo}/{alumno}/{nota?}', [DawController::class, 'alumno']);

```

---

### Agrupación por Controlador

Para evitar esta repetición y organizar mejor el código, Laravel permite agrupar rutas que comparten el mismo controlador mediante el método `Route::controller()`.

**Ejemplo de grupo de rutas para `DawController`:**

```php
use App\Http\Controllers\DawController;
use App\Http\Controllers\HomeController;

Route::get('/', HomeController::class);

// Grupo organizado
Route::controller(DawController::class)->group(function() {
    Route::get('2DAW', 'index');
    Route::get('2DAW/DWESProfesor', 'profesor');
    Route::get('2DAW/{modulo}', 'modulo');
    Route::get('2DAW/{modulo}/{alumno}/{nota?}', 'alumno');
});

```

---

### Ventajas de usar Grupos

1. **Limpieza Visual:** Es mucho más fácil identificar de un vistazo qué rutas gestiona cada controlador.
2. **Mantenimiento:** Si en el futuro decides cambiar el nombre del controlador, solo tendrás que modificarlo en una línea, no en todas las rutas.
3. **Escalabilidad:** Facilita la aplicación de otros prefijos o middlewares a todo el bloque de rutas de forma simultánea.

---

### Nota sobre la Sintaxis

Al estar dentro del grupo `Route::controller(...)`, ya no es necesario pasar un array `[Controlador::class, 'metodo']`. Basta con pasar el **nombre del método** como un *string*, ya que Laravel asume que el método pertenece al controlador definido en la cabecera del grupo.

```
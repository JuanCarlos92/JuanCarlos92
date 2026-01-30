# Pasos rápidos para crear una App en Laravel 10

Este documento resume el flujo de trabajo esencial para levantar un proyecto desde cero, configurar la base de datos y generar los componentes principales.

---

## 1. Creación de la Aplicación
El primer paso es generar el proyecto utilizando **Composer**.

```bash
composer create-project laravel/laravel MiBlog
cd MiBlog

```

---

## 2. Conexión con la Base de Datos

1. Crea una base de datos (vía phpMyAdmin o terminal) llamada `MiBlog` con cotejamiento `utf8mb4_spanish_ci`.
2. Configura el archivo `.env` en la raíz de tu proyecto:

```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=MiBlog
DB_USERNAME=root
DB_PASSWORD='abcd1234'

```

---

## 3. Creación de Tabla, Modelo y Controlador

Laravel permite generar toda la estructura de una entidad con un solo comando:

```bash
php artisan make:model Post -a

```

> **Significado de los flags:**
> * `-m`: Migración (Base de datos).
> * `-c`: Controlador (Lógica).
> * `-s`: Seeder (Poblado de datos).
> * `-f`: Factory (Generador de datos aleatorios).
> * `-a`: **All** (Crea todos los anteriores).
> 
> 

---

## 4. Modificación de la Migración

Edita el archivo en `database/migrations/xxxx_xx_xx_create_posts_table.php` para definir los campos de la tabla:

```php
public function up(): void
{
    Schema::create('posts', function (Blueprint $table) {
        $table->id();
        $table->string('titulo');
        $table->text('contenido')->nullable();
        $table->string('imagen')->nullable();
        $table->timestamps();
    });
}

```

---

## 5. Creación de Seeds y Factories

### A. Factory (`database/factories/PostFactory.php`)

Define cómo se ven los datos falsos:

```php
public function definition(): array
{
    return [
        'titulo' => $this->faker->sentence(),
        'contenido' => $this->faker->paragraph(),
        'imagen' => $this->faker->imageUrl(640, 480),
    ];
}

```

### B. Seeder (`database/seeders/PostSeeder.php`)

Define cuántos registros crear:

```php
use App\Models\Post;

public function run(): void
{
    Post::factory(20)->create();
}

```

### C. Ejecución general

Registra el seeder en `database/seeders/DatabaseSeeder.php`:

```php
public function run(): void
{
    $this->call(PostSeeder::class);
}

```

Finalmente, ejecuta la migración y el poblado:

```bash
php artisan migrate:fresh --seed

```

---

## 6. Creación de las Rutas

Define los puntos de entrada en `routes/web.php`:

```php
use App\Http\Controllers\PostController;
use Illuminate\Support\Facades\Route;

Route::get('/', [PostController::class, 'index'])->name('posts.index');
Route::get('/posts/{id}', [PostController::class, 'show'])->name('posts.show');

```
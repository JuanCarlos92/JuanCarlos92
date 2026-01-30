# Cheat Sheet de Comandos Laravel

============================================================

## 1. Instalar PHP, Composer y el instalador de Laravel

```bash
/bin/bash -c "$(curl -fsSL https://php.new/install/linux/8.4)"
```

## 2. Crear una aplicación Laravel

```bash
composer create-project laravel/laravel nombreDeMiApp
```

## 3. Ir a la carpeta de la aplicación

```bash
cd nombreDeMiApp
```

## 4. Lanzar el servidor de desarrollo

```bash
php artisan serve
```

============================================================

## 5. Configuración de Base de Datos (Archivo .env)

Antes de conectar, crea la base de datos (ej. `MiBlog`) con tipo `utf8mb4_spanish_ci2`. Modifica estas líneas en el archivo `.env`:

```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=MiBlog
DB_USERNAME=root
DB_PASSWORD='abcd1234'

```

## 6. Generación de Componentes (Modelo, Migración, Controlador)

El flag `-a` (all) crea modelo, migración, controlador, seeder y factory simultáneamente.

```bash
php artisan make:model Post -a

```

* 
**-c**: crear controlador 


* 
**-s**: crear seeder 


* 
**-f**: crear factory 


## 7. Definición de Esquema (Migración)

Ejemplo de estructura en `database/migrations/xxxx_xx_xx_create_posts_table.php`:

```php
Schema::create('posts', function (Blueprint $table) {
    $table->id();
    $table->string('titulo');
    $table->text('contenido')->nullable();
    $table->string('imagen')->nullable();
    $table->timestamps();
});

```

## 8. Poblado de Datos (Factories y Seeders)

Ejemplo de Factory (`PostFactory.php`):

```php
public function definition() {
    return [
        'titulo' => $this->faker->sentence(),
        'contenido' => $this->faker->paragraph(),
        'imagen' => $this->faker->imageUrl(640, 480),
    ];
}

```

Ejemplo de Seeder (`PostSeeder.php`):

```php
use App\Models\Post;

public function run() {
    Post::factory(20)->create(); // Genera 20 posts de ejemplo
}

```

Ejecución de Migraciones y Seeders:

```bash
php artisan migrate:fresh --seed

```

9. Definición de Rutas (`routes/web.php`) 

```php
use App\Http\Controllers\PostController;

Route::get('/', [PostController::class, 'index'])->name('posts.index');
Route::get('/posts/{id}', [PostController::class, 'show'])->name('posts.show');

```

10. Gestión de Usuarios (Laravel Breeze) 

```bash
# [cite_start]1. Instalar paquete Breeze [cite: 109]
composer require laravel/breeze --dev

# [cite_start]2. Instalar plantilla (Ojo: sobreescribe web.php) [cite: 113, 115]
php artisan breeze:install

# [cite_start]3. Ejecutar migraciones de usuario [cite: 123]
php artisan migrate

# [cite_start]4. Instalar y compilar dependencias frontend [cite: 128, 137]
npm install
npm run dev

```



```

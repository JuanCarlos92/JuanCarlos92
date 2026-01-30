# Guía de Instalación de Laravel

**Fuente oficial:** [Laravel Docs 11.x](https://laravel.com/docs/11.x/installation)

---

### 1. Instalar PHP, Composer y el instalador de Laravel
Ejecuta el siguiente comando para preparar tu entorno de desarrollo (específico para Linux con PHP 8.4):

```bash
/bin/bash -c "$(curl -fsSL [https://php.new/install/linux/8.4](https://php.new/install/linux/8.4))"

```

---

### 2. Crear una nueva aplicación

Utiliza Composer para generar un nuevo proyecto basado en el esqueleto oficial de Laravel:

```bash
composer create-project laravel/laravel nombreDeMiApp

```

---

### 3. Acceder al directorio del proyecto

Una vez finalizada la instalación, muévete a la carpeta que se acaba de crear:

```bash
cd nombreDeMiApp

```

---

### 4. Lanzar el servidor de desarrollo

Para poner en marcha tu aplicación localmente, ejecuta el servidor integrado de Artisan:

```bash
php artisan serve

```

> **Nota:** Por defecto, podrás ver tu aplicación en `http://127.0.0.1:8000`.

```

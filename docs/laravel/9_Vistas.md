## Vistas (`/resources/views`)

Hasta ahora, los controladores solo devolvían cadenas de texto simples. Sin embargo, el cometido de un controlador no es contener código HTML. Para mostrar contenido visual estructurado, utilizamos las **Vistas**.

Las vistas son archivos HTML (con extensión `.php` o `.blade.php`) que se encargan de presentar la información al usuario. En Laravel, se almacenan en la carpeta `resources/views`.

---

### Organización de las Vistas

Para este proyecto, se ha decidido organizar las vistas siguiendo la estructura de los métodos de los controladores:

* `resources/views/`
    * `home.php`
    * `2DAW/`
        * `daw.php`
        * `profesor.php`
        * `modulo.php`
        * `alumno.php`

---

### Mi primera Vista: `home.php`

Creamos el archivo `resources/views/home.php` con la estructura base de HTML y el mensaje que antes estaba en el controlador:

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Hola Crack,</h1><br> bienvenido a Laravel!!. <br>
    <strong>trabajando desde las vistas.</strong>
</body>
</html>

```

**Modificación en `HomeController.php`:**
Ahora el controlador simplemente invoca la vista mediante la función `view()`:

```php
public function __invoke(){
    return view('home');
}

```

---

### Vistas en Subcarpetas: `2DAW/daw.php`

Cuando una vista está dentro de una carpeta, se utiliza la **notación de punto** para llamarla desde el controlador.

**En `DawController.php`:**

```php
public function index(){
    return view("2DAW.daw");
}

```

*Donde "2DAW" es la carpeta y "daw" es el archivo `daw.php`.*

---

### Vista `2DAW/profesor.php`

Se sigue el mismo proceso:

1. Cortar el texto del método `profesor` en el controlador.
2. Pegarlo en el `<body>` de la nueva vista.
3. En el controlador, retornar la vista: `return view("2DAW.profesor");`.

---

### 🧬 Vistas con variables: `2DAW/modulo.php`

Para pasar datos desde el controlador a la vista, usamos un **array asociativo** como segundo parámetro de la función `view`.

**En `DawController.php`:**

```php
public function modulo($modulo){
    return view('2DAW.modulo', ['modulo' => $modulo]);
}

```

**En la vista `2DAW/modulo.php`:**
Usamos etiquetas de PHP para imprimir la variable recibida:

```html
<p>Hola Crack!. Bienvenido al módulo: <?php echo $modulo; ?></p>

```

---

### 🎓 Vista `2DAW/alumno.php`

Para pasar múltiples variables, simplemente las añadimos al array asociativo.

**En el controlador:**

```php
public function alumno($modulo, $alumno, $nota = null){
    return view("2DAW.alumno", [
        "alumno" => $alumno,
        "nota"   => $nota,
        "modulo" => $modulo
    ]);
}

```

**En la vista `2DAW/alumno.php`:**
Cambiamos la lógica que antes estaba en el controlador por código PHP embebido en el HTML:

```php
<?php if(empty($nota)): ?>
    <h1>Hola usuario <?php echo $alumno; ?>.</h1>
<?php else: ?>
    <p>El usuario <h1><?php echo $alumno; ?></h1> ha sacado un <?php echo $nota; ?> en el módulo <?php echo $modulo; ?>.</p>
<?php endif; ?>

```

---

### Resumen de envío de datos

La sintaxis general es:
`return view('nombre_vista', ['variable_en_vista' => $valor_local]);`

```

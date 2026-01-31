# Comandos básicos de Angular CLI

Angular CLI (`ng`) es la herramienta oficial para crear, desarrollar y mantener aplicaciones Angular.

---

## Crear un nuevo proyecto

Crear un nuevo proyecto Angular:

```bash
ng new nombre-proyecto
```

Crear un proyecto sin instalar dependencias automáticamente:

```bash
ng new nombre-proyecto --skip-install
```

---

## Servidor de desarrollo

Levantar el servidor de desarrollo:

```bash
ng serve
```

Levantar el servidor y abrir el navegador automáticamente:

```bash
ng serve --open
```

Cambiar el puerto por defecto:

```bash
ng serve --port 4201
```

Modo producción:

```bash
ng serve --configuration production
```

---

## Construcción del proyecto

Construir el proyecto:

```bash
ng build
```

Construcción para producción:

```bash
ng build --configuration production
```

Indicar carpeta de salida:

```bash
ng build --output-path dist
```

---

## Ayuda

Mostrar ayuda general:

```bash
ng help
```

Ayuda para un comando específico:

```bash
ng help build
```

---

## Generación de código (Scaffolding)

Generar un componente:

```bash
ng generate component nombre-componente
```

Versión corta:

```bash
ng g c nombre-componente
```

Generar un servicio:

```bash
ng generate service nombre-servicio
```

Generar un módulo:

```bash
ng generate module nombre-modulo
```

Generar una clase:

```bash
ng generate class nombre-clase
```

Generar una interfaz:

```bash
ng generate interface nombre-interfaz
```

Generar un enum:

```bash
ng generate enum nombre-enum
```

Generar un pipe:

```bash
ng generate pipe nombre-pipe
```

Generar una directiva:

```bash
ng generate directive nombre-directiva
```

Generar un guard:

```bash
ng generate guard nombre-guard
```

---

## Actualización del proyecto

Actualizar Angular y dependencias:

```bash
ng update
```

Actualizar Angular core y CLI:

```bash
ng update @angular/core @angular/cli
```

---

## Tests

Ejecutar tests unitarios:

```bash
ng test
```

Ejecutar tests en modo headless:

```bash
ng test --watch=false
```

---

## Otros comandos útiles

Mostrar versión de Angular:

```bash
ng version
```

Limpiar caché:

```bash
ng cache clean
```

Analizar el bundle:

```bash
ng build --stats-json
```

---

## Notas

* Angular CLI requiere **Node.js y npm**.
* Todos los comandos `ng generate` tienen forma corta `ng g`.
* Se recomienda usar siempre la versión LTS de Node.js.

# Comandos básicos de Ionic CLI

Ionic CLI es la herramienta oficial para crear, desarrollar y mantener aplicaciones Ionic.

---

## Crear un nuevo proyecto

Crear un proyecto Ionic:

```bash
ionic start nombre-proyecto
```

Seleccionar tipo de proyecto (Angular, React, Vue, etc.):

```bash
ionic start nombre-proyecto blank --type=angular
```

---

## Servidor de desarrollo

Levantar servidor de desarrollo:

```bash
ionic serve
```

Levantar servidor con host externo (para pruebas en dispositivos móviles):

```bash
ionic serve --external
```

---

## Construcción del proyecto

Construir proyecto para producción:

```bash
ionic build
```

---

## Ayuda y dispositivos

Mostrar ayuda general:

```bash
ionic help
```

Listar dispositivos conectados:

```bash
ionic capacitor devices
```

---

## Capacitor - Integración nativa

Agregar plataforma Android:

```bash
ionic cap add android
```

Sincronizar cambios de Ionic a plataformas nativas:

```bash
ionic cap sync
```

Ejecutar la app en dispositivo/emulador Android (externo para pruebas en LAN):

```bash
ionic cap run android --external
```

---

## Información del entorno y diagnóstico

Información del entorno:

```bash
ionic info
```

Verificar problemas con la instalación y configuración:

```bash
ionic doctor check
```

Intentar corregir problemas detectados:

```bash
ionic doctor fix
```

---

## Notas

* Ionic CLI requiere **Node.js y npm**.
* Capacitor es la forma oficial de acceder a funcionalidades nativas en Ionic.
* Siempre es recomendable ejecutar `ionic doctor check` antes de pruebas en dispositivos reales.

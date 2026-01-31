# Comandos básicos de NPM

Este documento recoge los comandos más habituales de **NPM (Node Package Manager)** para la gestión y ejecución de proyectos JavaScript.

---

## Instalación de dependencias

Instala todas las dependencias definidas en el archivo `package.json`:
```bash
npm install
```

---

## Ejecución de scripts

Ejecuta el script de compilación del proyecto:
```bash
npm run build
```

Ejecuta el proyecto en modo desarrollo:
```bash
npm run dev
```

Inicia la aplicación:
```bash
npm start
```

Ejecuta los tests del proyecto:
```bash
npm test
```

Ejecuta el script de expulsión de configuración:
```bash
npm run eject
```

---

## Gestión del proyecto

Muestra la ayuda oficial de NPM:
```bash
npm help
```

Actualiza las dependencias del proyecto:
```bash
npm update
```

Reinicia la aplicación (si está definido en los scripts):
```bash
npm restart
```

Detiene la ejecución de la aplicación:
```bash
Ctrl + C
```

---

## Creación de proyectos

Crea un nuevo proyecto usando Vite con la última versión disponible:
```bash
npm create vite@latest
```

---

## Resumen rápido

| Comando | Descripción |
|------|-----------|
| `npm install` | Instala dependencias |
| `npm run build` | Compila el proyecto |
| `npm run dev` | Ejecuta en modo desarrollo |
| `npm start` | Inicia la aplicación |
| `npm test` | Ejecuta tests |
| `npm update` | Actualiza dependencias |
| `npm restart` | Reinicia la app |
| `npm help` | Muestra ayuda |
| `npm run eject` | Expulsa configuración |
| `npm create vite@latest` | Crea proyecto con Vite |

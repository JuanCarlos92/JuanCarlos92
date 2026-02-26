# Comandos básicos de Firebase CLI

Firebase CLI (`firebase`) es la herramienta oficial para configurar,
administrar y desplegar aplicaciones en Firebase.

------------------------------------------------------------------------

## Instalación de Firebase CLI

Instalar Firebase CLI globalmente:

``` bash
npm install -g firebase-tools
```

Verificar instalación:

``` bash
firebase --version
```

Actualizar Firebase CLI:

``` bash
npm install -g firebase-tools@latest
```

------------------------------------------------------------------------

## Autenticación

Iniciar sesión en Firebase:

``` bash
firebase login
```

Cerrar sesión:

``` bash
firebase logout
```

Ver usuario actual:

``` bash
firebase login:list
```

Cambiar cuenta:

``` bash
firebase login --reauth
```

------------------------------------------------------------------------

## Inicialización del proyecto

Inicializar Firebase en el proyecto actual:

``` bash
firebase init
```

Inicializar solo Hosting:

``` bash
firebase init hosting
```

Inicializar solo Firestore:

``` bash
firebase init firestore
```

Inicializar solo Functions:

``` bash
firebase init functions
```

Inicializar solo Authentication:

``` bash
firebase init auth
```

Inicializar solo Storage:

``` bash
firebase init storage
```

------------------------------------------------------------------------

## Selección de proyecto

Listar proyectos disponibles:

``` bash
firebase projects:list
```

Usar un proyecto específico:

``` bash
firebase use nombre-proyecto
```

Mostrar proyecto actual:

``` bash
firebase use
```

Agregar alias a un proyecto:

``` bash
firebase use --add
```

------------------------------------------------------------------------

## Deploy

Desplegar todo:

``` bash
firebase deploy
```

Desplegar solo Hosting:

``` bash
firebase deploy --only hosting
```

Desplegar solo Functions:

``` bash
firebase deploy --only functions
```

Desplegar solo Firestore:

``` bash
firebase deploy --only firestore
```

Desplegar solo Storage:

``` bash
firebase deploy --only storage
```

Desplegar solo una función específica:

``` bash
firebase deploy --only functions:nombreFuncion
```

------------------------------------------------------------------------

## Servidor local (Emulador)

Iniciar emuladores:

``` bash
firebase emulators:start
```

Iniciar solo Hosting:

``` bash
firebase emulators:start --only hosting
```

Iniciar solo Functions:

``` bash
firebase emulators:start --only functions
```

Iniciar solo Firestore:

``` bash
firebase emulators:start --only firestore
```

Exportar datos del emulador:

``` bash
firebase emulators:export ./backup
```

Importar datos al emulador:

``` bash
firebase emulators:start --import ./backup
```

------------------------------------------------------------------------

## Hosting

Desplegar Hosting:

``` bash
firebase deploy --only hosting
```

Ver canales de hosting:

``` bash
firebase hosting:channel:list
```

Crear canal de preview:

``` bash
firebase hosting:channel:deploy nombre-canal
```

Eliminar canal:

``` bash
firebase hosting:channel:delete nombre-canal
```

------------------------------------------------------------------------

## Functions

Ver funciones:

``` bash
firebase functions:list
```

Ver logs de funciones:

``` bash
firebase functions:log
```

Ver logs en tiempo real:

``` bash
firebase functions:log --follow
```

Eliminar función:

``` bash
firebase functions:delete nombreFuncion
```

------------------------------------------------------------------------

## Firestore

Ver reglas actuales:

``` bash
firebase firestore:rules:get
```

Desplegar reglas:

``` bash
firebase deploy --only firestore:rules
```

Desplegar índices:

``` bash
firebase deploy --only firestore:indexes
```

------------------------------------------------------------------------

## Storage

Desplegar reglas de Storage:

``` bash
firebase deploy --only storage
```

------------------------------------------------------------------------

## Configuración

Ver configuración actual:

``` bash
firebase apps:list
```

Obtener configuración del proyecto:

``` bash
firebase apps:sdkconfig
```

------------------------------------------------------------------------

## Otros comandos útiles

Mostrar ayuda:

``` bash
firebase help
```

Mostrar ayuda de un comando específico:

``` bash
firebase help deploy
```

Mostrar versión:

``` bash
firebase --version
```

------------------------------------------------------------------------

## Notas

-   Firebase CLI requiere Node.js y npm.
-   Es necesario iniciar sesión con una cuenta de Google.
-   El comando `firebase init` crea el archivo `firebase.json`.
-   El comando `firebase deploy` publica la aplicación en Firebase.
-   Firebase Hosting es ideal para aplicaciones Angular, React y web
    estática.

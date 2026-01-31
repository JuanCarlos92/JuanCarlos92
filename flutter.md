# Comandos básicos de Flutter CLI

Flutter CLI es la herramienta oficial para crear, desarrollar y mantener aplicaciones Flutter.

---

## Crear un nuevo proyecto

Crear un proyecto Flutter:

```bash
flutter create nombre_proyecto
```

---

## Ejecutar la aplicación

Ejecutar la app en un dispositivo/emulador conectado:

```bash
flutter run
```

Ejecutar en modo debug:

```bash
flutter run --debug
```

Ejecutar en modo profile:

```bash
flutter run --profile
```

Ejecutar en modo release:

```bash
flutter run --release
```

Listar dispositivos disponibles:

```bash
flutter devices
```

Seleccionar un dispositivo específico:

```bash
flutter run -d <device_id>
```

---

## Gestión de paquetes

Obtener paquetes listados en pubspec.yaml:

```bash
flutter pub get
```

Actualizar paquetes a sus últimas versiones:

```bash
flutter pub upgrade
```

Ver paquetes desactualizados:

```bash
flutter pub outdated
```

Reparar la caché de paquetes:

```bash
flutter pub cache repair
```

---

## Información y versión

Ver la versión de Flutter:

```bash
flutter --version
```

Comprobar instalación y entorno de Flutter:

```bash
flutter doctor
```

Ver información detallada del proyecto:

```bash
flutter info
```

---

## Construcción de la aplicación

Construir APK para Android:

```bash
flutter build apk
```

Construir App Bundle para Android:

```bash
flutter build appbundle
```

Construir para iOS:

```bash
flutter build ios
```

Construir para web:

```bash
flutter build web
```

Construir para Windows:

```bash
flutter build windows
```

Construir para macOS:

```bash
flutter build macos
```

Construir para Linux:

```bash
flutter build linux
```

Limpiar la carpeta de construcción:

```bash
flutter clean
```

Actualizar Flutter y dependencias:

```bash
flutter upgrade
```

---

## Depuración y tests

Ejecutar tests unitarios:

```bash
flutter test
```

Ejecutar linter:

```bash
flutter analyze
```

Ejecutar build con observación de cambios (hot reload/hot restart):

```bash
flutter run --hot
```

---

## Notas

* Flutter requiere **SDK de Flutter**, **Dart**, y dispositivos/emuladores para pruebas.
* Es recomendable ejecutar `flutter doctor` antes de iniciar desarrollo para verificar configuración y dependencias.

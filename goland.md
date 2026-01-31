# Comandos básicos de Go

Este archivo contiene los comandos esenciales para trabajar con el lenguaje de programación Go.

---

## Inicialización y gestión de módulos

Inicializar un proyecto con Go Modules:

```bash
go mod init nombre_proyecto
```

Ver la configuración del entorno de Go:

```bash
go env
```

Obtener ayuda de Go:

```bash
go help
```

Ver la versión de Go instalada:

```bash
go version
```

Agregar dependencias necesarias automáticamente y limpiar el `go.mod`:

```bash
go mod tidy
```

Descargar todas las dependencias del módulo:

```bash
go mod download
```

Instalar un paquete específico:

```bash
go get <paquete>
```

Listar todos los paquetes del módulo:

```bash
go list -m all
```

---

## Compilación y ejecución

Ejecutar un archivo Go específico:

```bash
go run archivo.go
```

Ejecutar todos los archivos del módulo actual:

```bash
go run .
```

Compilar un archivo o módulo:

```bash
go build
```

Instalar el ejecutable en el `GOPATH/bin`:

```bash
go install
```

Ejecutar tests:

```bash
go
```

# Comandos básicos de Maven (mvn)

Maven es una herramienta de gestión y construcción de proyectos Java. A continuación se muestran los comandos más utilizados.

## Comandos básicos

### mvn clean
Elimina el directorio `target`, donde se generan los archivos compilados.
```bash
mvn clean
```

### mvn compile
Compila el código fuente del proyecto.
```bash
mvn compile
```

### mvn test
Ejecuta los tests del proyecto.
```bash
mvn test
```

### mvn package
Compila el proyecto y genera el archivo empaquetado (JAR o WAR).
```bash
mvn package
```

### mvn install
Compila, testea y copia el artefacto al repositorio local.
```bash
mvn install
```

### mvn clean install
Limpia el proyecto y lo construye completamente desde cero.
```bash
mvn clean install
```

### mvn validate
Verifica que el proyecto es correcto y que tiene toda la información necesaria.
```bash
mvn validate
```

### mvn verify
Ejecuta comprobaciones de calidad adicionales después de los tests.
```bash
mvn verify
```

### mvn deploy
Copia el artefacto final a un repositorio remoto.
```bash
mvn deploy
```

## Información y ayuda

### mvn help
Muestra la ayuda general de Maven.
```bash
mvn help
```

### mvn help:describe
Describe un plugin o un objetivo concreto.
```bash
mvn help:describe -Dplugin=compiler
```

### mvn -version
Muestra la versión de Maven instalada.
```bash
mvn -version
```

## Gestión de dependencias

### mvn dependency:tree
Muestra el árbol de dependencias del proyecto.
```bash
mvn dependency:tree
```

### mvn dependency:list
Lista todas las dependencias del proyecto.
```bash
mvn dependency:list
```

## Ejecución de aplicaciones

### mvn spring-boot:run
Ejecuta una aplicación Spring Boot.
```bash
mvn spring-boot:run
```

## Otros comandos útiles

### mvn clean package -DskipTests
Compila el proyecto sin ejecutar los tests.
```bash
mvn clean package -DskipTests
```

### mvn site
Genera la documentación del proyecto.
```bash
mvn site
```

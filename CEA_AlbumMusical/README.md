## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Documentación técnica del dominio – CEA Álbum Musical

## 1. Descripción general

El paquete `domain` contiene la lógica central del sistema de administración de una tienda de música, cuyo propósito es gestionar el catálogo musical y las existencias actuales de los productos.

En esta capa se definen las entidades del negocio, las reglas que deben cumplirse, los objetos de valor, los agregados y los servicios que permiten ejecutar operaciones propias del dominio.

Su implementación se realiza utilizando Java puro, sin depender de frameworks, bases de datos ni componentes externos. Esto permite que las reglas del negocio se mantengan independientes de la tecnología utilizada en las demás capas del proyecto.

## 2. Estructura del paquete

La organización actual del paquete `domain` es la siguiente:

```text
domain/
├── model/
│   ├── aggregate/
│   │   ├── ObraMusical.java
│   │   └── Inventario.java
│   │
│   ├── entity/
│   │   ├── Artista.java
│   │   ├── Pista.java
│   │   ├── Edicion.java
│   │   ├── CompaniaDiscografica.java
│   │   ├── CD.java
│   │   ├── Coleccion.java
│   │   └── DerechoMusical.java
│   │
│   └── valueobject/
│       ├── Precio.java
│       ├── Duracion.java
│       ├── CodigoBarras.java
│       ├── Cantidad.java
│       ├── AnioPublicacion.java
│       └── NumeroCatalogo.java
│
├── service/
│   ├── CalculoValorInventarioService.java
│   └── DisponibilidadCDService.java
│
├── specification/
│   ├── Specification.java
│   └── ProductoDisponibleSpecification.java
│
├── event/
│   ├── DomainEvent.java
│   ├── ObraMusicalRegistrada.java
│   └── ExistenciasActualizadas.java
│
├── exception/
│   ├── DomainException.java
│   ├── InvalidPriceException.java
│   ├── InvalidQuantityException.java
│   ├── InvalidTrackException.java
│   ├── InvalidMusicalWorkException.java
│   └── InventoryMismatchException.java
│
└── factory/
    └── ObraMusicalFactory.java
```

## 3. Descripción de los paquetes

### 3.1. model

Contiene los elementos que representan los conceptos principales del negocio. Se divide en tres subpaquetes:

- **aggregate:** contiene las raíces de agregado que controlan la consistencia de los objetos que pertenecen a cada agregado. `ObraMusical` administra la información y las pistas asociadas a una obra musical, mientras que `Inventario` controla las existencias actuales de un CD.

- **entity:** contiene las entidades que representan los elementos del catálogo musical, como artistas, pistas, ediciones, compañías discográficas, CD, colecciones y derechos musicales. Estas clases poseen identidad y representan objetos del dominio.

- **valueobject:** contiene objetos inmutables que representan valores específicos del negocio. Por ejemplo, `Precio` controla el valor monetario y su moneda; `Duracion` representa la duración de una pista; `CodigoBarras` valida el formato del código y `Cantidad` controla que las existencias no sean negativas.

### 3.2. service

Contiene servicios de dominio que implementan operaciones y reglas que involucran más de una entidad o agregado.

- `CalculoValorInventarioService`: calcula el valor total de las existencias de un CD a partir de su precio y cantidad disponible.
- `DisponibilidadCDService`: verifica si existe una cantidad suficiente de unidades de un CD en el inventario.

### 3.3. specification

Contiene las especificaciones utilizadas para representar y evaluar condiciones del negocio.

- `Specification`: define la interfaz general para evaluar si un objeto cumple una condición.
- `ProductoDisponibleSpecification`: comprueba si la cantidad disponible de un producto es suficiente para una cantidad requerida.

### 3.4. event

Contiene los eventos de dominio que representan situaciones relevantes ocurridas dentro del sistema.

- `DomainEvent`: define la estructura común de los eventos del dominio.
- `ObraMusicalRegistrada`: representa el registro de una nueva obra musical.
- `ExistenciasActualizadas`: representa un cambio en la cantidad actual de existencias de un CD.

Estos eventos permiten que otras capas conozcan los cambios importantes del dominio sin que los agregados tengan que comunicarse directamente con la infraestructura.

### 3.5. exception

Contiene las excepciones específicas utilizadas para informar situaciones que incumplen las reglas del negocio.

- `DomainException`: clase base para las excepciones propias del dominio.
- `InvalidPriceException`: indica que un precio no cumple las condiciones establecidas.
- `InvalidQuantityException`: representa una cantidad inválida.
- `InvalidTrackException`: identifica errores relacionados con las pistas musicales.
- `InvalidMusicalWorkException`: informa problemas en los datos de una obra musical.
- `InventoryMismatchException`: indica que el CD y el inventario relacionados no corresponden entre sí.

### 3.6. factory

Contiene las fábricas encargadas de centralizar la creación de objetos complejos del dominio.

- `ObraMusicalFactory`: permite crear una obra musical, generando su identificador y construyendo los objetos necesarios para su inicialización.

## 4. Reglas de negocio implementadas

Dentro del paquete `domain` se aplican diferentes validaciones para proteger la integridad de la información:

- Una obra musical debe contar con información válida y no puede tener dos pistas con el mismo número.
- La duración de una pista debe ser mayor que cero.
- El precio no puede ser negativo y debe manejar una moneda válida.
- Las cantidades de inventario no pueden ser negativas.
- El código de barras debe cumplir con uno de los formatos numéricos admitidos.
- El año de publicación debe ser válido y no puede superar el año actual.
- El inventario debe estar relacionado con el CD correspondiente.
- La disponibilidad de un CD se determina a partir de sus existencias actuales.

Las existencias se pueden actualizar mediante una operación administrativa. El sistema registra el evento de dominio correspondiente cuando cambia la cantidad, pero no contempla registros individuales de entradas o salidas de productos.

## 5. Patrones de diseño utilizados

En el dominio se implementaron tres patrones de diseño:

- **Factory:** utilizado mediante `ObraMusicalFactory` para centralizar la creación de obras musicales y evitar distribuir esa responsabilidad entre diferentes clases.
- **Specification:** aplicado para representar condiciones de disponibilidad de productos de manera independiente y reutilizable.
- **Domain Service:** implementado mediante servicios como `CalculoValorInventarioService` y `DisponibilidadCDService`, que contienen reglas de negocio que involucran varios objetos.

Estos patrones ayudan a organizar la lógica del negocio, facilitan su mantenimiento y evitan concentrar todas las responsabilidades en una sola clase.

## 6. Independencia del dominio

El paquete `domain` está desarrollado sin depender de frameworks, bases de datos o herramientas de infraestructura. Sus clases utilizan Java y se encargan exclusivamente de representar los conceptos y las reglas del negocio.

Esta organización sigue el principio de que las dependencias deben dirigirse hacia el dominio y no al contrario. De esta manera, los componentes de aplicación e infraestructura podrán utilizar las clases del dominio sin que este tenga que conocer cómo se almacenan los datos o cómo se ejecutan las operaciones externas.

## 7. Alcance del dominio

El dominio desarrollado contempla la administración del catálogo musical y la consulta y actualización de las existencias actuales de los productos de la tienda.

No incluye funcionalidades de gestión de clientes, ventas, facturación ni control de movimientos individuales de entrada y salida de productos, ya que estos procesos se encuentran fuera del alcance definido para el proyecto.

## 8. Compilación del proyecto

El proyecto se desarrolla en Java sin utilizar herramientas de construcción como Maven o Gradle. Para compilar los archivos desde la terminal de PowerShell, ubicándose en la carpeta raíz del proyecto, se puede ejecutar:

```powershell
javac -d bin -sourcepath src/main/java (Get-ChildItem src/main/java -Recurse -Filter *.java).FullName
```

Si la compilación termina sin mostrar errores, significa que las clases del proyecto fueron compiladas correctamente.
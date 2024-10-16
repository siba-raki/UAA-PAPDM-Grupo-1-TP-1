# Gestión de Productos - Android App

## Descripción
Esta es una aplicación Android desarrollada con **Kotlin** y **Jetpack Compose** que permite gestionar el registro de productos destinados a la venta. Los usuarios pueden crear productos con información detallada (nombre, descripción, marca, precio, existencia, y URL de imagen) y visualizarlos en una lista. La aplicación soporta modos de tema **claro** y **oscuro** que se pueden alternar mediante un botón tipo **switch**.

## Características
- **Registro de productos**: Permite agregar productos con los siguientes campos: Nombre, Descripción, Marca, Precio, Existencia (stock) e Imagen (URL).
- **Visualización de productos**: Los productos registrados se muestran en una lista utilizando `LazyColumn`.
- **Visualización de imágenes**: Las imágenes de los productos se cargan a partir de URLs proporcionadas por el usuario.
- **Eliminación de productos**: Los productos pueden ser eliminados desde la lista de productos.
- **Soporte para tema claro y oscuro**: El usuario puede alternar entre los modos claro y oscuro mediante un switch en la barra superior.

## Estructura del Proyecto
El proyecto está organizado en varios paquetes y archivos clave:

### 1. `MainActivity.kt`
La actividad principal que inicializa la UI de la aplicación. Envuelve el componente de navegación dentro del tema seleccionado (claro u oscuro).
  
### 2. `navigation/NavigationComponent.kt`
Contiene la navegación de la aplicación usando `NavHost`. Gestiona las pantallas del formulario de creación de productos y el listado de productos. También incluye un **switch** en la barra superior para cambiar entre el tema claro y oscuro.

### 3. `screens/ProductFormScreen.kt`
Define la pantalla del formulario para agregar nuevos productos. El formulario incluye validaciones de entrada, como asegurarse de que la URL de la imagen sea válida.

### 4. `screens/ProductListScreen.kt`
Define la pantalla que muestra la lista de productos registrados en un `LazyColumn`. Cada producto se presenta en un `LazyRow` y tiene un botón de eliminación que permite eliminar productos individuales de la lista.

### 5. `models/Product.kt`
Define la estructura de datos del modelo `Product`, que contiene los campos para nombre, descripción, marca, precio, cantidad en stock y URL de la imagen.

### 6. `ui/theme/`
Contiene los archivos relacionados con la personalización del tema de la aplicación (claro y oscuro). El archivo `AppTheme.kt` maneja los colores y las tipografías de acuerdo con el modo (claro/oscuro).

## Instrucciones de Instalación

### 1. Clona el repositorio
Primero, clona el repositorio en tu máquina local:
```
git clone https://github.com/siba-raki/UAA-PAPDM-Grupo-1-TP-1.git
```

### 2. Abre el proyecto en Android Studio
Abre **Android Studio** y selecciona la opción **Open an Existing Project**. Luego, navega hasta la carpeta donde clonaste el repositorio y selecciónala.

### 3. Instala las dependencias
Android Studio debería automáticamente instalar todas las dependencias necesarias especificadas en los archivos `build.gradle`.

### 4. Configura los permisos de Internet
Asegúrate de que el proyecto tenga permiso de Internet para cargar imágenes desde URLs. Verifica que el archivo `AndroidManifest.xml` contenga lo siguiente:
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### 5. Ejecuta la aplicación
- Selecciona un dispositivo virtual (AVD) o conecta un dispositivo físico a tu computadora.
- Haz clic en el botón **Run** en Android Studio para compilar y ejecutar la aplicación.

## Uso de la Aplicación
1. En la pantalla principal, puedes elegir entre dos opciones:
   - **Crear producto**: Te llevará a un formulario donde puedes ingresar los detalles de un producto.
   - **Productos**: Te llevará a la lista de productos registrados.
   
2. **Modo claro/oscuro**: En la parte superior de la pantalla, hay un switch que te permite alternar entre el tema claro y el tema oscuro.

3. **Formulario de ingreso de productos**: Ingresa los detalles de un producto, incluyendo una URL de imagen válida.

4. **Lista de productos**: Verás todos los productos registrados. Cada producto muestra su información y un botón para eliminarlo.

## Tecnologías Utilizadas
- **Kotlin**
- **Jetpack Compose**
- **Coil** (para la carga de imágenes desde URL)
- **Material Design 3** (Material You)

## Consideraciones
- Asegúrate de tener conexión a Internet, ya que las imágenes de los productos se cargan desde URLs externas.
- El proyecto requiere Android Studio **Arctic Fox** o superior y Gradle 7.0+.

# Monster Sanctuary - Android Retrofit App 
Una aplicación móvil nativa para Android desarrollada en **Kotlin** que se comunica con un servidor remoto para consumir la API REST de *Monster Sanctuary*. El proyecto utiliza la potente librería **Retrofit 2** para la gestión de peticiones de red asíncronas, mapeo de datos estructurados JSON y visualización interactiva mediante un `RecyclerView` adaptado con un diseño personalizado oscuro (`CardView`).

Este proyecto forma parte de la práctica de **Comunicación con APIs (R8)** de la materia de Tecnologías de la Información.

---

## Características

- **Consumo de API REST:** Conexión asíncrona robusta a un servidor remoto mediante peticiones HTTP GET.
- **Arquitectura Limpia en Kotlin:** Uso de patrones modernos como delegados de inicialización perezosa (`by lazy`) y objetos Singleton.
- **Procesamiento de JSON:** Conversión automática de cadenas JSON complejas a objetos nativos de Kotlin empleando `GsonConverterFactory`.
- **Carga de Imágenes Remotas:** Descarga y almacenamiento en caché eficiente de recursos visuales remotos utilizando la librería **Glide**.
- **Interfaz Gamer Personalizada:** UI moderna adaptada a una temática oscura, implementando bordes redondeados, elevaciones y paleta de colores optimizada en componentes `CardView`.
- **Monitoreo de Red (Logging):** Incorporación de un interceptor de registro HTTP a nivel de cuerpo (`BODY`) para depuración en tiempo real a través del *Logcat*.

---

## Tecnologías y Librerías Utilizadas

El ecosistema técnico del proyecto incluye:

* **Lenguaje:** [Kotlin](https://kotlinlang.org/) (v1.9+)
* **IDE:** [Android Studio](https://developer.android.com/studio)
* **Conexión de Red:** [Retrofit 2](https://square.github.io/retrofit/) (v2.9.0)
* **Mapeo de Datos:** [Gson Converter](https://github.com/google/gson)
* **Cliente HTTP & Logs:** [OkHttp3 & HttpLoggingInterceptor](https://square.github.io/okhttp/)
* **Gestión de Imágenes:** [Glide](https://github.com/bumptech/glide) (v4.12.0)
* **Componentes de UI:** `RecyclerView`, `CardView`, `ConstraintLayout`, `LinearLayout`

* **Nombre Completo:** Angel Gabriel Ortega Arambul*

* **Carrera:** Licenciatura en Tecnologías de la Información

* **Institución:** Centro Universitario de los Valles (CUValles), Universidad de Guadalajara (UDG)
---

## 📂 Estructura del Código Fuente

El proyecto se organiza bajo el paquete principal `ragavi.com.retrofit25`, estructurado de la siguiente manera:
```text
ragavi/com/retrofit25/
│
├── MainActivity.kt          # Actividad principal que inicializa la interfaz y orquesta la petición de red.
├── RetrofitClient.kt        # Objeto Singleton que configura OkHttpClient, interceptores y la instancia de Retrofit.
├── MonsterApiService.kt     # Interfaz de Retrofit que define los endpoints de la API mediante anotaciones HTTP (@GET).
├── Monster.kt               # Data Class (Modelo de datos) que mapea los atributos del JSON del monstruo.
├── MonsterAdapter.kt        # Adaptador del RecyclerView que infla el layout e inserta texto e imágenes con Glide.
│
└── res/layout/
    ├── activity_main.xml    # Contenedor principal de la lista y botón de acción.
    └── item_wine.xml        # Diseño visual (tarjeta con estilo oscuro gaming) para cada ítem de monstruo.

# Prueba técnica Android 2025

# Introducción
La prueba consiste en implementar un buscador de números de Lotería Nacional.

Se tratará de una versión simplificada del que ya funciona en la app.

La idea es que visualmente y funcionalmente sea lo más similar posible al buscador existente de la app. 

# Puntos a implementar
Se proponen los siguientes puntos (en orden de dificultad creciente). No es obligatorio llegar al final, pero cuanto más se consiga, más valoración daremos.

1. Barra de buscadores

2. Buscador por números
  Se facilitan las imágenes de los 10 dígitos para los deslizables

3. Buscador por cantidad de décimos

4. Buscador por cercanía
  Tener en cuenta petición de permisos

Puntos extra: hacer que las peticiones HTTP tengan algún mecanismo de unbouncing u otro tipo de límite para evitar que el backend deje de devolver resultados por hacerse un número excesivo de peticiones en poco tiempo.

# Notas
Se propone que se deduzcan los endpoints y payloads a usar mediante ingeniería inversa de https://web.es.pre.tulotero.net/ , es decir, la versión Web en Pre, en variante Desktop. Ya que en este caso se usan endpoints anónimos (sin autenticación). La versión móvil real usa el endpoint autenticado, pero para esta prueba tiene que funcionar sin autenticación.

Las pantallas deberían parecerse lo más posible a las que hay en la app nativa, pero excuyendo las partes que tapo en rojo:

Por no complicarlo excesivamente, es suficiente que funcione con compileSdk, minSdkVersion y targetSdkVersion 34

Lo que se evaluará principalmente es que el código sea lo más simple y claro posible, aparte de ser correcto y eficiente.

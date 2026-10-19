Práctica de Métodos Numéricos en Java: Jacobi y Gauss-Seidel

Descripción

Este proyecto resuelve un sistema de tres ecuaciones lineales utilizando los métodos iterativos de Jacobi y Gauss-Seidel. Fue desarrollado en Java con una arquitectura modular de tres clases.

Sistema de ecuaciones

- 5x + y + z = 7
- x + 4y + z = 6
- x + 2y + 5z = 8

Estructura del proyecto

- "Sistema.java": almacena la matriz de coeficientes, los términos independientes, los valores iniciales y la tolerancia.
- "MetodosIterativos.java": contiene los algoritmos de Jacobi y Gauss-Seidel.
- "Main.java": ejecuta los métodos y muestra los resultados.

Parámetros

- Valores iniciales: x = 0, y = 0, z = 0.
- Tolerancia: 0.0001.
- Máximo de iteraciones: 10000.

Resultados

Con el criterio de paro basado en el máximo cambio entre iteraciones consecutivas, los resultados esperados son:

Método| Iteraciones
Jacobi| 16
Gauss-Seidel| 6

La solución exacta del sistema es x = 1, y = 1, z = 1. Los métodos obtienen aproximaciones cercanas a esos valores.

Cómo ejecutar el programa

1. Abre el proyecto en IntelliJ IDEA.
2. Verifica que tengas configurado un JDK.
3. Abre "src/Main.java".
4. Pulsa el botón verde de ejecución junto al método "main".
5. Consulta los resultados en la consola.

También se puede compilar desde una terminal abierta en la carpeta principal del proyecto:

javac -d out src/Sistema.java src/MetodosIterativos.java src/Main.java
java -cp out Main

Conclusión

En este sistema, Gauss-Seidel necesitó menos iteraciones que Jacobi para cumplir el criterio de paro establecido. Esto se debe a que Gauss-Seidel utiliza inmediatamente los valores recién calculados. El número de iteraciones puede cambiar si se modifica el sistema, la aproximación inicial o la tolerancia.

Autora

Nombre: Yajahira Germayoni Aguilar Hernandez

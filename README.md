Para que funcione correctamente este extraclase, es necesario tener docker instalado.

Se deben tener 2 containers, uno de la base de datos (en el caso de esta tarea debe ser Microsoft SQL) y 
otro container con el artefacto de este server, lo pueden compilar en IntelliJ dandole a File, Project Structure,
Artifacts, Add, Web Application: Archive. Seguidamente se debe dar en Build, Build Artifacts y se selecciona.

En el caso de esta tarea ademas en la base de datos, se debe tener una base de datos llamada Lapiceros y luego dentro
de ella crear una tabla que se llame Productos, ahi debe tener LapicerosId, Marca y Precio como columnas.

Para la creacion del contenedor de mssql (la base de datos) solo se debe hacer un pull, se le deben asignar los puertos
1433:1433. Para la creacion del Rest-Api es necesario colocarle el archivo .war creado al contenedor, ya sea por 
dockerfile o por linea de comandos, en caso de que se haga por dockerfile asegurar que la imagen se llame app,
sino modificar el codigo.
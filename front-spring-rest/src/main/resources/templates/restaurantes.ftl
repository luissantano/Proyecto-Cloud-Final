<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurantes</title>
</head>
<body>

    <table width="100%"class="nombre">
        <tr>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Direccion</th>
            <th>Telefono</th>
        </tr>
    </table>
<script
        src="http://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous">

</script>
<tr>
    <script>
        $(document).ready(function () {
            console.log($("#myTitle").html());
            $.get("/rest/api/restaurantes", function (data) {
                console.log(data);
                var contentHtml = "<h2>Nombre</h2>";
                $.each(data, function( index, value ) {
                    contentHtml ="";
                    var nombre= "<td>"+value.nombre+"</td>";
                    var direccion= "<td>"+value.direccion+"</td>";
                    var telefono= "<td>"+value.telefono+"</td>";
                    var tipo= "<td>"+value.tipo+"</td>";
                    contentHtml += "<tr>"+ tipo + nombre + direccion + telefono + "</tr>";
                    $(".nombre").append(contentHtml);
                });

                console.log("Load was performed.");
            });
        });
    </script>
</body>
</html>
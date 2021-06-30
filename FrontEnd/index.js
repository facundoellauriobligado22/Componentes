let descripcion = $("#txtDescripcion").val();
let grupo = $("#cboGrupo").val();
let ubicacion = $("#cboUbicacion").val();
let numeroParte = $("#txtPartNumber").val();
let fabricantes = $("#cboFabricantes").val();
let stock = $("#cboStock").val();
let codigoSimilMAP = $("#txtCodigoMAP").val();
let utilizacion = $("#txtUtilizacion").val();
let usoProduccion = $("#cboProduccion").val();


$(document).ready(function () {
    $.ajax({
        url: "https://localhost:5001/Deporte/ObtenerDeporte",
        type: "GET",
        success: function (result) {
            if (result.ok) {
                
            } else {
                cargarComboDeportes(result.return);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
});

function cargarComboDeportes(datos) {
    select = document.getElementById("cboDeportes");
    for (let i = 0; i < datos.length; i++) {
        var option = document.createElement('option');
        option.text = datos[i].nombre;
        option.value = datos[i].idDeporte;
        select.add(option);
    }
}

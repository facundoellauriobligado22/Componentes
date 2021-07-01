$(document).ready(function () {
    $.ajax({
        url: "https://localhost:5001/Deporte/ObtenerDeporte",
        type: "GET",
        success: function (result) {
            if (result.ok) {

            } else {
                cargarComboGrupo(result.return);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
    $.ajax({
        url: "https://localhost:5001/Deporte/ObtenerDeporte",
        type: "GET",
        success: function (result) {
            if (result.ok) {

            } else {
                cargarComboUbicacion(result.return);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
    $.ajax({
        url: "https://localhost:5001/Deporte/ObtenerDeporte",
        type: "GET",
        success: function (result) {
            if (result.ok) {

            } else {
                cargarComboFabricantes(result.return);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
    $.ajax({
        url: "https://localhost:5001/Deporte/ObtenerDeporte",
        type: "GET",
        success: function (result) {
            if (result.ok) {

            } else {
                cargarComboProduccion(result.return);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
});
$("#btnCargar").click(function () {

    let numeroParte = $("#txtPartNumber").val();
    let descripcion = $("#txtDescripcion").val();
    let ubicacion = $("#cboUbicacion").val();
    let grupo = $("#cboGrupo").val();
    let fabricantes = $("#cboFabricantes").val();
    let stock = $("#cboStock").val();
    let codigoMAP = $("#txtCodigoMAP").val();
    let utilizacion = $("#txtUtilizacion").val();
    let usoProduccion = $("#cboProduccion").val();
    let fotoComponente = $("#FFComponente").val();


    if (numeroParte === "") {
        swal("Mal!", "Ingresa un Part number", "error");
    }
    else if (descripcion === "") {
        swal("Mal!", "Ingresa una descripcion", "error");
    }
    else if (ubicacion === "Seleccionar") {
        swal("Mal!", "Seleccione una ubicacion", "error");
    }
    else if (grupo === "Seleccionar") {
        swal("Mal!", "Seleccione un grupo", "error");
    }
    else if (fabricantes === "Seleccionar") {
        swal("Mal!", "Seleccione un fabricante", "error");
    }
    else if(usoProduccion === ""){
        swal("Mal!", "Seleccione un uso en produccion", "error");
    }
    else if(stock === ""){
        swal("Mal!", "Ingresa el stock", "error");
    }
    else if(codigoMAP ===""){
        swal("Mal!", "Ingresa el codigo MAP", "error");
    }
    else if (fotoComponente === ""){
        swal("Mal!", "Ingresa una foto del componente", "error");
    }
    else {
        swal("Buen trabajo", "Se registro tu componente", "success");
    }
});

function cargarComboGrupo(datos) {
    select = document.getElementById("cboGrupo");
    for (let i = 0; i < datos.length; i++) {
        var option = document.createElement('option');
        option.text = datos[i].grupo;
        option.value = datos[i].id_grupo;
        select.add(option);
    }
}
function cargarComboUbicacion(datos) {
    select = document.getElementById("cboUbicacion");
    for (let i = 0; i < datos.length; i++) {
        var option = document.createElement('option');
        option.text = datos[i].ubicacion;
        option.value = datos[i].id_ubicacion;
        select.add(option);
    }
}
function cargarComboFabricantes(datos) {
    select = document.getElementById("cboFabricantes");
    for (let i = 0; i < datos.length; i++) {
        var option = document.createElement('option');
        option.text = datos[i].fabricantes;
        option.value = datos[i].id_fabricante;
        select.add(option);
    }
}
function cargarComboProduccion(datos) {
    select = document.getElementById("cboFabricantes");
    for (let i = 0; i < datos.length; i++) {
        var option = document.createElement('option');
        option.text = datos[i].fabricantes;
        option.value = datos[i].id_fabricante;
        select.add(option);
    }
}

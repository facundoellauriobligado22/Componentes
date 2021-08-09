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
    else if (stock === "") {
        swal("Mal!", "Ingresa el stock", "error");
    }
    else if (codigoMAP === "") {
        swal("Mal!", "Ingresa el codigo MAP", "error");
    }
    else if (fotoComponente === "") {
        swal("Mal!", "Ingresa una foto del componente", "error");
    }
    else {
        comando = {
            "idUbicacion": 1,
            "partNumber": numeroParte,
            "descripcion": descripcion,
            "idGrupo": 1,
            "idFabricante": 1,
            "stock": stock,
            "codigoMap": 3455,
            "utilizacion": utilizacion,
            "usoEnProduccion": false,
            "fotoComponente": fotoComponente
        }
        $.ajax({
            url: "http://localhost:8080/componente/create",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(comando),
            success: function (result) {
                if (result.ok) {
                    swal("Buen trabajo", "Se registro tu socio", "success");
                } else {
                    result.ok = false;
                }
            },
            error: function (error) {

            }
        });
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

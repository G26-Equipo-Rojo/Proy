function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/api/usuario/' + id,
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (item) {
        $("#id").val(item.id)
        // $("#codigo").val(item.codigo)
        $("#correo").val(item.correo) 
        $("#nombre").val(item.nombre)
        $("#identificacion").val(item.identificacion) 
        $("#apellido").val(item.apellido)
        $("#contrasena").val(item.contrasena)
        $("#rol").val(item.rol)       
    })
}

//Cargar de manera automatica los datos registrados
function loadTable() {
    $.ajax({
        url: 'http://localhost:9000/api/usuario',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
        registros +="<tr class='table-success'>";
            registros +="<td><a href='#' onclick='findById(" + item.id + ")'>" + item.id + "</a></td>";
            registros +="<td>" + item.correo + "</td>";
            registros +="<td>" + item.nombre + "</td>";
            registros +="<td>" + item.identificacion + "</td>";
            registros +="<td>" + item.apellido + "</td>";
            registros +="<td>" + item.contrasena + "</td>";
            registros +="<td>" + item.rol + "</td>";
        registros +="</tr>";
        })
        $("#tbSalidaDatos").html(registros);
        $("#id").val("");
        // $("#codigo").val("");
        $("#correo").val("");
        $("#nombre").val("");
        $("#identificacion").val("");
        $("#apellido").val("");
        $("#contrasena").val("");
        $("#rol").val("");        
    })
}

//Accion de adicionar un registro
$("#btnAdicionar").on('click', function () {
    $.ajax({
        url: 'http://localhost:9000/api/usuario',
        data: JSON.stringify({
            // // codigo: $("#codigo").val(),
            correo: $("#correo").val(),
            nombre: $("#nombre").val(),
            identificacion: $("#identificacion").val(),
            apellido: $("#apellido").val(),
            contrasena: $("#contrasena").val(),
            rol: $("#rol").val()
     
        }),
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        loadTable();
    })
})

//Accion de modificar el registro que este seleccionado
$("#btnModificar").on('click', function () {
    $.ajax({
        url: 'http://localhost:9000/api/usuario/' + $("#id").val(),
        data: JSON.stringify({
            // // codigo: $("#codigo").val(),
            correo: $("#correo").val(),
            nombre: $("#nombre").val(),
            identificacion: $("#identificacion").val(),
            apellido: $("#apellido").val(),
            contrasena: $("#contrasena").val(),
            rol: $("#rol").val()
        }),
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        loadTable();
    })
})

//Accion para eliminar un registro seleccionado 
$("#btnEliminar").on('click', function () {
    if (confirm("Está seguro de eliminar?")) {
        $.ajax({
            url: 'http://localhost:9000/api/usuario/' + $("#id").val(),
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        }).done(function (result) {
            loadTable();
        })
    }
})

//Eveto cargar tabla
$(document).ready(function () {
    loadTable();
})
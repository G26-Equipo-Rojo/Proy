function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/api/producto/' + id,
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (item) {
        $("#id").val(item.id)
        $("#nombre").val(item.nombre)
        $("#cantidad").val(item.cantidad) 
        // $("#referencia").val(item.referencia)
        $("#numLote").val(item.numLote)
        $("#descripcion").val(item.descripcion)
        $("#precioCompra").val(item.precioCompra)        
        $("#precioVenta").val(item.precioVenta)  
        $("#categoria").val(item.categoria)        
    })
}

//Cargar de manera automatica los datos registrados
function loadTable() {
    $.ajax({
        url: 'http://localhost:9000/api/producto',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
            registros +="<tr class='table-success'>";
                registros +="<td><a href='#' onclick='findById(" + item.id + ")'>" + item.id + "</a></td>";
                registros +="<td>" + item.nombre + "</td>";
                registros +="<td>" + item.cantidad + "</td>";
                registros +="<td>" + item.descripcion + "</td>";
                registros +="<td>" + item.precioCompra + "</td>";
                registros +="<td>" + item.precioVenta + "</td>";
                registros +="<td>" + item.numLote + "</td>";
                registros +="<td>" + item.categoria + "</td>";
            registros +="</tr>";
        })
        $("#tbSalidaDatos").html(registros);
        $("#id").val("");
        $("#nombre").val("");
        $("#cantidad").val("");
        // $("#referencia").val("");
        $("#numLote").val("");
        $("#descripcion").val("");
        $("#precioCompra").val("");
        $("#precioVenta").val("");
        $("#categoria").val("");
        
    })
}

//Accion de adicionar un registro
$("#btnAdicionar").on('click', function () {
    $.ajax({
        url: 'http://localhost:9000/api/producto',
        data: JSON.stringify({
            nombre: $("#nombre").val(),
            cantidad: $("#cantidad").val(),
            // // referencia: $("#referencia").val(),
            numLote: $("#numLote").val(),
            descripcion: $("#descripcion").val(),
            precioCompra: $("#precioCompra").val(),
            precioVenta: $("#precioVenta").val(),
            categoria: $("#categoria").val()
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
        url: 'http://localhost:9000/api/producto/' + $("#id").val(),
        data: JSON.stringify({
            nombre: $("#nombre").val(),
            cantidad: $("#cantidad").val(),
            // // referencia: $("#referencia").val(),
            numLote: $("#numLote").val(),
            descripcion: $("#descripcion").val(),
            precioCompra: $("#precioCompra").val(),
            precioVenta: $("#precioVenta").val(),
            categoria: $("#categoria").val()
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
            url: 'http://localhost:9000/api/producto/' + $("#id").val(),
            method: "delete",
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
function findById(id) {
    $.ajax({
        url: 'http://localhost:9000/api/inventario/' + id,
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (item) {
        $("#id").val(item.id)
        $("#cantidadActual").val(item.cantidadActual)
        $("#fecha").val(item.fecha)
        $("#idProducto").val(item.id)
        console.log(item.producto.nombre)       
    })
}

//Cargar de manera automatica los datos registrados
function loadTable() {
    $.ajax({
        url: 'http://localhost:9000/api/inventario',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        items.forEach(function (item, index, array) {
        registros +="<tr class='table-success'>";
            registros +="<td><a href='#' onclick='findById(" + item.id + ")'>" + item.id + "</a></td>";
            registros +="<td>" + item.cantidadActual + "</td>";
            registros +="<td>" + item.fecha + "</td>";
            registros +="<td>" + item.producto.nombre + "</td>";
        registros +="</tr>";

        })
        $("#tbSalidaDatos").html(registros);
        $("#id").val("");
        $("#cantidadActual").val("");
        $("#fecha").val("");
        $("#producto").val("0");


    })
}
//Cargar de manera automatica los datos regostrados
function loadProducto() {
    $.ajax({
        url: 'http://localhost:9000/api/producto',
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (items) {
        var registros = "";
        registros="<option id='idProducto' value='0'>--Seleccione el producto--</option>";
        items.forEach(function (item, index, array) {
            registros+="<option id='idProducto' value='"+item.id+"'>"+item.nombre+"</option>";
            registros += "";
        }) 
        $("#producto").html(registros);            
    })
}

//Accion de adicionar un registro
$("#btnAdicionar").on('click', function () {
    $.ajax({
        url: 'http://localhost:9000/api/inventario',
        data: JSON.stringify({
            cantidadActual: $("#cantidadActual").val(),
            fecha: $("#fecha").val(),
            producto: {
                id:$("#producto").val()
            }
        }),
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        loadProducto();
        loadTable();
    })
})

//Accion de modificar el registro que este seleccionado
$("#btnModificar").on('click', function () {
    $.ajax({
        url: 'http://localhost:9000/api/inventario/' + $("#id").val(),
        data: JSON.stringify({
            cantidadActual: $("#cantidadActual").val(),
            fecha: $("#fecha").val(),
            producto: {
                id:$("#producto").val()
            }

        }),
        method: "put",
        headers: {
            "Content-Type": "application/json"
        }
    }).done(function (result) {
        loadProducto();
        loadTable();
    })
})

//Accion para eliminar un registro seleccionado 
$("#btnEliminar").on('click', function () {
    if (confirm("Está seguro de eliminar?")) {
        $.ajax({
            url: 'http://localhost:9000/api/usuario/' + $("#id").val(),
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).done(function (result) {
            loadProducto();
            loadTable();
        })
    }
})

//Eveto cargar tabla
$(document).ready(function () {
    loadProducto();
    loadTable();
})
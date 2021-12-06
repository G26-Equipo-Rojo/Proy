<template>
    <div id="GuardarProductos">
        <!-- Modal Productos -->
        <div class="modal fade" id="modalGuardarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">    
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Guardar producto</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <input type="hidden" v-model="id">
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="nombre" v-model="nombre" placeholder="nombre">
                                <label for="nombre">Nombre</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="descripcion" v-model="descripcion" placeholder="descripcion">
                                <label for="descripcion">Descripción</label>
                            </div>                            
                            <div v-show="estadoPrecio_compra" class="form-floating mb-2">
                                <input type="number" class="form-control" id="precio_compra" v-model="precio_compra" placeholder="precio_compra">
                                <label for="precio_compra">Precio compra</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="number" class="form-control" id="precio_venta" v-model="precio_venta" placeholder="precio_venta">
                                <label for="precio_venta">Precio venta</label>
                            </div>                            
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="num_lote" v-model="num_lote" placeholder="num_lote">
                                <label for="num_lote">Num. Lote</label>
                            </div>
                            <div v-show="estadoCantidad" class="form-floating mb-2">
                                <input type="number" class="form-control" id="cantidad" v-model="cantidad" placeholder="cantidad">
                                <label for="cantidad">Cantidad</label>
                            </div>
                            <div v-show="estadoVencimiento" class="form-floating mb-2">
                                <input type="date" class="form-control" id="vencimiento" v-model="vencimiento" placeholder="vencimiento">
                                <label for="vencimiento">Vencimiento</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="origen" v-model="origen" placeholder="origen">
                                <label for="origen">Origen</label>
                            </div>                                                        
                        </div>
                        <div class="text-center mb-2">
                            <button type="button" @click="Campo()" class="btn btn-outline-success mb-2"> Agregar campo extra <fa icon="plus" /> </button>
                            <select v-model="selectCamposProducto" class="form-select" aria-label="Campos disponibles">
                                <option value="selected" >{{msg}}</option>
                                <option v-show="selectestadoPrecio_compra" value="precio_compra">Precio compra</option>
                                <option v-show="selectestadoCantidad" value="cantidad">Cantidad</option>
                                <option v-show="selectestadoVencimiento" value="vencimiento">Vencimiento</option>
                            </select>
                        </div>                               
                    </div>             
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" @click="Agregar()" class="btn btn-primary" data-bs-dismiss="modal">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Agregamos componente TOAST para las notificaciones push -->
        <Toast ref="toast" />   
    </div>
</template>
<script>
// Importamos axios para las peticiones a la api
import axios from 'axios'
// Importamos el componente para las notificaciones push (Toast) 
import Toast from '../Toast.vue'

export default {
    name:'GuardarProducto',
    components:{
        Toast
    },
    data() {
    return {
        id:0,
        nombre:'',
        descripcion:'',      
        precio_compra:'',
        precio_venta:'',
        num_lote:'',
        cantidad:'',
        vencimiento:'',
        origen:'',  
        selectCamposProducto: 'selected',
        estadoPrecio_compra: false,
        estadoCantidad: false,
        estadoVencimiento: false,
        selectestadoPrecio_compra: true,
        selectestadoCantidad: true,
        selectestadoVencimiento: true,
        msg: 'Campos disponibles'
    }
    },
    Update() {
        console.log("[MODAL_GUARDAR_USUARIO-74]: HOLA ");
        this.LimpiarFromulario()
    },
    methods: {
        Agregar:function(){
            let data = {
                apellido: this.apellido,
                descripcion:this.descripcion,                
                precio_compra: this.precio_compra,
                precio_venta:  this.precio_venta,
                num_lote: this.num_lote,
                cantidad:  this.cantidad,
                vencimiento: this.vencimiento,
                origen:  this.origen                           
            };
            axios.post('http://localhost:8080/api/producto',data).then(() =>{
                this.$emit('eventoHijo')
                this.LimpiarFromulario()
                this.$refs.toast.Toast("Guardado","Se guardado con exito!","success"); 
            })
            .catch(()=>{
                this.$refs.toast.Toast("Error","No se pudo guardar","error");
            })
      
        },
        Campo:function() {
            let campo = this.selectCamposProducto;
            
            switch (campo) {
                case 'precio_compra':
                    this.selectestadoPrecio_compra = false;
                    this.estadoPrecio_compra = true;
                    this.ValidarCamposSelect();  
                    break;
                case 'cantidad':
                    this.selectestadoCantidad = false; 
                    this.estadoCantidad = true;
                    this.ValidarCamposSelect();              
                    break;
                case 'vencimiento':
                    this.selectestadoVencimiento = false; 
                    this.estadoVencimiento = true;
                    this.ValidarCamposSelect();         
                    break;                   
            }
        },
        LimpiarFromulario:function(){
        this.nombre = "";
        this.descripcion = "";
        this.precio_compra = "";
        this.precio_venta = "";
        this.num_lote = "";
        this.cantidad = "";
        this.vencimiento = "";
        this.origen = "";
        },
        ValidarCamposSelect:function() {
            if (this.selectestadoPrecio_compra == false && this.selectestadoCantidad == false && this.selectestadoVencimiento == false) {
                this.msg = 'No hay campos disponibles'
            }
            this.selectCamposProducto= 'selected';
        }

    },
}
</script>
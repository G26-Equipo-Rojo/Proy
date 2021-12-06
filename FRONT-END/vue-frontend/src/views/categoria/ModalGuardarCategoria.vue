<template>
    <div id="GuardarCategoria">
        <!-- Modal Categorias -->
        <div class="modal fade" id="modalGuardarCategoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">    
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Guardar categoria</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div >
                            <input type="hidden" v-model="id">
                            <div v-show="estadoCodigo" class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="codigo" placeholder="Código">
                                <label for="floatingInput">Código</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="nombre" placeholder="nombre">
                                <label for="floatingPassword">Nombre</label>
                            </div>
                                <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="descripcion" placeholder="descripcion">
                                <label for="floatingInput">Descripción</label>
                            </div>
                            <div v-show="estadoFecha">
                                <div class="form-floating mb-2">
                                    <input type="date" class="form-control" v-model="fecha" placeholder="fecha">
                                    <label for="floatingInput">Fecha</label>
                                </div>
                            </div>
                        </div>
                        <div class="text-center mb-2">
                            <button type="button" @click="Campo()" class="btn btn-outline-success mb-2"> Agregar campo extra <fa icon="plus" /> </button>
                            <select v-model="selectCamposCategoria" class="form-select" aria-label="Campos disponibles">
                                <option value="selected" >{{msg}}</option>
                                <option v-show="selectEstadoCodigo" value="codigo">Código</option>
                                <option v-show="selectEstadoFecha" value="fecha">Fecha</option>
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
    name:'GuardarCategoria',
    components:{
        Toast
    },
    data() {
        return {
        id:0,
        codigo:'',
        nombre:'',
        descripcion:'',
        fecha:'',
        selectCamposCategoria: 'selected',
        estadoCodigo: false,
        estadoFecha: false,
        selectEstadoCodigo: true,
        selectEstadoFecha: true,
        msg: 'Campos disponibles'        
        }
    },
    Update() {
        console.log("[MODAL_GUARDAR_CATEGORIA-74]: HOLA ");
        this.LimpiarFromulario()
    },
    methods: {
        Agregar:function(){
            let data = {
                codigo:this.codigo,
                nombre: this.nombre,
                descripcion: this.descripcion,
                fecha:  this.fecha        
            };
            axios.post('http://localhost:8080/api/categoria',data).then(() =>{
                this.$emit('eventoHijo')
                this.LimpiarFromulario()
                this.$refs.toast.Toast("Guardado","Se guardado con exito!","success"); 
            })
            .catch(()=>{
                                this.$refs.toast.Toast("Error","No se pudo guardar","error");
            })
      
        },
        Campo:function() {
            let campo = this.selectCamposCategoria;
            switch (campo) {
                case 'codigo':
                    this.selectEstadoCodigo = false;
                    this.estadoCodigo = true;
                    this.ValidarCamposSelect();
                    break;
                case 'fecha':
                    this.selectEstadoFecha = false; 
                    this.estadoFecha = true;
                    this.ValidarCamposSelect();             
                    break;
            }

        },
        LimpiarFromulario:function(){
            this.codigo="";
            this.nombre="";
            this.descripcion="";
            this.fecha="";
        },
        ValidarCamposSelect:function() {
            if (this.selectEstadoCodigo == false && this.selectEstadoFecha == false) {
                this.msg = 'No hay campos disponibles'
            }
            this.selectCamposCategoria= 'selected';
        }

    },
}
</script>
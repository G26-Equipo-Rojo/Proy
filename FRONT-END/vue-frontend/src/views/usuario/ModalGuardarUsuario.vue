<template>
    <div id="GuardarCategoria">
        <!-- Modal Categorias -->
        <div class="modal fade" id="modalGuardarCategoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">    
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Guardar usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <input type="hidden" v-model="id">
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="nombre" placeholder="nombre">
                                <label for="floatingPassword">Nombre</label>
                            </div>
                            <div v-show="estadoApellido" class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="apellido" placeholder="apellido">
                                <label for="floatingInput">Apellido</label>
                            </div>                            
                            <div class="form-floating mb-2">
                                <input type="email" class="form-control" v-model="correo" placeholder="correo">
                                <label for="floatingInput">Correo</label>
                            </div>
                            <div v-show="estadoDocumento" class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="documento" placeholder="documento">
                                <label for="floatingInput">Documento</label>
                            </div>
                            <div v-show="estadoTelefono" class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="telefono" placeholder="telefono">
                                <label for="floatingInput">Teléfono</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="rol" placeholder="rol">
                                <label for="floatingInput">Rol</label>
                            </div>                                                        
                        </div>
                        <div class="text-center mb-2">
                            <button type="button" @click="Campo()" class="btn btn-outline-success mb-2"> Agregar campo extra <fa icon="plus" /> </button>
                            <select v-model="selectCamposUsuario" class="form-select" aria-label="Campos disponibles">
                                <option value="selected" >{{msg}}</option>
                                <option v-show="selectEstadoApellido" value="apellido">Apellido</option>
                                <option v-show="selectEstadoDocumento" value="documento">Documento</option>
                                <option v-show="selectEstadoTelefono" value="telefono">Teléfono</option>
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
        nombre:'',
        apellido:'',      
        correo:'',
        documento:'',
        telefono:'',
        rol:'',  
        selectCamposUsuario: 'selected',
        estadoApellido: false,
        estadoDocumento: false,
        estadoTelefono: false,
        selectEstadoApellido: true,
        selectEstadoDocumento: true,
        selectEstadoTelefono: true,
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
                nombre:this.nombre,
                apellido: this.apellido,
                correo: this.correo,
                documento:  this.documento,
                telefono: this.telefono,
                rol:  this.rol                           
            };
            axios.post('http://localhost:8080/api/usuario',data).then(() =>{
                this.$emit('eventoHijo')
                this.LimpiarFromulario()
                this.$refs.toast.Toast("Guardado","Se guardado con exito!","success"); 
            })
            .catch(()=>{
                this.$refs.toast.Toast("Error","No se pudo guardar","error");
            })
      
        },
        Campo:function() {
            let campo = this.selectCamposUsuario;
            switch (campo) {
                case 'apellido':
                    this.selectEstadoApellido = false;
                    this.estadoApellido = true;
                    this.ValidarCamposSelect();  
                    break;
                case 'documento':
                    this.selectEstadoDocumento = false; 
                    this.estadoDocumento = true;
                    this.ValidarCamposSelect();              
                    break;
                case 'telefono':
                    this.selectEstadoTelefono = false; 
                    this.estadoTelefono = true;
                    this.ValidarCamposSelect();         
                    break;                   
            }
        },
        LimpiarFromulario:function(){
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.documento = "";
        this.telefono = "";
        this.rol = "";
        },
        ValidarCamposSelect:function() {
            if (this.selectEstadoApellido == false && this.selectEstadoDocumento == false && this.selectEstadoTelefono == false) {
                this.msg = 'No hay campos disponibles'
            }
            this.selectCamposUsuario= 'selected';
        }

    },
}
</script>
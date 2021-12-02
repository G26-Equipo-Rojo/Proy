<template>
    <div id="EditarCategoria">
        <!-- Modal Categorias -->
        <div class="modal fade" id="modalEditarUsuario" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">    
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <input type="hidden" v-model="id">
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="nombre" placeholder="nombre">
                                <label for="floatingPassword">Nombre</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="apellido" placeholder="apellido">
                                <label for="floatingInput">Apellido</label>
                            </div>                            
                            <div class="form-floating mb-2">
                                <input type="email" class="form-control" v-model="correo" placeholder="correo">
                                <label for="floatingInput">Correo</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="documento" placeholder="documento">
                                <label for="floatingInput">Documento</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="telefono" placeholder="telefono">
                                <label for="floatingInput">Teléfono</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" v-model="rol" placeholder="rol">
                                <label for="floatingInput">Rol</label>
                            </div>                                                        
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" @click="Modificar()" class="btn btn-primary" data-bs-dismiss="modal">Editar</button>
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
    name:'EditarCategoria',
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
      listData:[]
    }
  },
    methods: {       
    Modificar:function(){
      let data = {
        id:this.id,
        nombre:this.nombre,
        apellido:this.apellido,
        correo: this.correo,
        documento: this.documento,
        telefono: this.telefono,
        rol: this.rol         
      };

      axios.put('http://localhost:8080/api/usuario/'+this.id,data).then(() =>{
        this.$emit('eventoHijo');
        this.$refs.toast.Toast("Modificado","Se modificado con exito!","success"); 
      })
      .catch(()=>{
        this.$refs.toast.Toast("Error","No se pudo modificar","error"); 
      })
      
    },
    FindByid:function(id){
      // metodo para consutlar por el id del boton editar en la vista
      axios.get('http://localhost:8080/api/usuario/'+id).then(result =>{
        this.id = result.data.id;
        this.nombre = result.data.nombre;
        this.apellido = result.data.apellido;
        this.correo = result.data.correo;
        this.documento = result.data.documento;
        this.telefono = result.data.telefono;
        this.rol = result.data.rol;
      })
      .catch(()=>{
        this.$refs.toast.Toast("Error","Intente de nuevo","Warning"); 
      })
    }
    },
}
</script>
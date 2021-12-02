<template>
  <div class="usuario">
    <div class="table-responsive">
        <button class="btn btn-outline-secondary m-1 " id="btnAgregarCategoria" data-bs-toggle="modal" data-bs-target="#modalGuardarCategoria">Agregar <fa icon="plus-circle" /></button>
        <table class="table table-hover table-striped caption-top text-center">
          <caption><strong>Listado de usuarios</strong></caption>
          <thead class="table-dark">
            <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Correo</th>
            <th scope="col">Documento</th>
            <th scope="col">Telefono</th>
            <th scope="col">Rol</th>
            <th scope="col">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in listData" :key="item.id">
            <td>{{item.nombre}}</td>
            <td>{{item.apellido}}</td>
            <td>{{item.correo}}</td>
            <td>{{item.documento}}</td>
            <td>{{item.telefono}}</td>
            <td>{{item.rol}}</td>            
            <!-- Botones para las acciones -->
            <td>
              <div>
                <!-- Editar -->
                <button type="button" @click="CargarId(item.id)" class="btn btn-outline-success btn-sm m-md-1" id="btnEditarCategoria" data-bs-toggle="modal" data-bs-target="#modalEditarUsuario"><fa icon="edit" /></button>
                <!-- Eliminar -->
                <button type="button" @click="Eliminar(item.id)" class="btn btn-outline-danger btn-sm" id="btnEliminarCategoria"><fa icon="trash-alt" /></button>            
              </div>
            </td>
            </tr>
          </tbody>
        </table>
        <!-- Alert para mostrar cuando no hay datos -->
        <div v-if='(listData == "" )' class="alert alert-warning" role="alert">
          <strong><fa icon="exclamation-triangle" />  No hay</strong> Registros en la base de datos o <strong> <fa icon="bomb" /> se perdio</strong> la conexión con la api
        </div>
    </div>
    <!-- Agregamos el modal para guardar Usuarios -->
    <ModalGuardarUsuario @eventoHijo="loadData"/>
    <!-- Agregamos el modal para editar Usuarios -->
    <ModalEditarUsuario ref="editar" @eventoHijo="loadData" />
    <!-- Agregamos componente TOAST para las notificaciones push -->
    <Toast ref="toast" />       
  </div>
</template>
<script>
// Importamos axios para las peticiones a la api
import axios from 'axios'
// Importamos los modales 
import ModalGuardarUsuario from '@/views/usuario/ModalGuardarUsuario.vue'
import ModalEditarUsuario from '@/views/usuario/ModalEditarUsuario.vue'
// Importamos el componente para las notificaciones push (Toast) 
import Toast from '@/views/Toast.vue'

export default {
  name:'usuario',
  components:{
    ModalGuardarUsuario,
    ModalEditarUsuario,
    Toast
  },
  data() {
    return {
      listData:[]
    }
  },
  created() {
    this.loadData();
  },
  methods: {
    Eliminar:function(id){
      this.$swal({
          title: '¿Estas seguro?',
          text: 'Esta accion no se puede revertir!',
          type: 'warning',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Si, eliminalo!',
          cancelButtonText: 'No, dejalo!',
          showCloseButton: true,
          showLoaderOnConfirm: true
        }).then((result) => {
          if(result.value) {
            axios.delete('http://localhost:8080/api/usuario/'+id,).then( () =>{
              this.$refs.toast.Toast("Elimidado","Se elimino con exito!","success");              
              this.loadData();
            })
            .catch(()=>{
              this.$refs.toast.Toast("Error","No se pudo eliminar","error");
            })
            
          } else {
            this.$refs.toast.Toast("Cancelado","Tu registro esta intacto!","info");
          }
        })
    },                    
    loadData:function(){
      axios.get('http://localhost:8080/api/usuario').then(result =>{
        this.listData = result.data

      })
      .catch(()=>{
        this.listData = []
      })
    },
    CargarId:function(id){
      this.$refs.editar.FindByid(id);
    }

  },      
}
</script>

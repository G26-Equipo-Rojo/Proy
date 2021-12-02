
<script>
export default {
    
    methods: {
        Toast:function(titulo, cuerpo, icon){
              this.$swal({
                title: titulo,
                text: cuerpo,
                type: icon,
                icon: icon,
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 3500,
                timerProgressBar: true,
                    didOpen: (toast) => {
                      toast.addEventListener('mouseenter', this.$swal.stopTimer)
                      toast.addEventListener('mouseleave', this.$swal.resumeTimer)
                    }
            })
        }
    },
}
</script>

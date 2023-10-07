// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion(){
  let cedula = document.getElementById('txtCedula').value;
  let contrasena = document.getElementById('txtContrasena').value;

  const request = await fetch('login/medico/'+cedula+'/'+contrasena+'', {

    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(cedula, contrasena)
  });
  const respuesta = await request.text();

  if(respuesta == true){
  window.location.href = 'index.html'
  }else{
  alert("La contraseña es incorrecta, intente de nuevo");
  }

}
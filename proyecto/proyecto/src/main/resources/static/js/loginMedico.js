// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function iniciarSesion(){
  let cedula = document.getElementById('txtCedula').value;
  let contrasena = document.getElementById('txtContrasena').value;

  const data = {
    cedula: cedula,
    contrasena: contrasena
  };

  const request = await fetch('login/medico', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  });

  const respuesta = await request.text();

  if(respuesta === 'true'){
    window.location.href = 'index.html';
  } else {
    alert("La contraseña es incorrecta, intente de nuevo");
  }
}

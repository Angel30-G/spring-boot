// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#doctores').DataTable();
});

async function cargarUsuarios(){

  const request = await fetch('medico', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  for(let Medico of doctores){

    let medicoHtml = '<tr><td>'
    +Medico.cedula+'</td><td>'
    +Medico.contrasena+'</td><td>'
    +Medico.especialidad+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml =+ medicoHtml
  }

  document.querySelector('#doctores tbody').outerHTML = listadoHtml;


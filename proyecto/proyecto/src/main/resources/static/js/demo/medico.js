// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarMedicos();
  $('#doctores').DataTable();
});

async function cargarMedicos(){

  const request = await fetch('medicos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const medicos = await request.json();

  let listadoHtml = '';
  for(let Medico of medicos){

    let medicoHtml = '<tr><td>'
    +Medico.cedula+'</td><td>'
    +Medico.contrasena+'</td><td>'
    +Medico.especialidad.nombre+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml =+ medicoHtml
  }

  document.querySelector('#doctores tbody').outerHTML = listadoHtml;

}
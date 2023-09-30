// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#expediente').DataTable();
});

async function cargarUsuarios(){

  const request = await fetch('Expediente', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const expediente = await request.json();

  let listadoHtml = '';
  for(let Expediente of expediente){

    let expedienteHtml = '<tr><td>'
    +Expediente.id_expediente+'</td><td>'
    +Expediente.cedula+'</td><td>'
    +Expediente.fecha+'</td><td>'
    +Expediente.padecimiento+'</td><td>'
    +Expediente.procedimiento+'</td><td>'
    +Expediente.medicamentos+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml =+ expedienteHtml
  }

  document.querySelector('#expediente tbody').outerHTML = listadoHtml;


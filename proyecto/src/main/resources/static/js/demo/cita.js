// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitas();
  $('#cita').DataTable();
});

async function cargarCitas(){

  const request = await fetch('CitaAgendada', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const CitaAgendada = await request.json();

  let listadoHtml = '';
  for(let Cita of CitaAgendada){

    let citaHtml = '<tr><td>'
    +Cita.id_cita+'</td><td>'
    +Cita.cedula+'</td><td>'
    +Cita.id_medico+'</td><td>'
    +Cita.fecha_hora+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml =+ citaHtml
  }

  document.querySelector('#doctores tbody').outerHTML = listadoHtml;

}
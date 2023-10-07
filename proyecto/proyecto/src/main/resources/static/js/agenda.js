$(document).ready(function() {
  verAgenda();
});

async function verAgenda(){

  const request = await fetch('paciente/agenda', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const citasAgendadas = await request.json();

  let listadoHtml = '';

  for (let CitaAgendada of citasAgendadas) {
    let idCita = CitaAgendada.id_cita;
    let paciente = CitaAgendada.paciente.nombre + " " + CitaAgendada.paciente.apellido;
    let medico = CitaAgendada.medico.nombre + " " + CitaAgendada.medico.apellido;
    let fecha = CitaAgendada.fecha;
    let hora = CitaAgendada.hora;

    let agendaHtml = '<tr>' +
      '<td>' + idCita + '</td>' +
      '<td>' + paciente + '</td>' +
      '<td>' + medico + '</td>' +
      '<td>' + fecha + '</td>' +
      '<td>' + hora + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += agendaHtml;
  }

  document.querySelector('#agenda tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#agenda').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}
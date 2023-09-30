// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitasDisponiblesMG();
  $('#paciente_citasdisponibles').DataTable();
});

async function cargarCitasDisponiblesMG(){

  const request = await fetch('paciente/citasdisponibles', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const citasdisponibles = await request.json();

  let listadoHtml = '';

  for (let cita of citasdisponibles) {
    let medicoNombre = cita.medico.nombre;
    let especialidadNombre = cita.medico.especialidad.nombre;
    let fechaHora = cita.fecha_hora;

    let citadisponibleHtml = '<tr>' +
      '<td>' + medicoNombre + '</td>' +
      '<td>' + especialidadNombre + '</td>' +
      '<td>' + fechaHora + '</td>' +
      '</tr>';

    listadoHtml += citadisponibleHtml;
  }

  document.querySelector('#paciente_citasdisponibles tbody').outerHTML = listadoHtml;

}
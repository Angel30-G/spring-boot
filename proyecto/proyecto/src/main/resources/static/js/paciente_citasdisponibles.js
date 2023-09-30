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
    let fecha = cita.fecha;
    let hora = cita.hora;

    let citadisponibleHtml = '<tr>' +
      '<td>' + medicoNombre + '</td>' +
      '<td>' + especialidadNombre + '</td>' +
      '<td>' + fecha + '</td>' +
      '<td>' + hora + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += citadisponibleHtml;
  }

  document.querySelector('#paciente_citasdisponibles tbody').outerHTML = listadoHtml;

}
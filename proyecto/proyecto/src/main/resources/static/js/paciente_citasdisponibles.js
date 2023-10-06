// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitasDisponiblesMG();
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

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#paciente_citasdisponibles').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });
}

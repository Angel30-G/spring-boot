// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarPacientes();
});

async function cargarPacientes(){

  const request = await fetch('pacientes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const pacientes = await request.json();

  let listadoHtml = '';

  for (let Paciente of pacientes) {
    let pacienteCedula = Paciente.cedula;
    let pacienteNombre = Paciente.nombre;
    let pacienteApellido = Paciente.apellido;
    let pacienteCorreo = Paciente.correo;

    let pacienteHtml = '<tr>' +
      '<td>' + pacienteCedula + '</td>' +
      '<td>' + pacienteNombre + '</td>' +
      '<td>' + pacienteApellido + '</td>' +
      '<td>' + pacienteCorreo + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += pacienteHtml;
  }

  document.querySelector('#pacientes tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#pacientes').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}
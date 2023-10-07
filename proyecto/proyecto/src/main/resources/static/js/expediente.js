// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitasDisponiblesMG();
});

async function cargarCitasDisponiblesMG(){

  const request = await fetch('paciente/expediente', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const expedientes = await request.json();

  let listadoHtml = '';

  for (let Expediente of expedientes) {
    let expedienteId = Expediente.id_expediente;
    let expedienteCedula = Expediente.paciente.cedula;
    let expedienteFecha = Expediente.fecha;
    let expedientePadecimiento = Expediente.padecimiento;
    let expedienteProcedimiento = Expediente.procedimiento;
    let expedienteMedicamentos = Expediente.medicamentos;

    let expedienteHtml = '<tr>' +
      '<td>' + expedienteId + '</td>' +
      '<td>' + expedienteCedula + '</td>' +
      '<td>' + expedienteFecha + '</td>' +
      '<td>' + expedientePadecimiento + '</td>' +
      '<td>' + expedienteProcedimiento + '</td>' +
      '<td>' + expedienteMedicamentos + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += expedienteHtml;
  }

  document.querySelector('#expediente tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#expediente').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}
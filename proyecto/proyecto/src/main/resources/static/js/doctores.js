// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarMedicos();
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

  for (let Medico of medicos) {
    let medicoCedula = Medico.cedula;
    let medicoNombre = Medico.nombre;
    let medicoApellido = Medico.apellido;
    let medicoEspecialidad = Medico.especialidad.nombre;
    let medicoCorreo = Medico.correo;

    let medicoHtml = '<tr>' +
      '<td>' + medicoCedula + '</td>' +
      '<td>' + medicoNombre + '</td>' +
      '<td>' + medicoApellido + '</td>' +
      '<td>' + medicoEspecialidad + '</td>' +
      '<td>' + medicoCorreo + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += medicoHtml;
  }

  document.querySelector('#doctores tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#doctores').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}
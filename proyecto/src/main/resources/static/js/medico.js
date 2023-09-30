// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitasDisponiblesMG();
  $('#doctores').DataTable();
});

async function cargarCitasDisponiblesMG(){

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
    let medicoContrasena = Medico.contrasena;
    let medicoEspecialidad = Medico.especialidad.nombre;

    let medicoHtml = '<tr>' +
      '<td>' + medicoCedula + '</td>' +
      '<td>' + medicoContrasena + '</td>' +
      '<td>' + medicoEspecialidad + '</td>' +
      '<td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';

    listadoHtml += medicoHtml;
  }

  document.querySelector('#doctores tbody').outerHTML = listadoHtml;

}
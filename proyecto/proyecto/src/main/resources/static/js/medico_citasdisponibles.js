// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarCitasDisponiblesMG();
});

async function cargarCitasDisponiblesMG(){

  // Destruye la tabla existente
  if ($.fn.DataTable.isDataTable('#medico_citasdisponibles')) {
    $('#medico_citasdisponibles').DataTable().destroy();
  }

  const request = await fetch('medico/citasdisponibles', {
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
    let botonEliminar = '<a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let botonAgendar = '<a href="#" onclick="referirPaciente(' + cita.id_cita_disponible + ')" class="btn btn-success btn-circle btn-sm"><i class="fas fa-check"></i></a>';

    let citadisponibleHtml = '<tr>' +
      '<td>' + medicoNombre + '</td>' +
      '<td>' + especialidadNombre + '</td>' +
      '<td>' + fecha + '</td>' +
      '<td>' + hora + '</td>' +
      '<td>' + botonAgendar + '&nbsp;' + botonEliminar + '</td></tr>';

    listadoHtml += citadisponibleHtml;
  }

  document.querySelector('#medico_citasdisponibles tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#medico_citasdisponibles').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}

async function referirPaciente(id_cita_disponible) {
    // Usamos prompt para solicitar la información de la cédula al usuario
    let cedula = prompt('Por favor, ingrese la cedula del paciente:');

    // Verificamos si el usuario ingresó algo y no hizo clic en Cancelar
    if (cedula !== null) {
        const data = {
            cedula: cedula,
            id_cita_disponible: id_cita_disponible
        };

        const request = await fetch('medico/referirpaciente', {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        const respuesta = await request.text();

        if(respuesta === 'true'){
            cargarCitasDisponiblesMG();
            alert("Cita Agendada Correctamente.");
        } else {
          alert("Cedula no valida.");
        }


    } else {
            // El usuario hizo clic en Cancelar o no ingresó la cédula
            alert('Debe ingresar la cédula para continuar.');
    }

}
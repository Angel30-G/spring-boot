$(document).ready(function() {
  verAgenda();
});

let id_cita_global;

async function verAgenda(){

  // Destruye la tabla existente
  if ($.fn.DataTable.isDataTable('#agendamedico')) {
    $('#agendamedico').DataTable().destroy();
  }

  const request = await fetch('medico/agenda', {
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
    let botonEliminar = '<a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let botonExpediente = '<a href="#" onclick="escribirExpediente(' + idCita + ')" class="btn btn-success btn-circle btn-sm"><i class="fas fa-check"></i></a>';

    let agendaHtml = '<tr>' +
      '<td>' + idCita + '</td>' +
      '<td>' + paciente + '</td>' +
      '<td>' + medico + '</td>' +
      '<td>' + fecha + '</td>' +
      '<td>' + hora + '</td>' +
      '<td>' + botonExpediente + '&nbsp;' + botonEliminar + '</td></tr>';

    listadoHtml += agendaHtml;
  }

  document.querySelector('#agendamedico tbody').outerHTML = listadoHtml;

  // Inicializa la tabla después de que se haya cargado el contenido
  var table = $('#agendamedico').DataTable();

  // Agrega la funcionalidad de búsqueda a la tabla
  $('#myInput').on('keyup', function() {
    table.search(this.value).draw();
  });

}

async function escribirExpediente(idCita) {
    id_cita_global = idCita;
    abrirModal();

}

function abrirModal() {
  var myModal = new bootstrap.Modal(document.getElementById('expedienteModal'), {});
  myModal.show();
}

async function enviarExpediente() {
      let idCita = id_cita_global;
      let padecimiento = document.getElementById('txtPadecimiento').value;
      let procedimiento = document.getElementById('txtProcedimiento').value;
      let medicamentos = document.getElementById('txtMedicamentos').value;

      const data = {
                      idCita: idCita,
                      padecimiento: padecimiento,
                      procedimiento: procedimiento,
                      medicamentos: medicamentos
      };

      const request = await fetch('medico/escribirExpediente', {
              method: 'POST',
              headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(data)
      });
}
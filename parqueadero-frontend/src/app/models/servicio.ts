export interface Servicio {
    id?: string;          // El ID puede ser opcional
    clienteId: string;
    horaEntrada: string;
    horaSalida: string;
    espacioAsignado: string;
}

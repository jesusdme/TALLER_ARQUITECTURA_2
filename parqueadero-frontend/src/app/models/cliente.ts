export interface Cliente {
    id?: string;          // El ID puede ser opcional, ya que al crear un cliente, no necesitas enviarlo
    nombre: string;
    placaVehiculo: string;
    colorVehiculo: string;
}

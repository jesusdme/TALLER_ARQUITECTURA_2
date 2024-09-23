export interface Parqueadero {
    id?: string;       // El id puede ser opcional ya que lo genera MongoDB
    espacio: number;    // Espacios disponibles en el parqueadero
    ganancias: number;  // Ganancias acumuladas
}

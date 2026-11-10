
package edu.uco.sistemadecalificaciones.model;

public record ResumenCalificacion(
    Long id,
    String estudiante,
    String materia,
    double notaOriginal,
    long incidentes,
    double descuento,
    double notaFinal
) {}

package org.example.Repository;

import org.example.Estructuras.Cola.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    // Consulta para obtener pedidos por estado, cargando las relaciones
    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.cliente LEFT JOIN FETCH p.plato LEFT JOIN FETCH p.mesa WHERE p.estado = :estado ORDER BY p.id ASC")
    List<Pedido> findByEstadoOrderByIdAsc(String estado);

    // Consulta para obtener todos los pedidos con sus relaciones cargadas
    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.cliente LEFT JOIN FETCH p.plato LEFT JOIN FETCH p.mesa")
    List<Pedido> findAllWithRelations();
}

package org.example.Repository;

import org.example.Estructuras.Arreglo.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    List<Mesa> findByOcupadaFalse();
}

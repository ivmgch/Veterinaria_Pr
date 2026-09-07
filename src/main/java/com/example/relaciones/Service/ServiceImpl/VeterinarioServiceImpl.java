package com.example.relaciones.Service.ServiceImpl;

import com.example.relaciones.Entity.Veterinario;
import com.example.relaciones.Exception.ResourceNotFoundException;
import com.example.relaciones.Repository.VeterinarioRepository;
import com.example.relaciones.Service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository repository;

    @Override
    public List<Veterinario> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Veterinario buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Veterinario no encontrado: " + id
                        ));
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {

        return repository.save(veterinario);
    }

    @Override
    public Veterinario actualizar(Long id, Veterinario datos) {

        Veterinario actual = buscarPorId(id);

        actual.setNombre(datos.getNombre());
        actual.setEspecialidad(
                datos.getEspecialidad()
        );
        actual.setTarjetaProfesional(
                datos.getTarjetaProfesional()
        );
        actual.setCorreo(datos.getCorreo());

        return repository.save(actual);
    }

    @Override
    public void eliminar(Long id) {

        repository.delete(buscarPorId(id));
    }
}

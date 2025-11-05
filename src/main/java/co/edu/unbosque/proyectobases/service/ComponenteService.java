package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.Componente;
import co.edu.unbosque.proyectobases.repository.ComponenteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComponenteService {
    private final ComponenteRepository componenteRepository;

    public ComponenteService(ComponenteRepository componenteRepository) {
        this.componenteRepository = componenteRepository;
    }

    public List<Componente> listarComponentes() {
        return componenteRepository.findAll();
    }

    public Componente guardarComponente(Componente componente) {
        return componenteRepository.save(componente);
    }

    public Componente buscarPorId(Integer id) {
        return componenteRepository.findById(id).orElse(null);
    }

    public void eliminarComponente(Integer id) {
        componenteRepository.deleteById(id);
    }
}

package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.Contrato;
import co.edu.unbosque.proyectobases.repository.ContratoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<Contrato> listarContratos() {
        return contratoRepository.findAll();
    }

    public Contrato guardarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public Contrato buscarPorId(Integer id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public void eliminarContrato(Integer id) {
        contratoRepository.deleteById(id);
    }
}

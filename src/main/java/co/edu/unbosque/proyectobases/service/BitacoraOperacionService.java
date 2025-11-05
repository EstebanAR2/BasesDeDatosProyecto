package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.BitacoraOperacion;
import co.edu.unbosque.proyectobases.repository.BitacoraOperacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacoraOperacionService {

    private final BitacoraOperacionRepository bitacoraOperacionRepository;

    public BitacoraOperacionService(BitacoraOperacionRepository bitacoraOperacionRepository) {
        this.bitacoraOperacionRepository = bitacoraOperacionRepository;
    }


    public List<BitacoraOperacion> listarBitacoras() {
        return bitacoraOperacionRepository.findAll();
    }


    public BitacoraOperacion buscarPorId(Integer id) {
        return bitacoraOperacionRepository.findById(id).orElse(null);
    }


    public List<BitacoraOperacion> listarPorUsuario(String usuario) {
        return bitacoraOperacionRepository.findByUsuario(usuario);
    }


    public BitacoraOperacion guardarBitacora(BitacoraOperacion bitacora) {
        return bitacoraOperacionRepository.save(bitacora);
    }


    public void eliminarBitacora(Integer id) {
        bitacoraOperacionRepository.deleteById(id);
    }
}

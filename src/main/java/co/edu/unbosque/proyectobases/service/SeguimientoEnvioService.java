 package co.edu.unbosque.proyectobases.service;

 import co.edu.unbosque.proyectobases.model.SeguimientoEnvio;
 import co.edu.unbosque.proyectobases.repository.SeguimientoEnvioRepository;
 import org.springframework.stereotype.Service;

 import java.util.Collections;
 import java.util.List;
 import java.util.Optional;

 @Service
 public class SeguimientoEnvioService {
     private final SeguimientoEnvioRepository seguimientoEnvioRepository;

     public SeguimientoEnvioService(SeguimientoEnvioRepository seguimientoEnvioRepository) {
         this.seguimientoEnvioRepository = seguimientoEnvioRepository;
     }

     public List<SeguimientoEnvio> listarSeguimientos() {
         return seguimientoEnvioRepository.findAll();
     }

     public SeguimientoEnvio guardarSeguimiento(SeguimientoEnvio seguimiento) {
         return seguimientoEnvioRepository.save(seguimiento);
     }

     public SeguimientoEnvio buscarPorId(String id) {
         return seguimientoEnvioRepository.findById(id).orElse(null);
     }

     public List<SeguimientoEnvio> listarPorOrden(Integer idOrden) {
         final Optional<SeguimientoEnvio> opt = seguimientoEnvioRepository.findById(String.valueOf(idOrden));
         return Collections.singletonList(opt.orElse(null));
     }

     public void eliminarSeguimiento(String id) {
         seguimientoEnvioRepository.deleteById(id);
     }
 }

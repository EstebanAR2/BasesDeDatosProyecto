package co.edu.unbosque.proyectobases.service;

import co.edu.unbosque.proyectobases.model.EventoProveedor;
import co.edu.unbosque.proyectobases.repository.EventoProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoProveedorService {

 private final EventoProveedorRepository eventoRepo;

  public EventoProveedorService(EventoProveedorRepository eventoRepo) {
       this.eventoRepo = eventoRepo;
   }
public List<EventoProveedor> listarEventos() {
    return eventoRepo.findAll();
 }

  public EventoProveedor guardarEvento(EventoProveedor evento) {
    return eventoRepo.save(evento);
}
public List<EventoProveedor> buscarPorProveedor(Integer idProveedor) {
return eventoRepo.findByIdProveedor(idProveedor);
}
}

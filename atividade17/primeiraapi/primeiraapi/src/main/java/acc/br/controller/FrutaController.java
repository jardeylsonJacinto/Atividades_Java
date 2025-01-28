package acc.br.controller;

import java.util.List;

import acc.br.dtos.FrutaDTO;
import acc.br.service.FrutaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrutaController {

  @Inject
  FrutaService frutaService;

  @POST
  public Response criarFruta(FrutaDTO frutaDTO) {
    frutaService.criarFruta(frutaDTO);
    return Response.status(Response.Status.CREATED).build();
  }

  @GET
  public List<FrutaDTO> listarFrutas() {
    return frutaService.listarFrutas();
  }
}
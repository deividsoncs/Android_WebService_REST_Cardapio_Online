package br.cardapio.recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.cardapio.bean.*;
import br.cardapio.business.*;
import br.cardapio.listas.*;

@Path("/recursos")
@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class Recursos {
	
	  //################################
	  //###  USUÁRIO ESTABELECIMENTO ###
	  //################################
	
	  //Autentica Usuário
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/autentica_usuario
	  @POST
	  @Path("/autentica_usuario")
	  public UsuarioEstabelecimento autenticaUsuarioEstabelecimento(UsuarioEstabelecimento usuario){
		  return new UsuarioEstabelecimentoBusiness().autentica(usuario);
	  }

	  //Insere um novo Usuário
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_usuario
	  @POST
	  @Path("/novo_usuario")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaUsuarioEstabelecimento(UsuarioEstabelecimento usuario){
		  return new UsuarioEstabelecimentoBusiness().adiciona(usuario);
	  }
	  
	  //Altera um novo Usuário
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_usuario
	  @POST
	  @Path("/altera_usuario")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraUsuarioEstabelecimento(UsuarioEstabelecimento usuario){
		  return new UsuarioEstabelecimentoBusiness().alterar(usuario);
	  }
	  
	  //Remove usuário estabelecimento pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_usuario/{idUsuario}
	  @GET
	  @Path("/remove_usuario/{idUsuario}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeUsuarioEstabelecimento(@PathParam("idUsuario") long idUsuario){
		  return new UsuarioEstabelecimentoBusiness().remove(idUsuario);
	  }
	  
	  //> Busca Usuários pelo Nome deste
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_usuario/{nomeUsuario}
	  @GET
	  @Path("/busca_usuario/{nomeUsuario}")
	  public UsuarioEstabelecimentoList getUsuario(@PathParam("nomeUsuario") String nomeUsuario){
		  return new UsuarioEstabelecimentoBusiness().getUsuario(nomeUsuario);
	  }
	  
	  //> Lista Todos Usuários
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_todos_usuarios
	  @GET
	  @Path("/busca_todos_usuarios")
	  public UsuarioEstabelecimentoList getListaTodosUsuarios(){
		  return new UsuarioEstabelecimentoBusiness().getListaTodosUsuarios();
	  }
	  
	  
	   
	  
	  //#####################
	  //###ESTABELECIMENTO###
	  //#####################
	  
	  //Insere um novo Estabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_estabelecimento
	  @POST
	  @Path("/novo_estabelecimento")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaEstabelecimento(Estabelecimento estabelecimento){
		  return new EstabelecimentoBusiness().adiciona(estabelecimento);
	  }
	  
	  //Altera um novo Estabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_estabelecimento
	  @POST
	  @Path("/altera_estabelecimento")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraEstabelecimento(Estabelecimento estabelecimento){
		  return new EstabelecimentoBusiness().alterar(estabelecimento);
	  }
	  
	  //Remove Estabelecimento pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_estabelecimento/{idEstabelecimento}
	  @GET
	  @Path("/remove_estabelecimento/{idEstabelecimento}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento){
		  return new EstabelecimentoBusiness().remove(idEstabelecimento);
	  }
	  
	  //> Busca por Estabelecimento, recebendo o ID deste como parâmetro.
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_id/{idEstabelecimento}
	  @GET
	  @Path("/busca_estabelecimento_id/{idEstabelecimento}")
	  public Estabelecimento getEstebelecimento(@PathParam("idEstabelecimento") long id){
		  return new EstabelecimentoBusiness().getPorId(id);
	  }
	  
	  //> Busca por Todos Estabelecimentos no banco. OK
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_todos
	  @GET
	  @Path("/busca_estabelecimento_todos")
	  public EstabelecimentoList getListaTodosEstabelecimentos(){
		  return new EstabelecimentoBusiness().getListaTodos();
	  }
	  
	  //> Retornar a lista dos Estabelecimentos que tem algum ITEM de seu cardápio em PROMOÇÃO
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_promocao
	  @GET
	  @Path("/busca_estabelecimento_promocao")
	  public EstabelecimentoList getListaEstabelecimentoPorPromocao(){
		  return new EstabelecimentoBusiness().getListaPorPromocao();
	  }
	  
	  //> Retornar a lista dos Estabelecimentos passando o Nome do Estabelecimento
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_nome/{nomeEstabelecimento}
	  @GET
	  @Path("/busca_estabelecimento_nome/{nomeEstabelecimento}")
	  public EstabelecimentoList getListaEstabelecimentoPorNome(@PathParam("nomeEstabelecimento") String nomeEstabelecimento){
		  return new EstabelecimentoBusiness().getListaPorNome(nomeEstabelecimento);
	  }
	  
	  //> Retornar a lista dos Estabelecimentos passando o LOGIN do Usuário
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_login/{login}
	  @GET
	  @Path("/busca_estabelecimento_login/{login}")
	  public EstabelecimentoList getListaEstabelecimentoPorLogin(@PathParam("login") String login){
		  return new EstabelecimentoBusiness().getListaPorLogin(login);
	  }
	  
	  //> Retornar a lista dos Estabelecimentos passando a Cidade. 
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_cidade/{nomeCidade}
	  @GET
	  @Path("/busca_estabelecimento_cidade/{nomeCidade}")
	  public EstabelecimentoList getListaEstabelecimentoPorCidade(@PathParam("nomeCidade") String nomeCidade){
		  return new EstabelecimentoBusiness().getListaPorCidades(nomeCidade);
	  }
	  
	  
	  //> Retornar a lista dos Estabelecimentos passando a ID do Serviços selecionado, ex.: Todos estabelecimento que possuem "música ao vivo"
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_servico/{idServico}
	  @GET
	  @Path("/busca_estabelecimento_servico/{idServico}")
	  public EstabelecimentoList getEstebelecimentoPorServico(@PathParam("idServico") long idServico){
		  return new EstabelecimentoBusiness().getListaPorServicos(idServico);
	  }
	  
	  //>
	  // Lista todos Estabelecimentos pelos id do TipoEstabelecimento passado! Ex.: Lista de Estabelecimentos que são churrascarias.
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_tipo/{idTipo}
	  @GET
	  @Path("/busca_estabelecimento_tipo/{idTipo}")
	  public EstabelecimentoList getEstebelecimentoPorTipo(@PathParam("idTipo") long idTipo){
		  return new EstabelecimentoBusiness().getListaPorTipoEstabelecimento(idTipo);
	  }
	  
	  //#############
	  //##AVALIAÇÃO##
	  //#############
	  
	  //Insere uma nova Avaliacao
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_avaliacao
	  @POST
	  @Path("/novo_avaliacao")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaAvaliacao(Avaliacao avaliacao){
		  return new AvaliacaoBusiness().adiciona(avaliacao);
	  }
	  
	  //Altera uma Avaliação
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_avaliacao
	  @POST
	  @Path("/altera_avaliacao")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraAvaliacao(Avaliacao avaliacao){
		  return new AvaliacaoBusiness().alterar(avaliacao);
	  }
	  
	  //Remove Avaliação pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_avaliacao/{idAvaliacao}
	  @GET
	  @Path("/remove_avaliacao/{idAvaliacao}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeAvaliacao(@PathParam("idAvaliacao") long idAvaliacao){
		  return new AvaliacaoBusiness().remove(idAvaliacao);
	  }
	  
	  // Lista todas Avaliacoes pelos id do Estabelecimento Passado
	  // Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_avaliacao_por_estabelecimento/{idEstabelecimento}
	  @GET
	  @Path("/busca_avaliacao_por_estabelecimento/{idEstabelecimento}")
	  public AvaliacaoList getAvaliacaoPorIdEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento){
		  return new AvaliacaoBusiness().getListaPorIdEstabelecimento(idEstabelecimento);
	  }
	  
	  //##############
	  //###CARDÁPIO###
	  //##############
	  
	  //Adiciona um novo Cardápio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_cardapio
	  @POST
	  @Path("/novo_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaCardapio(Cardapio cardapio){
		  return new CardapioBusiness().adiciona(cardapio);
	  }
	  
	  //Altera uma Cardapio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_cardapio
	  @POST
	  @Path("/altera_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraCardapio(Cardapio cardapio){
		  return new CardapioBusiness().alterar(cardapio);
	  }
	  
	  //Remove Cardapio pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_cardapio/{idCardapio}
	  @GET
	  @Path("/remove_cardapio/{idCardapio}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeCardapio(@PathParam("idCardapio") long idCardapio){
		  return new CardapioBusiness().remove(idCardapio);
	  }
	  
	  //Retorna Cardapio referente ao ID do Estabelecimento Passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_cardapio_por_Estabelecimento/{idEstabelecimento}
	  @GET
	  @Path("/busca_cardapio_por_Estabelecimento/{idEstabelecimento}")
	  public Cardapio getCardapioPorIdEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento){
		  return new CardapioBusiness().getCardapioPorIdEstabelecimento(idEstabelecimento);
	  }
	  
	  //##############
	  //###ENDEREÇO###
	  //##############
	   
	  //Adiciona um novo Endereço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_endereco
	  @POST
	  @Path("/novo_endereco")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaEndereco(Endereco endereco){
		  return new EnderecoBusiness().adiciona(endereco);
	  }
	  
	  //Altera um Endereço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_endereco
	  @POST
	  @Path("/altera_endereco")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraEndereco(Endereco endereco){
		  return new EnderecoBusiness().alterar(endereco);
	  }
	  
	  //Remove Enderco pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_endereco/{idEndereco}
	  @GET
	  @Path("/remove_endereco/{idEndereco}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeEndereco(@PathParam("idEndereco") long idEndereco){
		  return new EnderecoBusiness().remove(idEndereco);
	  }
	  
	  //Retorna Endereco referente ao ID do Estabelecimento Passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_endereco_por_Estabelecimento/{idEstabelecimento}
	  @GET
	  @Path("/busca_endereco_por_Estabelecimento/{idEstabelecimento}")
	  public Endereco getEnderecoPorIdEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento){
		  return new EnderecoBusiness().getEnderecoPorIdEstabelecimento(idEstabelecimento);
	  }
	  
	  //###################
	  //###ITEM CARDAPIO###
	  //###################
	  
	  //Insere um novo Item Cardápio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_item_cardapio
	  @POST
	  @Path("/novo_item_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaItem(ItemCardapio itemCardapio){
		  return new ItemCardapioBusiness().adiciona(itemCardapio);
	  }
	  
	  //Altera um Item Cardapio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_item_cardapio
	  @POST
	  @Path("/altera_item_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraItem(ItemCardapio itemCardapio){
		  return new ItemCardapioBusiness().alterar(itemCardapio);
	  }
	  
	  //Remove ItemCardapio pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_item_cardapio/{idItemCardapio}
	  @GET
	  @Path("/remove_item_cardapio/{idItemCardapio}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeItem(@PathParam("idItemCardapio") long idItemCardapio){
		  return new ItemCardapioBusiness().remove(idItemCardapio);
	  }
	  
	  //Retorna uma lista de Itens Cardapio referente ao ID  da Secao
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_item_cardapio_lista/{idSecaoCardapio}
	  @GET
	  @Path("/busca_item_cardapio_lista/{idSecaoCardapio}")
	  @Produces(MediaType.APPLICATION_XML)
	  public ItemCardapioList getitemPorIdEstabelecimento(@PathParam("idSecaoCardapio") long idSecaoCardapio){
		  return new ItemCardapioBusiness().getItemListaPorIdSecaoIdCardapio(idSecaoCardapio);
	  }
	   
	  //Retorna Item Cardapio referente ao ID  do ItemCardapio passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_item_cardapio/{idItemCardapio}
	  @GET
	  @Path("/busca_item_cardapio/{idItemCardapio}")
	  @Produces(MediaType.APPLICATION_XML)
	  public ItemCardapio getItemPorIdItemCardapio(@PathParam("idItemCardapio") long idItemCardapio){
		  return new ItemCardapioBusiness().getItemPorIdItem(idItemCardapio);
	  }
	  
	  //####################
	  //###SEÇÃO CARDAPIO###
	  //####################
	  
	  //Insere um novo Seção Cardápio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_secao_cardapio
	  @POST
	  @Path("/novo_secao_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaSecaoCardapio(SecaoCardapio secaoCardapio){
		  return new SecaoCardapioBusiness().adiciona(secaoCardapio);
	  }
	  
	  //Altera uma Seção Cardapio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_secao_cardapio
	  @POST
	  @Path("/altera_secao_cardapio")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraSecaoCardapio(SecaoCardapio secaoCardapio){
		  return new SecaoCardapioBusiness().alterar(secaoCardapio);
	  }
	  
	  //Remove SecaoCardapio pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_secao_cardapio/{idSecaoCardapio}
	  @GET
	  @Path("/remove_secao_cardapio/{idSecaoCardapio}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeSecaoCardapio(@PathParam("idSecaoCardapio") long idSecaoCardapio){
		  return new SecaoCardapioBusiness().remove(idSecaoCardapio);
	  }
	  
	  //Retorna uma lista de Secao Cardapio referente ao ID do Cardapio
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_secao_cardapio/{idCardapio}
	  @GET
	  @Path("/busca_secao_cardapio/{idCardapio}")
	  public SecaoCardapioList getSecaoCardapioPorIdCardapio(@PathParam("idCardapio") long idCardapio ){
		  return new SecaoCardapioBusiness().getListaPorIdCardapio(idCardapio);
	  }
	  
	  //##############
	  //###SERVIÇOS###
	  //##############
	  
	  //Insere um novo Serviço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_servico
	  @POST
	  @Path("/novo_servico")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaServico(Servicos servicos){
		  return new ServicoBusiness().adiciona(servicos);
	  }
	  
	  //Altera uma Serviço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_servico
	  @POST
	  @Path("/altera_servico")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraServico(Servicos servicos){
		  return new ServicoBusiness().alterar(servicos);
	  }
	  
	  //Remove Serviço pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_servico/{idServico}
	  @GET
	  @Path("/remove_servico/{idServico}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeServico(@PathParam("idServico") long idServico){
		  return new ServicoBusiness().remove(idServico);
	  }
	  
	  //Retorna uma lista de Serviço referente ao ID do Estabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_servicos/{idEstabelecimento}
	  @GET
	  @Path("/busca_servicos/{idEstabelecimento}")
	  public ServicosList getSecaoListaServicoPorIdEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento ){
		  return new ServicoBusiness().getListaServicosPorIdEstabelecimento(idEstabelecimento);
	  }
	  
	  //Retorna uma lista de TODOS Servicos
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_todos_servicos
	  @GET
	  @Path("/busca_todos_servicos")
	  public ServicosList getListaServicos(){
		  return new ServicoBusiness().getListaServicos();
	  }
	  
	  //#############################
	  //###ESTABELECIMENTO_SERVICO###
	  //#############################
	  
	  //Insere um novo EstabelecimentoServiço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_estabelecimento_servico
	  @POST
	  @Path("/novo_estabelecimento_servico")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaEstabelecimentoServico(EstabelecimentoServico estabelecimentoServico){
		  return new EstabelecimentoServicoBusiness().adiciona(estabelecimentoServico);
	  }
	  
	  //Altera uma EstabelecimentoServiço
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_estabelecimento_servico
	  @POST
	  @Path("/altera_estabelecimento_servico")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraEstabelecimentoServico(EstabelecimentoServico estabelecimentoServico){
		  return new EstabelecimentoServicoBusiness().alterar(estabelecimentoServico);
	  }
	  
	  //Remove EstabelecimentoServiço pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_estabelecimento_servico/{idEstabelecimento}/{idServico}
	  @GET
	  @Path("/remove_estabelecimento_servico/{idEstabelecimento}/{idServico}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeEstabelecimentoServico(@PathParam("idEstabelecimento") long idEstabelecimento, @PathParam("idServico") long idServico){
		  return new EstabelecimentoServicoBusiness().remove(idEstabelecimento, idServico);
	  }
	  
	  //##########################
	  //###TIPO ESTABELECIMENTO###
	  //##########################
	  
	  //Insere um novo TipoEstabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_tipo_estabelecimento
	  @POST
	  @Path("/novo_tipo_estabelecimento")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento){
		  return new TipoEstabelecimentoBusiness().adiciona(tipoEstabelecimento);
	  }
	  
	  //Altera uma TipoEstabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_tipo_estabelecimento
	  @POST
	  @Path("/altera_tipo_estabelecimento")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento){
		  return new TipoEstabelecimentoBusiness().alterar(tipoEstabelecimento);
	  }
	  
	  //Remove TipoEstabelecimento pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_tipo_estabelecimento/{idTipoEstabelelcimento}
	  @GET
	  @Path("/remove_tipo_estabelecimento/{idTipoEstabelelcimento}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeTipoEstabelecimento(@PathParam("idTipoEstabelelcimento") long idTipoEstabelelcimento){
		  return new TipoEstabelecimentoBusiness().remove(idTipoEstabelelcimento);
	  }
	  
	  //Retorna uma lista de TipoEstabelecimento referente ao ID do Estabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_tipo_estabelecimento/{idEstabelecimento}
	  @GET
	  @Path("/busca_tipo_estabelecimento/{idEstabelecimento}")
	  public TipoEstabelecimentoList getSecaoListaTipoEstabelecimentoPorIdEstabelecimento(@PathParam("idEstabelecimento") long idEstabelecimento ){
		  return new TipoEstabelecimentoBusiness().getListaTipoEstabelecimentoPorIdEstabelecimento(idEstabelecimento);
	  }
	  
	  //Retorna uma lista de TODOS TipoEstabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/busca_todos_tipo_estabelecimento
	  @GET
	  @Path("/busca_todos_tipo_estabelecimento")
	  public TipoEstabelecimentoList getListaTipoEstabelecimento(){
		  return new TipoEstabelecimentoBusiness().getListaTipoEstabelecimento();
	  }  
	  
	  //##########################################
	  //###ESTABELECIMENTO TIPO ESTABELECIMENTO###
	  //##########################################
	  
	  //Insere um novo EstabelecimentoTipoEstabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/novo_estabelecimento_tipo
	  @POST
	  @Path("/novo_estabelecimento_tipo")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String adicionaEstabelecimentoTipoEstabelecimento(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		  return new EstabelecimentoTipoEstabelecimentoBusiness().adiciona(estabelecimentoTipoEstabelecimento);
	  }
	  
	  //Altera uma EstabelecimentoTipoEstabelecimento
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/altera_estabelecimento_tipo
	  @POST
	  @Path("/altera_estabelecimento_tipo")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String alteraEstabelecimentoTipoEstabelecimento(EstabelecimentoTipoEstabelecimento estabelecimentoTipoEstabelecimento){
		  return new EstabelecimentoTipoEstabelecimentoBusiness().alterar(estabelecimentoTipoEstabelecimento);
	  }
	  
	  //Remove EstabelecimentoTipoEstabelecimento pelo id passado
	  //Acesso: http://localhost:8080/cardapio.online/rest/recursos/remove_estabelecimento_tipo/{idEstabelecimentoTipo}/{idEstabelecimento}
	  @GET
	  @Path("/remove_estabelecimento_tipo/{idEstabelecimentoTipo}/{idEstabelecimento}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String removeEstabelecimentoTipoEstabelecimento(@PathParam("idEstabelecimentoTipo") long idEstabelecimentoTipo, @PathParam("idEstabelecimento") long idEstabelecimento){
		  return new EstabelecimentoTipoEstabelecimentoBusiness().remove(idEstabelecimentoTipo, idEstabelecimento);
	  }
	 
}

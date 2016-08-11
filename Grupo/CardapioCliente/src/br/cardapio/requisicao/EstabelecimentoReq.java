package br.cardapio.requisicao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.cardapio.bean.Estabelecimento;
import br.cardapio.listas.EstabelecimentoList;
public class EstabelecimentoReq {
	
	//Adiciona um novo estabelecimento!
	public String adiciona(Estabelecimento estabelecimento){
		
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Estabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(estabelecimento, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_estabelecimento");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
                                break;
			}
			conn.disconnect();

		} catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		
		return output;
	}
	
	public String altera(Estabelecimento estabelecimento){
		
	String output = "";	
	try{	
		Writer writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(Estabelecimento.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(estabelecimento, writer);

		URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_estabelecimento");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/xml");
		String input = writer.toString();
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        break;
		}
		conn.disconnect();

	} catch (IOException e) {
        e.printStackTrace();
    } catch (JAXBException e){
		e.printStackTrace();
	}
		return output;
	}
	
	//Excluir Estabelecimento
	public String remove(long idEstabelecimento){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_estabelecimento/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null){
				System.out.println(output);
                                break;
                        }
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
		}
		return output;
	}
	
	// Busca por Todos Estabelecimentos no banco. OK
	public EstabelecimentoList getListaEstabelecimentos(){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_todos");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}
	
	//> Retornar a lista dos Estabelecimentos que tem algum ITEM de seu card�pio em PROMO��O OK
	public EstabelecimentoList getListaEstabelecimentoPorPromocao(){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_promocao");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}
	
	//Retornar a lista dos Estabelecimentos passando o Nome do Estabelecimento OK
	public EstabelecimentoList getListaEstabelecimentoPorNome (String nomeEstabelecimento){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_nome/" + nomeEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}
	
	//Retornar a lista dos Estabelecimentos passando o LOGIN do USUARIO OK
        public EstabelecimentoList getListaEstabelecimentoPorLogin(String login){

                EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
                try{
                URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_login/" + login);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                if (con.getResponseCode() != 200) {
                        throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);

                System.out.println("------  Dados do Estabelecimento  -------- \n");
                System.out.println(estabelecimentoList.toString());
                con.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e){
                        e.printStackTrace();
                }
                return estabelecimentoList;
        }
	
        
        //Retornar o Estabelecimento passando o ID deste
        public Estabelecimento getEstabelecimentoPorId(Long idEstabelecimento){

                Estabelecimento estabelecimento  = new Estabelecimento();
                try{
                URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_id/" + idEstabelecimento);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                if (con.getResponseCode() != 200) {
                        throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                JAXBContext jaxbContext = JAXBContext.newInstance(Estabelecimento.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                estabelecimento = (Estabelecimento) jaxbUnmarshaller.unmarshal(br);

                System.out.println("------  Dados do Estabelecimento  -------- \n");
                System.out.println(estabelecimento.toString());
                con.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JAXBException e){
                        e.printStackTrace();
                }
                return estabelecimento;
        }
        
	//> Retornar a lista dos Estabelecimentos passando a Cidade. 
	public EstabelecimentoList getListaEstabelecimentoPorCidade (String nomeCidade){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_cidade/" + nomeCidade);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}	
	
	//> Retornar a lista dos Estabelecimentos passando a ID do Servi�os selecionado, ex.: Todos estabelecimento que possuem "m�sica ao vivo"
	public EstabelecimentoList getEstebelecimentoPorIdServico (long idServico){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_servico/" + idServico);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}	
	
	// Lista todos Estabelecimentos pelos id do TipoEstabelecimento passado! Ex.: Lista de Estabelecimentos que s�o churrascarias.
	public EstabelecimentoList getEstebelecimentoPorIdTipo (long idTipo){
		
		EstabelecimentoList estabelecimentoList  = new EstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_estabelecimento_tipo/" + idTipo);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        if (con.getResponseCode() != 200) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(EstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        estabelecimentoList = (EstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	
	        System.out.println("------  Dados do Estabelecimento  -------- \n");
	        System.out.println(estabelecimentoList.toString());
	        con.disconnect();
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return estabelecimentoList;
	}
}

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

import br.cardapio.bean.Servicos;
import br.cardapio.listas.ServicosList;

public class ServicoReq {
	public String adiciona (Servicos servicos){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Servicos.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(servicos, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_servico");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			
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
	
	
	public String altera (Servicos servicos){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Servicos.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(servicos, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_servico");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP c�digo de erro: " + conn.getResponseCode());
			
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
	
	public String remove(long idServico){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_servico/" + idServico);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200) 
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
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
	
	//Lista Todos Servicos
	public ServicosList getListaServicos (){
		ServicosList servicosList  = new ServicosList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_todos_servicos");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200)
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(ServicosList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        servicosList = (ServicosList) jaxbUnmarshaller.unmarshal(br);
	        System.out.println(servicosList.toString() + "\n");
	        con.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return servicosList;
	}	
	
	public ServicosList getListaServicoPorIdEstabelecimento (long idEstabelecimento){
		ServicosList servicosList  = new ServicosList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_servicos/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200)
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(ServicosList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        servicosList = (ServicosList) jaxbUnmarshaller.unmarshal(br);
	        System.out.println(servicosList.toString() + "\n");
	        con.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return servicosList;
	}	
}

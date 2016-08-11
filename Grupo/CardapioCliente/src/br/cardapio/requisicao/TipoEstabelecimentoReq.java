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

import br.cardapio.bean.TipoEstabelecimento;
import br.cardapio.listas.TipoEstabelecimentoList;

public class TipoEstabelecimentoReq {
	
	public String adiciona (TipoEstabelecimento tipoEstabelecimento){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(TipoEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(tipoEstabelecimento, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/novo_tipo_estabelecimento");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP código de erro: " + conn.getResponseCode());
			
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
	
	
	public String altera (TipoEstabelecimento tipoEstabelecimento){
		String output = "";	
		try{	
			Writer writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(TipoEstabelecimento.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(tipoEstabelecimento, writer);

			URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/altera_tipo_estabelecimento");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
			String input = writer.toString();
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			
			if (conn.getResponseCode() != 200)
				throw new RuntimeException("Erro : HTTP código de erro: " + conn.getResponseCode());
			
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
	
	public String remove(long idTipoEstabelecimento){
		String output = "";	
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/remove_tipo_estabelecimento/" + idTipoEstabelecimento);
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
	
	//Lista Todos Tipos Estabelecimentos
	public TipoEstabelecimentoList getListaTipoEstabelecimento (){
		TipoEstabelecimentoList tipoEstabelecimentoList  = new TipoEstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_todos_tipo_estabelecimento");
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200)
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(TipoEstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        tipoEstabelecimentoList = (TipoEstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	        System.out.println(tipoEstabelecimentoList.toString() + "\n");
	        con.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return tipoEstabelecimentoList;
	}	
	
	public TipoEstabelecimentoList getListaTipoEstabelecimentoPorIdEstabelecimento (long idEstabelecimento){
		TipoEstabelecimentoList tipoEstabelecimentoList  = new TipoEstabelecimentoList();
		try{
	        URL url = new URL("http://localhost:8080/cardapio.online/rest/recursos/busca_tipo_estabelecimento/" + idEstabelecimento);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        if (con.getResponseCode() != 200)
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        JAXBContext jaxbContext = JAXBContext.newInstance(TipoEstabelecimentoList.class);
	        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        tipoEstabelecimentoList = (TipoEstabelecimentoList) jaxbUnmarshaller.unmarshal(br);
	        System.out.println(tipoEstabelecimentoList.toString() + "\n");
	        con.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (JAXBException e){
			e.printStackTrace();
		}
		return tipoEstabelecimentoList;
	}	
}
